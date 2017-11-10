package com.imooc.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author Shinelon
 */
public interface ValidateCodeGenerator {

    /**
     * 生成图片验证码
     * @param request 请求
     * @return 验证码对象
     */
    ValidateCode generator(ServletWebRequest request);
}
