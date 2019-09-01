package you.shaoxin.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import you.shaoxin.domin.Menu;
import you.shaoxin.domin.MenuVO;
import you.shaoxin.domin.Type;

import java.util.List;


/**
 * 功能:Feign接口，关联到服务提供者menu里面的Controller，获取从数据库得到的数据
 * 创建时间: 2019-08-26 15:44 --游菜花
 */
@FeignClient(value = "menu")
public interface MenuFeign {

    /*
     * 功能:查询菜单
     **/
    @GetMapping("/menu/findAll/{index}/{limit}")
    MenuVO findAll(@PathVariable("index") int index, @PathVariable("limit")int limit);

    /*
     * 功能:根据menu删除菜品
     **/
    @DeleteMapping("/menu/deleteById/{id}")
    void deleteById(@PathVariable("id") long id);


    /*
     * 功能:查找所有菜品类别
     **/
    @GetMapping("menu/findTypes")
    List<Type> findTypes();

    /*
     * 功能:保存菜品
     **/
    @PostMapping("menu/save")
    void save(Menu menu);

    /*
     * 功能:根据id查询菜品
    **/
    @GetMapping("/menu/findById/{id}")
    Menu findById(@PathVariable("id") long id);

    /*
     * 功能:更新菜品信息
     **/
    @PutMapping("/menu/update")
    void update(Menu menu);
}
