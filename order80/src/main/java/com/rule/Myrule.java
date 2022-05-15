package com.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wck
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年04月17日 19:32:00
 */
@Configuration
public class Myrule {
    @Bean
    public IRule mySelfRule(){
        return new RandomRule();
    }

}
