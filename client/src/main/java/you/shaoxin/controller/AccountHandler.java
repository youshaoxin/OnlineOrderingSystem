package you.shaoxin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import you.shaoxin.domin.Admin;
import you.shaoxin.domin.User;
import you.shaoxin.feign.AccountFeign;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;

/**
 * 功能:
 * 创建时间: 2019-08-28 12:40 --游菜花
 */
@Controller
@RequestMapping("/account")
public class AccountHandler {

    @Autowired
    private AccountFeign accountFeign;

    /**
     * 功能:用户登录
    **/
    @PostMapping("/login")
    public String login(@RequestParam("username")String username, @RequestParam("password")String password, @RequestParam("type")String type, HttpSession session){

        Object object = accountFeign.login(username, password, type);

        //转换数据，因为Feign获取到的对象是LinkedHashMap类型
        LinkedHashMap<String,Object> linkedHashMap = (LinkedHashMap)object;

        String result = null;
        if (object == null){
            result = "login";//用户名密码错误，登录失败
        }else{
            switch (type){
                case "user"://普通用户登录
                    User user = new User();
                    user.setId(Long.parseLong(linkedHashMap.get("id")+""));
                    user.setNickname((String)(linkedHashMap.get("nickname")));
                    session.setAttribute("user",user);
                    result = "index";
                    break;
                case "admin"://管理员登录
                    Admin admin = new Admin();
                    admin.setId(Long.parseLong(linkedHashMap.get("id")+""));
                    admin.setUsername((String)(linkedHashMap.get("username")));
                    session.setAttribute("admin",admin);
                    result = "main";
                    break;
            }
        }
        System.out.println(object);
        return result;
    }

    /**
     * 功能:用户退出登录
    **/
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();//销毁session
        return "login";   //转发的方式
        //return "redirect:/login.html";//重定向的方式
    }





}
