package com.imooc.web.async;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author Shinelon
 */
@Component
@Slf4j
public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {

    private final MockQueue queue;

    private final DeferredResultHolder resultHolder;

    @Autowired
    public QueueListener(MockQueue queue, DeferredResultHolder resultHolder) {
        this.queue = queue;
        this.resultHolder = resultHolder;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        new Thread(() -> {
            while (true) {
                if (StringUtils.isNotBlank(queue.getCompleteOrder())) {

                    String orderNumber = queue.getCompleteOrder();
                    log.info("返回订单处理结果" + orderNumber);
                    resultHolder.getMap().get(orderNumber).setResult("success");

                    queue.setCompleteOrder(null);
                } else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


    }
}
