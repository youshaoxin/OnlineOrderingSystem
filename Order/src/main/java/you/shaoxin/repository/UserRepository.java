package you.shaoxin.repository;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import you.shaoxin.domin.User;

import java.util.List;

/**
 * 游菜花 -
 * 创建时间: 2019-08-27 18:28
 */
@Mapper
@Component
public interface UserRepository {

    /**
     * 功能:根据用户id查询用户
    **/
    @Select("select * from t_user where id = #{id}")
    public User findById(long id);

}
