package com.kjlw.springboot1105.test;

import com.kjlw.springboot1105.Springboot1105Application;
import com.kjlw.springboot1105.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Springboot1105Application.class)
public class AppTest {
    
    @Autowired
    private RedisTemplate redisTemplate;
    
    @Test
    public void testRedisTemplate(){
        // 存d到redis数据库
        redisTemplate.opsForValue().set("hello","0708java");
        // 取
        String str =(String) redisTemplate.opsForValue().get("hello");
        System.out.println(str);
        User user = new User();
        user.setId(1);
        user.setUsername("丰丰");
        user.setPassword("123");
        user.setName("张瑞丰");
        redisTemplate.opsForValue().set("user",user);
        User user1 = (User)redisTemplate.opsForValue().get("user");
        System.out.println(user1);
    }

}
