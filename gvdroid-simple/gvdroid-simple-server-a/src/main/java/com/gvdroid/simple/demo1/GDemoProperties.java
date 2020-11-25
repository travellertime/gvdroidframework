package com.gvdroid.simple.demo1;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "gd")
@RefreshScope
@Getter
@Setter
public class GDemoProperties {

    private String bbb;

    private List<String> list2;
    private List<String> list;

}
