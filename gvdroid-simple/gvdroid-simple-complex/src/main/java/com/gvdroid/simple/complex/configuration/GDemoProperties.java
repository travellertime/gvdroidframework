/*
 * Copyright 2014-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
