package you.shaoxin.repository;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import you.shaoxin.domin.Order;
import java.util.List;

/**
 * 功能:
 * 创建时间: 2019-08-29 10:47 --游菜花
 */
@Mapper
@Component
public interface OrderRepository {

    @Insert("insert into t_order(uid,mid,date,state) values(#{user.id},#{menu.id},#{date},0)")
    public void save(Order order);

    /**
     * 功能:查询对应用户的所有订单
    **/
    @Select("select id,mid,date,state from t_order where uid = #{uid} limit #{index},#{limit}")
    @Results(id = "orderMap",value = {
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "date",property = "date"),
            @Result(column = "state",property = "state"),
            @Result(column = "mid",property = "menu",
                    one = @One(select = "you.shaoxin.repository.MenuRepository.findById"))
    })
    public List<Order> findAllById(int index,int limit,long uid);

    /**
     * 功能:查询总的订单
    **/
    @Select("select count(*) from t_order where uid = #{uid}")
    public int countById(long uid);

    /**
     * 功能:查询所有未处理的订单
    **/
    @Results(id = "orderStateMap",value = {
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "date",property = "date"),
            @Result(column = "state",property = "state"),
            @Result(column = "mid",property = "menu",
                    one = @One(select = "you.shaoxin.repository.MenuRepository.findById")),
            @Result(column = "uid",property = "user",
                    one = @One(select = "you.shaoxin.repository.UserRepository.findById"))
    })
    @Select("select id,mid,uid,date,state from t_order where state = 0 limit #{index},#{limit}")
    public List<Order> findAllByState(int index,int limit);

    /**
     * 功能:修改订单状态
    **/
    @Update("update t_order set state = 1 where id = #{id}")
    public void updateState(long id);

    /**
     * 功能:查询状态为未处理的订单
    **/
    @Select("select count(*) from t_order where state = 0")
    public int countByState();




}
