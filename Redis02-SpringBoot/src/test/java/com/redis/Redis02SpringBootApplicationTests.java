package com.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redis.pojo.User;
import com.redis.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class Redis02SpringBootApplicationTests {
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private RedisUtil redisUtil;

    @Test
    void contextLoads() {
        //redisTemplate：操作不同的数据类型，API和指令是一样的
        //opsForValue：操作String字符串
        //opsForList：操作List列表
        //opsForSet：操作Set集合
        //opsForZSet：操作ZSet有序集合
        //opsForHash：操作Hash
        //opsForGeo：操作Geospatial地理位置
        //opsForHyperLogLog：操作Hyperloglogs基数统计

        //除了基本的操作，我们常用的方法都可以直接通过redisTemplate操作，比如事务和基本的CRUD

        //获取Redis的连接对象
        //RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        //connection.flushDb();
        //connection.flushAll();

        redisTemplate.opsForValue().set("mykey", "你好世界！");
        System.out.println(redisTemplate.opsForValue().get("mykey"));
    }

    @Test
    public void test() throws JsonProcessingException {
        //真实开发一般都使用Json来传递对象
        User user = new User("wyc", 18);
        //String jsonUser = new ObjectMapper().writeValueAsString(user);
        //redisTemplate.opsForValue().set("user", jsonUser);
        redisTemplate.opsForValue().set("user", user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

    @Test
    public void test2(){
        redisUtil.set("name", "wyc");
        System.out.println(redisUtil.get("name"));
    }
}
