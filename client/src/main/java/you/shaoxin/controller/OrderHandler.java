package you.shaoxin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import you.shaoxin.domin.Menu;
import you.shaoxin.domin.Order;
import you.shaoxin.domin.OrderVO;
import you.shaoxin.domin.User;
import you.shaoxin.feign.OrderFeign;

import javax.servlet.http.HttpSession;

/**
 * 功能:
 * 创建时间: 2019-08-31 08:25 --游菜花
 */
@Controller
@RequestMapping("/order")
public class OrderHandler {

    @Autowired
    private OrderFeign orderFeign;

    @GetMapping("/save/{mid}")
    public String save(@PathVariable("mid") int mid, HttpSession session){
        User user =(User)session.getAttribute("user");
        Order order = new Order();
        Menu menu = new Menu();
        menu.setId(mid);
        order.setUser(user);
        order.setMenu(menu);
        orderFeign.save(order);
        return "order";
    }

    /**
     * 功能:用户查看订单
     **/
    @GetMapping("/findAllById")
    @ResponseBody
    public OrderVO findAllById(@RequestParam("page")int page,@RequestParam("limit")int limit, HttpSession session){
        int index = (page-1)*limit;
        User user = (User)session.getAttribute("user");
        long uid = user.getId();
        return orderFeign.findAllById(index,limit,uid);
    }


    /**
     * 功能:查询状态为未处理的订单
    **/
    @GetMapping("/findAllByState")
    @ResponseBody
    public OrderVO findAllByState(@RequestParam("page")int page,@RequestParam("limit")int limit){
        int index = (page-1)*limit;
        OrderVO orderVO = orderFeign.findAllByState(index, limit);
        return orderVO;
    }

    /**
     * 功能:处理为处理的订单
     **/
    @GetMapping("/updateState/{id}")
    public String updateState(@PathVariable("id")long id){
        orderFeign.updateState(id);
        return "redirect:/menu/redirect/order_handler";
    }

}
