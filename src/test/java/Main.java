import com.gaozhaoxi.db.DButil;
import com.gaozhaoxi.entity.User;
import com.gaozhaoxi.mapper.UserMapper;
import com.gaozhaoxi.transferBean.UserParams;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.xml.crypto.Data;
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


    //
    @Test
    public void test4(){
        SqlSession sqlSession=null;
        try{
            sqlSession=DButil.openSession();
            UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
            List<User> users=userMapper.getUserByAddressAndName("gao","123");
            System.out.println(users.toString());
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


    @Test
    //使用javabean 来传递参数
    public void test6(){
        SqlSession sqlSession=null;
        try{
            sqlSession= DButil.openSession();
            UserMapper userMapper=sqlSession.getMapper(UserMapper.class);

            UserParams userParams=new UserParams("gao","123");
            List<User> list=userMapper.getUserByAddressAndName3(userParams);
            System.out.println(list);
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

//插入数据（主键回填）
    @Test
    public void test7(){
        SqlSession sqlSession=null;
        try{
            sqlSession=DButil.openSession();
            UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
            User user1=new User(null,"li0","456","789");
            //myid 表示 受影响的行数。
            int myid=userMapper.insertUser1(user1);
            System.out.println("myid:"+myid+"|||||||"+"ID:"+user1.getId());
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

    @Test
    public void test8(){
        SqlSession sqlSession=null;
        try{
            sqlSession=DButil.openSession();
            UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
            User user=new User(null,"gao","45454","7878");
            //myid 表示 受影响的行数。
            int myid=userMapper.insertUser2(user);
            System.out.println("myid:"+myid+"|||||||"+"ID:"+user.getId());
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
