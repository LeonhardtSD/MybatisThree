package com.gaozhaoxi.mapper;

import com.gaozhaoxi.entity.User;
import com.gaozhaoxi.transferBean.UserParams;
import org.apache.ibatis.annotations.Param;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Leon
 */
public interface UserMapper {
    public User getUser(Long id);

    //使用@Param注解 解决select多条件查询（即传递一个对象）
//    在数据提交的过程中，mybatis会以@Param提供的名称为准，所以@Param（）中的名称要与userMapper.xml的参数对应上
    public List<User> getUserByAddressAndName(@Param("username") String userName, @Param("address") String address);

    //使用Map集合传递参数
    public ArrayList<User> getUserByAddressAndName2(Map<String,String> map);

    //使用JavaBean传递参数
    public ArrayList<User> getUserByAddressAndName3(UserParams params);

    //插入数据(主键回填)
    public int insertUser1(User user);

    //插入数据（insert中主键自定义）
    public int insertUser2(User user);
}
