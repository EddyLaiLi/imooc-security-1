package com.imooc.wiremock;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

/**
 * @author Shinelon
 */
public class MockServer {

    public static void main(String[] args) {
        configureFor(7060);
        removeAllMappings();

        stubFor(get(urlPathEqualTo("/order/1"))
                .willReturn(aResponse().withBody("{\"id\": 1}").withStatus(200)));
    }
}
