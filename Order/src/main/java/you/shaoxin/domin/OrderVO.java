package you.shaoxin.domin;

import lombok.Data;

import java.util.List;

/**
 * 功能:
 * 创建时间: 2019-08-31 20:12 --游菜花
 */
@Data
public class OrderVO {
    private int code;
    private String msg;
    private int count;
    private List<Order> data;

}
