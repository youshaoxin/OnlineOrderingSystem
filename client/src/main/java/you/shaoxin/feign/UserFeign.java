package you.shaoxin.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import you.shaoxin.domin.User;
import you.shaoxin.domin.UserVO;

import java.util.List;

/**
 * 功能:
 * 创建时间: 2019-08-27 21:45 --游菜花
 */
@FeignClient(value = "user")
public interface UserFeign {

    @GetMapping("/user/findAll/{index}/{limit}")
    public UserVO findAll(@PathVariable("index")int index, @PathVariable("limit") int limit);

    @GetMapping("/user/findById/{id}")
    public User findById(@PathVariable("id")long id);

    @GetMapping("/user/count")
    public int count();

    @PostMapping("/user/save")
    public void save(@RequestBody User user);//两个微服务之间传，要加注解@RequestBody

    @PutMapping("/user/update")
    public void update(@RequestBody User user);

    @GetMapping("/user/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id);

}
