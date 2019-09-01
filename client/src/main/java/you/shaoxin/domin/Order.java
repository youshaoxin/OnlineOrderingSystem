package you.shaoxin.domin;

import lombok.Data;

import java.util.Date;

/**
 * 功能:
 * 创建时间: 2019-08-29 10:43 --游菜花
 */
@Data
public class Order {
    private long id;
    private User user;
    private Menu menu;
    private Admin admin;
    private Date date;
    private int state;

}
