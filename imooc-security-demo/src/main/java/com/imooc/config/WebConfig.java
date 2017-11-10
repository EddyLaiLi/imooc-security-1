package com.imooc.config;

import com.imooc.web.filter.TimeFilter;
import com.imooc.web.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.CallableProcessingInterceptor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shinelon
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{

//    private final TimeInterceptor interceptor;

//    @Autowired
//    public WebConfig(TimeInterceptor interceptor) {
//        this.interceptor = interceptor;
//    }

//    @Bean
//    public FilterRegistrationBean timeFilter() {
//        FilterRegistrationBean registry = new FilterRegistrationBean();
//
//        TimeFilter filter = new TimeFilter();
//        registry.setFilter(filter);
//
//        List<String> urls = new ArrayList<>();
//        urls.add("/*");
//        registry.setUrlPatterns(urls);
//
//        return registry;
//    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        super.addInterceptors(registry);
//        registry.addInterceptor(interceptor);
//    }
//
//    @Override
//    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
//        super.configureAsyncSupport(configurer);
//    }
}
