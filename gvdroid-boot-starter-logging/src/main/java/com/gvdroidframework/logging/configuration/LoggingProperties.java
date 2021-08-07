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
package com.gvdroidframework.logging.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 业务日志配置属性
 *
 * @author XIEZHONG
 */
@ConfigurationProperties(prefix = "gvdroid.business.logging")
public class LoggingProperties {

    private boolean enabled;

    private String env;

    private String method;

    private Integer category;

    private Mq mq;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Mq getMq() {
        return mq;
    }

    public void setMq(Mq mq) {
        this.mq = mq;
    }


    public static class Mq {
        private String name;
        private String routing;
        private String exchange;
        private boolean queueDurable = true;
        private boolean queueAutoDelete = false;
        private boolean exchangeDurable = true;
        private boolean exchangeAutoDelete = false;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRouting() {
            return routing;
        }

        public void setRouting(String routing) {
            this.routing = routing;
        }

        public String getExchange() {
            return exchange;
        }

        public void setExchange(String exchange) {
            this.exchange = exchange;
        }

        public boolean isQueueDurable() {
            return queueDurable;
        }

        public void setQueueDurable(boolean queueDurable) {
            this.queueDurable = queueDurable;
        }

        public boolean isQueueAutoDelete() {
            return queueAutoDelete;
        }

        public void setQueueAutoDelete(boolean queueAutoDelete) {
            this.queueAutoDelete = queueAutoDelete;
        }

        public boolean isExchangeDurable() {
            return exchangeDurable;
        }

        public void setExchangeDurable(boolean exchangeDurable) {
            this.exchangeDurable = exchangeDurable;
        }

        public boolean isExchangeAutoDelete() {
            return exchangeAutoDelete;
        }

        public void setExchangeAutoDelete(boolean exchangeAutoDelete) {
            this.exchangeAutoDelete = exchangeAutoDelete;
        }

    }
}
