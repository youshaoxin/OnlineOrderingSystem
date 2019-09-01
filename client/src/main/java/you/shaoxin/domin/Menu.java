package you.shaoxin.domin;

import lombok.Data;

/**
 * 功能:
 * 创建时间: 2019-08-26 14:53 --游菜花
 */
@Data
public class Menu {
    private long id;
    private String name;
    private double price;
    private String flavor;
    private int tid;
    private Type type;
}