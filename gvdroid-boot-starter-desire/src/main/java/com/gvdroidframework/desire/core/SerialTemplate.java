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
package com.gvdroidframework.desire.core;

/**
 * 序号服务
 */
public interface SerialTemplate {

    /**
     * 根据传入的主键获取序号，每查询一次序号自动加一
     *
     * @param key       主键
     * @param valueDate 日期 format: 20201111
     * @return 序号
     */
    Integer serialInquiry(String key, String valueDate);

    /**
     * 根据传入的主键获取序号，当addRequired为true时，每查询一次序号自动加一
     *
     * @param key         主键
     * @param valueDate   日期 format: 20201111
     * @param addRequired 序号是否需要加一
     * @return 序号
     */
    Integer serialInquiry(String key, String valueDate, boolean addRequired);
}
