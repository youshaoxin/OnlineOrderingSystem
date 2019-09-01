package you.shaoxin.Repository;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import you.shaoxin.domin.User;

/**
 * 功能:
 * 创建时间: 2019-08-28 11:45 --游菜花
 */
@Mapper
@Component
public interface UserRepository {

    @Select("select * from t_user where username = #{username} and password=#{password}")
    public User login(String username, String password);

}
