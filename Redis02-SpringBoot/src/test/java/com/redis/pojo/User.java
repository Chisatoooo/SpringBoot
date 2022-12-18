package com.redis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Author WYC
 * @Create 2022-11-05-下午 06:18
 **/
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
//在企业中，所有的pojo都会序列化
public class User implements Serializable {
    private String name;
    private int age;
}
