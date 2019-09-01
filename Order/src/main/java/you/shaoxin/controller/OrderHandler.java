package you.shaoxin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import you.shaoxin.domin.Order;
import you.shaoxin.domin.OrderVO;
import you.shaoxin.repository.OrderRepository;

import java.util.Date;

/**
 * 功能:
 * 创建时间: 2019-08-26 14:21 --游菜花
 */
@RestController
@RequestMapping("/order")
public class OrderHandler {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/save")
    public void save(@RequestBody Order order){
        order.setDate(new Date());
        System.out.println(order);
        orderRepository.save(order);
    }

    @GetMapping("/findAllById/{index}/{limit}/{uid}")
    public OrderVO findAllById(@PathVariable("index")int index, @PathVariable("limit")int limit, @PathVariable("uid")long uid){
        OrderVO orderVo = new OrderVO();
        orderVo.setMsg("");
        orderVo.setCount(orderRepository.countById(uid));
        orderVo.setData(orderRepository.findAllById(index,limit,uid));
        return orderVo;
    }

    @GetMapping("/countById/{uid}")
    public int countById(@PathVariable("uid")int uid){
        return orderRepository.countById(uid);
    }



    @GetMapping("/findAllByState/{index}/{limit}")
    public OrderVO findAllByState(@PathVariable("index")int index, @PathVariable("limit")int limit){
        OrderVO orderVo = new OrderVO();
        orderVo.setMsg("");
        orderVo.setCount(orderRepository.countByState());
        orderVo.setData(orderRepository.findAllByState(index,limit));
        return orderVo;
    }

    @GetMapping("/updateState/{id}")
    public void updateState(@PathVariable("id")long id){
        orderRepository.updateState(id);
    }


}