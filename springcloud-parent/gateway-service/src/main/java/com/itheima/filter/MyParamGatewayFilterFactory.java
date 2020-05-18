package com.itheima.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

@Component
public class MyParamGatewayFilterFactory
        extends AbstractGatewayFilterFactory<MyParamGatewayFilterFactory.config> {

    private String PARAM = "name";
    //定义一个内部类
    public static  class config {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    //构造方法
    public MyParamGatewayFilterFactory(){
        super(MyParamGatewayFilterFactory.config.class);
    }


    /**
     * 处理参数的顺序
     * @return
     */
    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(PARAM);
    }

    /**
     * 处理逻辑
     * @param config
     * @return
     */
    @Override
    public GatewayFilter apply(config config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                String name = exchange.getRequest().getQueryParams().getFirst("name");
                System.out.println(name);
                return chain.filter(exchange);
            }
        };
    }
}
