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
package com.gvdroidframework.helper.core;

public interface RepeatAvoidTemplate {

    /**
     * 防止重复提交
     *
     * @param keyword  关键词
     * @param duration 多长时间内不允许再次提交（毫秒）
     */
    void avoid(String keyword, long duration);

    /**
     * 防止重复提交
     *
     * @param keyword  关键词
     * @param duration 多长时间内不允许再次提交（毫秒）
     * @param times    多长时间内允许提交的次数
     */
    void avoid(String keyword, long duration, int times);
}
