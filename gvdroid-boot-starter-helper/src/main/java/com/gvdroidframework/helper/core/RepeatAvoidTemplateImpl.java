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

import com.gvdroidframework.base.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * 请求业务防重帮助类
 * <p>
 * 使用该方法必须要引入redis
 *
 * @author Colin
 * @version 3.1.1
 * @since 3.0.0
 */
@RequiredArgsConstructor
public class RepeatAvoidTemplateImpl implements RepeatAvoidTemplate {
    private final static String AVOID_REPEATED_CACHE_PREFIX = "gvdroidAvoid:repeatKey:";

    final RedisTemplate<String, String> redisTemplate;


    /**
     * 根据传入的业务关键词进行请求防重。
     * <p>
     * 在防重持续时间内只允许请求一次。
     *
     * @param keyword  防重关键词
     * @param duration 防重持续时间
     * @see #avoid(String, long, int)
     */
    @Override
    public void avoid(String keyword, long duration) {
        avoid(keyword, duration, 1);
    }

    /**
     * 根据传入的业务关键词进行请求防重。
     * <p>
     * 当传入的times 小于等于 1 的时候，在防重持续时间内会一直保持防重，直到超过防重时间为止。可以使用不带times的重构方法。
     * <p>
     * 当传入的times 大于 1 的时候，在防重持续时间内允许重复的次数等于times。
     * <p>
     * 当times 大于 1 的时候，再次提交直至触发防重条件之前，每次的防重过期时间都会被重置为duration。
     *
     * @param keyword  防重关键词
     * @param duration 防重持续时间
     * @param times    防重持续时间内的允许重复次数控制
     */
    @Override
    public void avoid(String keyword, long duration, int times) {
        // 使用防重前缀构造防重RedisKey
        String key = AVOID_REPEATED_CACHE_PREFIX + keyword;

        // 根据RedisKey获取值（该值代表请求防重时间内的实际请求次数）
        String value = redisTemplate.opsForValue().get(key);

        // 如果值不存在，则证明是第一次请求
        if (null == value) {
            // 此时将key和持续时间传以及防重允许次数写入Redis
            setRedis(key, duration, 1);
            // 直接返回，允许业务正常执行。
            return;
        }

        // 得到当前请求次数
        int tValue = Integer.parseInt(value);

        // 判断请求次数是否小于允许次数。
        if (tValue < times) {
            // 如果小于允许次数，则将次数+1设置到Redis中，并且将过期时间重新设置。
            setRedis(key, duration, tValue + 1);
            // 直接返回，允许业务正常执行。
            return;
        }

        // 如果请求次数不小于允许次数，则抛出异常。
        throw new BaseException("请求过于频繁，请稍后再试。", "810082");

    }


    //    /**
//     * 根据传入的业务关键词进行请求防重。
//     * <p>
//     * 在防重持续时间内只允许请求一次。
//     *
//     * @param keyword  防重关键词
//     * @param duration 防重持续时间
//     * @see #avoid(String, long, int)
//     * @return Boolean
//     */
//    public Boolean processAllow(String keyword, long duration) {
//        return processAllow(keyword, duration, 1);
//    }
//
//    /**
//     * 根据传入的业务关键词进行请求防重。
//     * <p>
//     * 当传入的times 小于等于 1 的时候，在防重持续时间内会一直保持防重，直到超过防重时间为止。可以使用不带times的重构方法。
//     * <p>
//     * 当传入的times 大于 1 的时候，在防重持续时间内允许重复的次数等于times。
//     * <p>
//     * 当times 大于 1 的时候，再次提交直至触发防重条件之前，每次的防重过期时间都会被重置为duration。
//     *
//     * @param keyword  防重关键词
//     * @param duration 防重持续时间
//     * @param times    防重持续时间内的允许重复次数控制
//     * @return boolean
//     */
//    public Boolean processAllow(String keyword, long duration, int times) {
//        // 使用防重前缀构造防重RedisKey
//        String key = AVOID_REPEATED_CACHE_PREFIX + keyword;
//
//        // 根据RedisKey获取值（该值代表请求防重时间内的实际请求次数）
//        String value = redisUtils.sync().get(key);
//
//        // 如果值不存在，则证明是第一次请求
//        if (null == value) {
//            // 此时将key和持续时间传以及防重允许次数写入Redis
//            setRedis(key, duration, 1);
//            // 直接返回，允许业务正常执行。
//            return true;
//        }
//
//        // 得到当前请求次数
//        int tValue = Integer.valueOf(value);
//
//        // 判断请求次数是否小于允许次数。
//        if (tValue < times) {
//            // 如果小于允许次数，则将次数+1设置到Redis中，并且将过期时间重新设置。
//            setRedis(key, duration, tValue + 1);
//            // 直接返回，允许业务正常执行。
//            return true;
//        }
//
//        // 如果请求次数不小于允许次数，则抛出异常。
//        return false;
//
//    }

    private void setRedis(String key, long duration, int times) {
        redisTemplate.opsForValue().set(key, String.valueOf(times));
        redisTemplate.expire(key, duration, TimeUnit.MILLISECONDS);
    }
}
