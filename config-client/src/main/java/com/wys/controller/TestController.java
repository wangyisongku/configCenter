package com.wys.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 当有请求/fresh节点的时候，会重新请求一次ConfigServer去拉取最新的配置文件
 * 请求/fresh需要有几点要求：1.加actuator的依赖 2.SpringCloud1.5以上需要设置 management.security.enabled=false
 * 这个Controller的作用是查看from这个key的值
 */
@RefreshScope // 加@RefreshScope是为了可以动态刷新这个Controller的Bean
@RequestMapping(value = "api")
@RestController
public class TestController {

    @Value("${wys.hello}")
    private String hello;

    @GetMapping(value = "hello")
    public String test(){
        return hello;
    }
}
