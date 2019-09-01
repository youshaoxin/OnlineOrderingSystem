package you.shaoxin.Repository;

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
     * 功能:查找所有用户
    **/
    @Select("select * from t_user limit #{index},#{limit}")
    public List<User> findAll(int index,int limit);

    /**
     * 功能:根据用户id查询用户
    **/
    @Select("select * from t_user where id = #{id}")
    public User findById(long id);

    /**
     * 功能:统计用户总数
    **/
    @Select("select count(id) from t_user")
    public int count();

    /**
     * 功能:更新用户
    **/
    @Update("update t_menu set username=#{username},password=#{password},nickname=#{nickname},gender=#{gender},telephone=#{telephone},registerdate=#{registerdate},address=#{address} where id = #{id}")
    public void update(User user);

    /**
     * 功能:保存用户
    **/
    @Insert("insert into t_user(username,password,nickname,gender,telephone,registerdate,address) values(#{username},#{password},#{nickname},#{gender},#{telephone},#{registerdate},#{address})")
    public void save(User user);

    /**
     * 功能:删除用户
    **/
    @Delete("delete from t_user where id = #{id}")
    public void deleteById(long id);

}
