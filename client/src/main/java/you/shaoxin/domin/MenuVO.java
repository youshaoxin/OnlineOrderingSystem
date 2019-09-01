package you.shaoxin.domin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 功能:返回数据的包装类，用于前端layui显示数据
 * 创建时间: 2019-08-26 17:02 --游菜花
 */
@Data
@AllArgsConstructor //带参构造
@NoArgsConstructor  //无参构造
public class MenuVO {
    /*
     *  注意：属性名一定要写对，以前端layui需要的格式包装返回
    **/
    private int code;
    private String msg;
    private int count;
    private List<Menu> data;
}
