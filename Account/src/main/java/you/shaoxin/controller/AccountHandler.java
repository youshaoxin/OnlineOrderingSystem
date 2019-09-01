package you.shaoxin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import you.shaoxin.Repository.AdminRepository;
import you.shaoxin.Repository.UserRepository;

/**
 * 功能:
 * 创建时间: 2019-08-28 11:51 --游菜花
 */
@RestController
@RequestMapping("/account")
public class AccountHandler {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login/{username}/{password}/{type}")
    public Object login(@PathVariable("username")String username,@PathVariable("password")String password,@PathVariable("type")String type){
        Object object = null;
        switch (type){
            case "user":
                object = userRepository.login(username,password);
                break;
            case "admin":
                object = adminRepository.login(username,password);
                break;
        }
        return object;
    }



}
