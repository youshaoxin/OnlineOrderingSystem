package you.shaoxin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import you.shaoxin.Repository.UserRepository;
import you.shaoxin.domin.User;
import you.shaoxin.domin.UserVO;

import java.util.List;

/**
 * 功能:
 * 创建时间: 2019-08-27 19:13 --游菜花
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 功能:查找所有用户
     **/
    @GetMapping("/findAll/{index}/{limit}")
    public UserVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit){
        List<User> userlist = userRepository.findAll(index, limit);
        UserVO uservo = new UserVO(0,"",userRepository.count(),userlist);
        return uservo;
    }
    /**
     * 功能:根据用户id查询用户
     **/
    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id")long id){
        return userRepository.findById(id);
    }
    /**
     * 功能:统计用户总数
     **/
    @GetMapping("/count")
    public int count(){
        return userRepository.count();
    }

    /**
     * 功能:保存用户
     **/
    @PostMapping("/save")
    public void save(@RequestBody User user){
        userRepository.save(user);
    }

    /**
     * 功能:更新用户
     **/
    @RequestMapping("/update")
    public void update(@RequestBody User user){
        userRepository.update(user);
    }

    /**
     * 功能:删除用户
     **/
    @GetMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        userRepository.deleteById(id);
    }


}
