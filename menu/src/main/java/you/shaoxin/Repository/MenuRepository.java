package you.shaoxin.Repository;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import you.shaoxin.domin.Menu;

import java.util.List;

/**
 * 游菜花 -
 * 创建时间: 2019-08-26 14:54
 */
@Mapper
@Component
public interface MenuRepository {

    /**
     * 功能:首页查询所有菜单商品
     **/
    @Select("select * from t_menu limit #{index},#{limit}")
    @Results(id = "menuMap",value = {
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "price",property = "price"),
            @Result(column = "flavor",property = "flavor"),
            @Result(column = "tid",property = "type",
                    one = @One(select = "you.shaoxin.Repository.TypeRepository.findById"))

    })
    List<Menu> findAll(int index, int limit);


    /**
     * 功能:查询菜单总条数，用于分页显示总数据
     **/
    @Select("select count(id) from t_menu")
    int count();


    /**
     * 功能:根据id删除菜单
     **/
    @Delete("delete from t_menu where id = #{id}")
    void deleteById(long id);

    /**
     * 功能:根据id查找菜品
     **/
    @Select("select * from t_menu where id = #{id}")
    Menu findById(long id);


    /**
     * 功能:保存菜品
     **/
    @Insert("insert into t_menu(name,price,flavor,tid) values(#{name},#{price},#{flavor},#{tid})")
    void save(Menu menu);


    /**
     * 功能:更新菜品信息
     **/
    @Update("update t_menu set name=#{name},price=#{price},flavor=#{flavor},tid=#{tid} where id = #{id}")
    void update(Menu menu);




}
