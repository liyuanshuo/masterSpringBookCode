package com.cqu.mycache.mycache;

/**
 * @author : liyuanshuo
 * @version 1.0
 * @date : 2019/2/20 19:47
 * @description :  add description here
 */
public class UserMain {
    public static void main(String[] args) {
        UserService userService = new UserService();
        /* 开始查询账号 */

        /* 第一次查询，应该是数据库查询 */
        userService.getUserById("001001");
        /* 第二次查询，应该直接从缓存返回 */
        userService.getUserById("001001");

        /* 重置缓存 */
        userService.reload();
        System.out.println("重置缓存...");

        /* 应该是数据库查询 */
        userService.getUserById("001001");
        /* 第二次查询，应该直接从缓存返回 */
        userService.getUserById("001001");
    }
}
