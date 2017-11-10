package com.imooc.security.core.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Shinelon
 */
@ConfigurationProperties(prefix = "imooc.security")
@Getter
@Setter
public class SecurityProperties {


    private BrowserProperties browser = new BrowserProperties();

    private ValidateCodeProperties code = new ValidateCodeProperties();

}
