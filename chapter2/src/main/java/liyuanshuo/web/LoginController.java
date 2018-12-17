package liyuanshuo.web;

import liyuanshuo.domain.User;
import liyuanshuo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Author : liyuanshuo
 * @Date : 2018/12/12 11:09
 * @Description :
 * @Version 1.0
 */

//通过注解的方式，标注成为一个spring MVC的Controller
@Controller
public class LoginController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //负责处理index.html的请求
    @RequestMapping(value = "/index.html")
    public String loginPage(){
        return "login";
    }

    //通过注解的方式，负责处理loginCheck.html的请求
    @RequestMapping(value = "/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request, LoginCommand loginCommand){
        boolean isValidUser = userService.hasMatchUser(loginCommand.getUserName(), loginCommand.getPassword());

        if (!isValidUser){
            return new ModelAndView("login", "error", "用户名或密码错误");
        } else {
            User user = userService.findUserByName(loginCommand.getUserName());
            user.setLastIp(request.getLocalAddr());
            user.setLastVisit(new Date());
            userService.loginSuccess(user);
            request.getSession().setAttribute("user", user);
            return new ModelAndView("main");
        }

    }

}
