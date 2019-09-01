package you.shaoxin.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 功能:
 * 创建时间: 2019-08-28 12:46 --游菜花
 */
@FeignClient(value = "account")
public interface AccountFeign {

    @GetMapping("/account/login/{username}/{password}/{type}")
    public Object login(@PathVariable("username")String username, @PathVariable("password")String password, @PathVariable("type")String type);
}
