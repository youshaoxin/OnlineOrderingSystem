package you.shaoxin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import you.shaoxin.domin.User;
import you.shaoxin.domin.UserVO;
import you.shaoxin.feign.UserFeign;

import java.util.Date;

/**
 * 功能:
 * 创建时间: 2019-08-27 21:49 --游菜花
 */
@Controller
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserFeign userFeign;

    /*
     * 功能:转化前端html，因为直接访问html时th标签内容无法解析
     **/
    @RequestMapping("/redirect/{location}")     //location是Html页面名称
    public String redirect(@PathVariable("location")String location){
        return location;
    }

    /**
     * 功能:查找所有用户
     **/
    @GetMapping("/findAll")
    @ResponseBody
    public UserVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        int index = (page-1)*limit; //分页的处理
        return userFeign.findAll(index,limit);
    }


    /**
     * 功能:根据用户id查询用户
     **/
    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id")long id){
        return userFeign.findById(id);
    }
    /**
     * 功能:统计用户总数
     **/
    @GetMapping("/count")
    public int count(){
        return userFeign.count();
    }

    /**
     * 功能:保存用户
     **/
    @PostMapping("/save")
    public String save(User user){
        user.setRegisterdate(new Date());
        userFeign.save(user);
        return "redirect:/user/redirect/user_manage";
    }

    /**
     * 功能:更新用户
     **/
    @RequestMapping("/update")
    public void update(User user){
        userFeign.update(user);
    }

    /**
     * 功能:删除用户
     **/
    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id){
        userFeign.deleteById(id);
        return "redirect:/user/redirect/user_manage";
    }

}
