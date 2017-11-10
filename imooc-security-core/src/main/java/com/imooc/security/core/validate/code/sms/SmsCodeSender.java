package com.imooc.security.core.validate.code.sms;

/**
 * @author Shinelon
 */
public interface SmsCodeSender {

    void send(String mobile, String code);

}
