package com.zlz.website.blog.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * mybatis-plus配置类
 *
 * @author zhulinzhong
 * @version 1.0 CreateTime:2020/1/16 10:27
 */
@EnableTransactionManagement
@Configuration
public class BeanRegister {

    private static final String DATE_TIME_FORMATTER = "yyyy-MM-dd HH:mm:ss";

    /**
     * 分页插件
     */
    @Bean
    public MybatisPlusInterceptor paginationInterceptor() {
        MybatisPlusInterceptor paginationInterceptor = new MybatisPlusInterceptor();
        // paginationInterceptor.setLimit(你的最大单页限制数量，默认 500 条，小于 0 如 -1 不受限制);
        return paginationInterceptor;
    }

    /**
     * 解决Jackson导致Long型数据精度丢失问题
     *
     * @return Jackson2ObjectMapperBuilderCustomizer
     */
    @Bean("jackson2ObjectMapperBuilderCustomizer")
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return jacksonObjectMapperBuilder -> jacksonObjectMapperBuilder
                .serializerByType(Long.class, ToStringSerializer.instance)
                .serializerByType(Long.TYPE, ToStringSerializer.instance)
                .serializerByType(Date.class, new DateSerializer(
                        false, new SimpleDateFormat(DATE_TIME_FORMATTER)))
                .deserializerByType(LocalDateTime.class, new LocalDateTimeDeserializer(
                        DateTimeFormatter.ofPattern(DATE_TIME_FORMATTER)));
    }

    /**
     * 封装一层的RedisTemplate，避免强制类型转换错误
     *
     * @param redisConnectionFactory
     * @return
     */
//    @Bean
//    public RedisTemplate<Object, EmailRedisTemplate> emailRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<Object, EmailRedisTemplate> template = new RedisTemplate<>();
//        template.setConnectionFactory(redisConnectionFactory);
//        Jackson2JsonRedisSerializer<EmailRedisTemplate> jackson2JsonRedisSerializer =
//                new Jackson2JsonRedisSerializer<>(EmailRedisTemplate.class);
//        template.setDefaultSerializer(jackson2JsonRedisSerializer);
//        return template;
//    }

}
