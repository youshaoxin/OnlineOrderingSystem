package you.shaoxin.domin;

import lombok.Data;

import java.util.Date;

/**
 * 功能:
 * 创建时间: 2019-08-27 18:23 --游菜花
 */
@Data
public class User {

    private long id;
    private String username;
    private String password;
    private String nickname;
    private String gender;
    private String telephone;
    private Date registerdate;
    private String address;

}
