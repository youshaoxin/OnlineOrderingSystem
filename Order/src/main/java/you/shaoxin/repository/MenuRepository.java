package you.shaoxin.repository;

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
     * 功能:根据id查找菜品
     **/
    @Select("select * from t_menu where id = #{mid}")
    Menu findById(long mid);




}
