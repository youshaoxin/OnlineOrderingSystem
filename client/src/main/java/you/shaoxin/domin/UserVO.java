package you.shaoxin.domin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 功能:
 * 创建时间: 2019-08-27 22:46 --游菜花
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    private int code;
    private String msg;
    private int count;
    private List<User> data;

}
