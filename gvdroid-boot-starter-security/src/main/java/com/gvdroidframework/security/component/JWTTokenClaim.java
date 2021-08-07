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
package com.gvdroidframework.security.component;

/**
 * 该常量类用于创建token的时候，选择哪些字段来构造map.
 *
 * @author Colin
 * @since 3.0.0
 */
public interface JWTTokenClaim {

//    String KEY_TOKEN_PREFIX = "gvdroid:tokenAccess:";

    String KEY_REFRESH_TOKEN_PREFIX = "gvdroid:tokenRefresh:";

    /**
     * 用户编号
     */
    String KEY_USER = "userId";

    /**
     * 角色
     */
    String KEY_ROLE = "roles";

    /**
     * 权限
     */
    String KEY_PRIVILEGE = "privileges";

    /**
     * 渠道编号
     */
    String KEY_CHANNEL = "channel";

    /**
     * 实体编号
     */
    String KEY_ENTITY = "entityId";

    /**
     * 过期时间秒数
     */
    String KEY_EXPIRES_IN = "expiresIn";
}
