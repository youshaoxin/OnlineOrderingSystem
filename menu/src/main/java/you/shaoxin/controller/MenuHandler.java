package you.shaoxin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import you.shaoxin.Repository.MenuRepository;
import you.shaoxin.Repository.TypeRepository;
import you.shaoxin.domin.Menu;
import you.shaoxin.domin.MenuVO;
import you.shaoxin.domin.Type;

import java.util.List;

/**
 * 功能:对外开放接口Handler,在client客户端的Feign调用这里的Handler
 * 创建时间: 2019-08-26 14:52 --游菜花
 */
@RestController
@RequestMapping("/menu")
public class MenuHandler {

    @Value("${server.port}")
    private String port;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private TypeRepository typeRepository;

    /**
     * 功能:查询所有菜单商品
     **/
    @GetMapping("/findAll/{index}/{limit}")
    public MenuVO findAll(@PathVariable("index") int index,@PathVariable("limit") int limit){
        List<Menu> menuList = menuRepository.findAll(index, limit);
        MenuVO menuVO = new MenuVO(0,"",menuRepository.count(),menuList);
        return menuVO;
    }

    /**
     * 功能:返回当前服务端口
    **/
    @GetMapping("/index")
    public String index(){
        return this.port;
    }


    /**
     * 功能:根据id删除菜品
    **/
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        menuRepository.deleteById(id);
    }

    /**
     * 功能:查找所有菜品类别
     **/
    @GetMapping("/findTypes")
    public List<Type> findTypes(){
        return typeRepository.findAll();
    }

    /**
     * 功能:保存菜品
     **/
    @PostMapping("/save")
    public void save(@RequestBody Menu menu){//这里要加requestbody,因为传过来的是json数据，需要用requestbody修饰
        menuRepository.save(menu);
    }

    /**
     * 功能:根据id查找菜品
    **/
    @GetMapping("/findById/{id}")
    public Menu findById(@PathVariable("id") long id){
        return menuRepository.findById(id);
    }

    /**
     * 功能:更新菜品信息
    **/
    @PutMapping("/update")
    public void update(@RequestBody Menu menu){//这里要加requestbody,因为传过来的是json数据，需要用requestbody修饰
        menuRepository.update(menu);
    }
}
