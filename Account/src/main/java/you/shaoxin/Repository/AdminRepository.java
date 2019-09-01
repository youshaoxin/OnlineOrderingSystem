package you.shaoxin.Repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import you.shaoxin.domin.Admin;

/**
 * 功能:
 * 创建时间: 2019-08-28 11:45 --游菜花
 */
@Mapper
@Component
public interface AdminRepository {

    @Select("select * from t_admin where username = #{username} and password=#{password}")
    public Admin login(String username,String password);
}
