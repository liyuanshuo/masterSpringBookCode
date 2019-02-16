package com.cqu.dao;

import com.cqu.domain.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;


/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/16 15:38
 * @description :  add description here
 */
@Repository
public class ForumDao {

    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void initDb(){
        String sql = "create table t_user(user_id int primary key,user_name varchar(60))";
        jdbcTemplate.execute(sql);
    }

    public void addForum(final Forum forum){
        final String sql = "INSERT INTO t_forum(forum_name,forum_desc) VALUES(?,?)";
        final Object[] params = new Object[]{forum.getForumName(), forum.getForumDesc()};

        /*
        四种方式更新数据
         */

        // 1.
        //jdbcTemplate.update(sql, params);

        //2.
        //jdbcTemplate.update(sql, params, new int[]{Types.VARCHAR, Types.VARCHAR});

        //3.
        //jdbcTemplate.update(sql, new PreparedStatementSetter() {
        //    public void setValues(PreparedStatement ps) throws SQLException {
        //        ps.setString(1, forum.getForumName());
        //        ps.setString(2, forum.getForumDesc());
        //    }
        //});

        // 4.
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, forum.getForumName());
                preparedStatement.setString(2, forum.getForumDesc());
                return preparedStatement;
            }
        }, keyHolder);
        forum.setForumId(keyHolder.getKey().intValue());
    }

    public void addForumByNamedParams(final Forum forum) {
        final String sql = "INSERT INTO t_forum(forum_name, forum_desc) VALUES(:forumName,:forumDesc)";
        SqlParameterSource sps = new BeanPropertySqlParameterSource(forum);
        namedParameterJdbcTemplate.update(sql, sps);
    }

    public void addForums(final List<Forum> forums) {
        final String sql = "INSERT INTO t_forum(forum_name,forum_desc) VALUES(?,?)";
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            public int getBatchSize() {
                return forums.size();
            }

            public void setValues(PreparedStatement ps, int index)
                    throws SQLException {
                Forum forum = forums.get(index);
                ps.setString(1, forum.getForumName());
                ps.setString(2, forum.getForumDesc());
            }
        });
    }

    public Forum getForum(final int forumId) {
        String sql = "SELECT forum_name,forum_desc FROM t_forum WHERE forum_id=?";
        final Forum forum = new Forum();

        jdbcTemplate.query(sql, new Object[] { forumId },
                new RowCallbackHandler() {
                    public void processRow(ResultSet rs) throws SQLException {
                        forum.setForumId(forumId);
                        forum.setForumName(rs.getString("forum_name"));
                        forum.setForumDesc(rs.getString("forum_desc"));
                    }
                });
        return forum;
    }


    public List<Forum> getForums(final int fromId, final int toId) {
        String sql = "SELECT forum_id,forum_name,forum_desc FROM t_forum WHERE forum_id between ? and ?";
        // 方法1：使用RowCallbackHandler接口
        /*
         * final List<Forum> forums = new ArrayList<Forum>();
         * jdbcTemplate.query(sql,new Object[]{fromId,toId},new
         * RowCallbackHandler(){ public void processRow(ResultSet rs) throws
         * SQLException { Forum forum = new Forum();
         * forum.setForumId(rs.getInt("forum_id"));
         * forum.setForumName(rs.getString("forum_name"));
         * forum.setForumDesc(rs.getString("forum_desc")); forums.add(forum);
         * }}); return forums;
         */

        return jdbcTemplate.query(sql, new Object[] { fromId, toId },
                new RowMapper<Forum>() {
                    public Forum mapRow(ResultSet rs, int index)
                            throws SQLException {
                        Forum forum = new Forum();
                        forum.setForumId(rs.getInt("forum_id"));
                        forum.setForumName(rs.getString("forum_name"));
                        forum.setForumDesc(rs.getString("forum_desc"));
                        return forum;
                    }
                });

    }

    int getForumNum() {
        return 0;
    };
}
