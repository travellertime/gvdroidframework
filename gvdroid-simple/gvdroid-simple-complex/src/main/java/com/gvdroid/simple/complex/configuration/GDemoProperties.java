package com.gvdroid.simple.complex.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "gd")
public class GDemoProperties {

    List<String> list;

//    Map<String, String> map;
//
//    Set<String> set;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

//    public Map<String, String> getMap() {
//        return map;
//    }
//
//    public void setMap(Map<String, String> map) {
//        this.map = map;
//    }
//
//    public Set<String> getSet() {
//        return set;
//    }
//
//    public void setSet(Set<String> set) {
//        this.set = set;
//    }
}
