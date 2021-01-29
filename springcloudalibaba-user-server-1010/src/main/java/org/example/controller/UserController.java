package org.example.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.example.blockhandler.BlockHandlerClass;
import org.example.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RefreshScope 配置了，自动刷新配置信息
 */
@RefreshScope
@RestController
public class UserController {

    /**
     * 2.读取云端的配置：云端-->到本地--读取
     */
    @Value("${temp.notify}")
    private String notify;

    /**
     * 1.普通的返回用户信息
     * 3.增加限流降级
     * ①在本类中：限流降级@SentinelResource,value资源名称，blockHandler降级方法,在方法①中
     * ②在公共类中：限流降级@SentinelResource,value资源名称，blockHandler降级方法,blockHandlerClass降级类
     */
    @GetMapping("/user/{id}")
    @SentinelResource(value="getById",blockHandlerClass = BlockHandlerClass.class,blockHandler="exceptionHandler")
    public User getById(@PathVariable Long id) {
        System.out.println("===>>test.notify="+notify);
        return new User(id, "张三:" + id, "我是张三"+id+"，我很牛！");
    }

    /**
     * ①必须public ，这里静态和非静态效果一样,建议非静态，限流与阻塞处理 : 参数要和 被降级的方法参数一样
     */
    public User exceptionHandler(@PathVariable Long id, BlockException ex) {
        ex.printStackTrace();
        System.out.println("限流了...");
        return new User(-1L,"限流了","限流了");
    }

}
