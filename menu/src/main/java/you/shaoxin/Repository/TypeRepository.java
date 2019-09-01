package you.shaoxin.Repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import you.shaoxin.domin.Type;

import java.util.List;

/**
 * 功能:
 * 创建时间: 2019-08-27 09:19 --游菜花
 */
@Mapper
@Component
public interface TypeRepository {

    /**
     * 功能:根据id查找菜品类别
    **/
    @Select("select * from t_type where id = #{id}")
    public Type findById(int id);

    /**
     * 功能:查找所有菜品类别
    **/
    @Select("select * from t_type")
    public List<Type> findAll();

}
