package org.example.blockhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.example.domain.User;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 统一处理限流降级的类
 */
public class BlockHandlerClass {
    /**
     * ②必须public static，限流与阻塞处理 : 参数要和 被降级的方法参数一样,可以多一个BlockException 参数
     */
    public User exceptionHandler(@PathVariable Long id, BlockException ex) {
        ex.printStackTrace();
        System.out.println("限流了2...");
        return new User(-2L, "限流了2", "限流了2");
    }
}
