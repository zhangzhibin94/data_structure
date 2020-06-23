package com.zzb.utils.mybatis;

import com.zzb.utils.User;
import com.zzb.utils.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 张志斌
 * @date 19:42 2020/6/15
 * @description
 */
public class MyBatisDemo {
    private SqlSessionFactory sqlSessionFactory;
    public  SqlSessionFactory setSqlSessionFactory() throws IOException {
        String resouce = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resouce);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
        return sqlSessionFactory;
    }
    public static void main(String[] args) throws IOException {
        MyBatisDemo demo = new MyBatisDemo();
        SqlSessionFactory sqlSessionFactory = demo.setSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        List<User> users = mapper.find(user);
        System.out.println(users.toString());
    }
}
