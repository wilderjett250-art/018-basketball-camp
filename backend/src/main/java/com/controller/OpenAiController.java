package com.controller;

import com.alibaba.dashscope.aigc.generation.GenerationResult;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import com.utils.Main;
import com.utils.R;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通义千问AIController
 *后端接口
 */
@RestController
@RequestMapping("/openai")
public class OpenAiController {
    
    /**
         * 后端列表
         */
    @PostMapping("/openAi/{qwe}")
    public R openAi(@PathVariable String qwe) throws NoApiKeyException, InputRequiredException {

        GenerationResult r= Main.callWithMessage(qwe);
        System.out.println(r.toString());
        return R.ok(r.getOutput().getChoices().get(0).getMessage().getContent());
    }
}
