package com.gvdroidframework.cloud.autoconfigure;//package com.gvdroidframework.cloud.api.configuration;
//
//import feign.Client;
//import feign.Feign;
//import lombok.RequiredArgsConstructor;
//import okhttp3.ConnectionPool;
//import okhttp3.OkHttpClient;
//import org.springframework.boot.autoconfigure.AutoConfigureBefore;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.cloud.commons.httpclient.OkHttpClientConnectionPoolFactory;
//import org.springframework.cloud.commons.httpclient.OkHttpClientFactory;
//import org.springframework.cloud.openfeign.FeignAutoConfiguration;
//import org.springframework.cloud.openfeign.support.FeignHttpClientProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//
//import java.util.concurrent.TimeUnit;
//
//@Configuration
//@ConditionalOnClass(Feign.class)
//@AutoConfigureBefore(FeignAutoConfiguration.class)
////@RequiredArgsConstructor
//public class FeignOkHttpConfiguration {
//
//    /**
//     * dev, test 环境打印出BODY
//     * @return HttpLoggingInterceptor
//     */
//    @Bean("httpLoggingInterceptor")
//    @Profile({"dev", "test", "local", "sit"})
//    public HttpLoggingInterceptor testLoggingInterceptor() {
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new OkHttpSlf4jLogger());
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        return interceptor;
//    }
//
////    /**
////     * ontest 环境 打印 请求头
////     * @return HttpLoggingInterceptor
////     */
////    @Bean("httpLoggingInterceptor")
////    @Profile("ontest")
////    public HttpLoggingInterceptor onTestLoggingInterceptor() {
////        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new OkHttpSlf4jLogger());
////        interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
////        return interceptor;
////    }
//
//    /**
//     * prod 环境只打印请求url
//     * @return HttpLoggingInterceptor
//     */
//    @Bean("httpLoggingInterceptor")
//    @Profile("prod")
//    public HttpLoggingInterceptor prodLoggingInterceptor() {
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new OkHttpSlf4jLogger());
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
//        return interceptor;
//    }
//
//    @Bean
//    @ConditionalOnMissingBean({Client.class})
//    public Client feignClient(okhttp3.OkHttpClient client) {
//        return new feign.okhttp.OkHttpClient(client);
//    }
//
//    @Bean
//    @ConditionalOnMissingBean({ConnectionPool.class})
//    public ConnectionPool httpClientConnectionPool(FeignHttpClientProperties httpClientProperties, OkHttpClientConnectionPoolFactory connectionPoolFactory) {
//        int maxTotalConnections = httpClientProperties.getMaxConnections();
//        long timeToLive = httpClientProperties.getTimeToLive();
//        TimeUnit ttlUnit = httpClientProperties.getTimeToLiveUnit();
//        return connectionPoolFactory.create(maxTotalConnections, timeToLive, ttlUnit);
//    }
//
//    @Bean
//    @ConditionalOnMissingBean(okhttp3.OkHttpClient.class)
//    public OkHttpClient client(OkHttpClientFactory httpClientFactory, ConnectionPool connectionPool, FeignHttpClientProperties httpClientProperties) {
//        boolean followRedirects = httpClientProperties.isFollowRedirects();
//        int connectTimeout = httpClientProperties.getConnectionTimeout();
//        boolean disableSslValidation = httpClientProperties.isDisableSslValidation();
//        return httpClientFactory.createBuilder(disableSslValidation)
//                .connectTimeout((long)connectTimeout, TimeUnit.MILLISECONDS)
//                .followRedirects(followRedirects)
//                .connectionPool(connectionPool)
//                .addInterceptor(new OkHttpLogInterceptor()) // 自定义请求日志拦截器
//                .build();
//    }
//}
