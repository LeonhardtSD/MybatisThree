import com.gaozhaoxi.db.DButil;
import com.gaozhaoxi.entity.User;
import com.gaozhaoxi.mapper.UserMapper;
import lombok.Data;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Leon
 */
public class Main {
    @Test
    public void test2(){
        SqlSession sqlSession=null;
        try {
            sqlSession= DButil.openSession();
            UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
            User user=userMapper.getUser(1L);
            System.out.println(user.toString());
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }
    }


    //单元测试
    @Test
    public void test3(){
        SqlSession sqlSession=null;
        try {
            sqlSession=DButil.openSession();
            UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
            Map<String,String>map=new HashMap<>();
            map.put("address","123");
            map.put("userName","gao");
            List<User> users=userMapper.getUserByAddressAndName2(map);
            System.out.print(users.toString());
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            if(sqlSession!=null){
                sqlSession.close();
            }
        }
    }
}
