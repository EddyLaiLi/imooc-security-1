package com.imooc.security.core.properties;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Shinelon
 */
@Getter
@Setter
public class ValidateCodeProperties {

    private ImageCodeProperties image = new ImageCodeProperties();

    private SmsCodeProperties sms = new SmsCodeProperties();

}
