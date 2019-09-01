package you.shaoxin.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import you.shaoxin.domin.Order;
import you.shaoxin.domin.OrderVO;

import java.util.List;

/**
 * 游菜花 -
 * 创建时间: 2019-08-31 08:28
 */
@FeignClient(value = "order")
public interface OrderFeign {

    /**
     * 功能:订购菜
    **/
    @PostMapping("/order/save")
    public void save(@RequestBody Order order);

    /**
     * 功能:查询用户订单
    **/
    @GetMapping("/order/findAllById/{index}/{limit}/{uid}")
    public OrderVO findAllById(@PathVariable("index")int index, @PathVariable("limit")int limit, @PathVariable("uid") long uid);

    /**
     * 功能:查询状态为未处理的订单
    **/
    @GetMapping("/order/findAllByState/{index}/{limit}")
    public OrderVO findAllByState(@PathVariable("index")int index, @PathVariable("limit")int limit);

    /**
     * 功能:处理为处理的订单
    **/
    @GetMapping("/order/updateState/{id}")
    public void updateState(@PathVariable("id")long id);

}
