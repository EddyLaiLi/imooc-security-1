package com.imooc.web.async;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @author Shinelon
 */
@RestController
@Slf4j
public class AsyncController {

    private final MockQueue queue;
    private final DeferredResultHolder resultHolder;

    @Autowired
    public AsyncController(MockQueue queue, DeferredResultHolder resultHolder) {
        this.queue = queue;
        this.resultHolder = resultHolder;
    }


    @RequestMapping("/order")
    public DeferredResult<String> order() throws InterruptedException {
        log.info("主线程开始");

        String orderNumber = RandomStringUtils.randomNumeric(8);

        queue.setPlaceHolder(orderNumber);

        DeferredResult<String> deferredResult = new DeferredResult<>();

        resultHolder.getMap().put(orderNumber, deferredResult);
//        Callable<String> result = () -> {
//            log.info("副线程开始");
//            Thread.sleep(1000);
//            log.info("副线程返回");
//            return "success";
//        };
        log.info("主线程返回");
        return deferredResult;
    }
}
