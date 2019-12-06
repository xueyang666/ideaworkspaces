package com.springboot.homework.springbootdemo01.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * <p>
 * description
 * </p>
 *
 * @author YANGXUE01@hand-china.com 2019/12/6  10:18
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    @Primary
    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory RedisConnectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(RedisConnectionFactory);
        return redisTemplate;
    }
}
