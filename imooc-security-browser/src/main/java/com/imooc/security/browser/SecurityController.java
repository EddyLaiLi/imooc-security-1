package com.imooc.security.browser;

import com.imooc.security.core.properties.SecurityProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Shinelon
 */
@RestController
@Slf4j
public class SecurityController {

    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    private final SecurityProperties securityProperties;

    @Autowired
    public SecurityController(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    /**
     * 当需要身份认证时跳转
     *
     * @param req  request
     * @param resp response
     * @return ResponseEntity
     */
    @RequestMapping("/authentication/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public ResponseEntity<String> requireAuthentication(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        SavedRequest savedRequest = requestCache.getRequest(req, resp);

        if (savedRequest != null) {
            String target = savedRequest.getRedirectUrl();
            log.info("引发跳转的请求是{}", target);
            if (req.getHeader("accept").contains("text/html")) {
                redirectStrategy.sendRedirect(req, resp, securityProperties.getBrowser().getLoginPage());
            }
        }

        return new ResponseEntity<>("访问的服务需要登录认证,请引导用户到登录页", HttpStatus.UNAUTHORIZED);
    }

}
