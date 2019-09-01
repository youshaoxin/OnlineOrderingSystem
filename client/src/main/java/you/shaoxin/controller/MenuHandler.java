package you.shaoxin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import you.shaoxin.domin.Menu;
import you.shaoxin.domin.MenuVO;
import you.shaoxin.domin.Type;
import you.shaoxin.feign.MenuFeign;

import java.util.List;


/**
 * 功能:
 * 创建时间: 2019-08-26 15:54 --游菜花
 */
@Controller
@RequestMapping("/menu")
public class MenuHandler {

    //注入Feign接口，Feign接口关联到服务提供者menu里面的Controller，获取从数据库得到的数据
    @Autowired
    private MenuFeign menuFeign;

    /*
     * 功能:查询菜单
    **/
    @GetMapping("/findAll")
    @ResponseBody  //返回数据，不返回视图
    public MenuVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        int index = (page-1)*limit; //分页的处理
        return menuFeign.findAll(index,limit);//把打包的json数据返回到html页面
    }


    /*
     * 功能:转化前端html，因为直接访问html时th标签内容无法解析
    **/
    @RequestMapping("/redirect/{location}")     //location是Html页面名称
    public String redirect(@PathVariable("location")String location){
        return location;
    }


    /*
     * 功能:根据menu删除菜品
    **/
    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id){
        System.out.println("id:"+id);
        menuFeign.deleteById(id);
        //因为前端的查询所有数据是通过HTML页面的异步请求查找的，所以需要先跳转到html页面，再执行异步请求的方法
        return "redirect:/menu/redirect/menu_manage";
    }


    /*
     * 功能:查找所有菜品类别
     **/
    @GetMapping("/findTypes")
    public ModelAndView findTypes(){
        ModelAndView mv = new ModelAndView();
        List<Type> list = menuFeign.findTypes();
        mv.addObject("list",list);
        mv.setViewName("menu_add");
        return mv;
    };


    /*
     * 功能:保存菜品
    **/
    @PostMapping("/save")
    public String save(Menu menu){
        menuFeign.save(menu);
        return "redirect:/menu/redirect/menu_manage";
    }


    /*
     * 功能:编辑菜品，先通过id查找菜品
    **/
    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id") long id){
        //根据id查找到菜品
        Menu menu = menuFeign.findById(id);
        //修改页面查找所有类别
        List<Type> list = menuFeign.findTypes();

        ModelAndView mv = new ModelAndView();
        mv.addObject("menu",menu);
        mv.addObject("list",list);
        mv.setViewName("menu_update");
        return mv;

    }

    /*
     * 功能:更新菜品信息
    **/
    @PostMapping("/update")
    public String update(Menu menu){
        menuFeign.update(menu);
        return "redirect:/menu/redirect/menu_manage";
    }

}
