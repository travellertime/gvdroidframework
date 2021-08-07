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
package com.gvdroidframework.util;

import com.gvdroidframework.base.component.BaseEntity;
import com.gvdroidframework.base.component.Context;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * 工具类用于创建Mongodb domain中的公共字段
 * 这个类在未来版本中会被取消，使用切面进行统一处理。
 *
 * @author Colin
 * @since 3.0.0
 */
public class BaseEntityUtils {

    /**
     * 构建Insert时的公共字段，创建时间由数据库生成
     *
     * @param baseEntity BaseCommonField
     * @param context    SessionContext
     */
    public static void buildInsert(BaseEntity baseEntity, Context context) {
        String orgId = !StringUtils.hasLength(context.getOrgId()) ? "" : context.getOrgId();
        String userId = !StringUtils.hasLength(context.getUserId()) ? "" : context.getUserId();

//        baseEntity.setCreateOrg(org);
//        baseEntity.setCreateUser(userId);
//        baseEntity.setUpdateOrg(org);
//        baseEntity.setUpdateUser(userId);
//        baseEntity.setUpdateNo(1);
        baseEntity.setCreateBy(userId);
        baseEntity.setCreateOrg(orgId);
        baseEntity.setEntityId(context.getEntityId());
    }

    /**
     * 构建Mysql Insert时的公共字段，使用Java应用程序时间
     *
     * @param baseEntity     BaseCommonField
     * @param context        SessionContext
     * @param createDateTime Date
     */
    public static void buildInsert(BaseEntity baseEntity, Context context, Date createDateTime) {

        String orgId = !StringUtils.hasLength(context.getOrgId()) ? "" : context.getOrgId();
        String userId = !StringUtils.hasLength(context.getUserId()) ? "" : context.getUserId();
//        baseEntity.setStatus(1);
//        baseEntity.setDeleted(false);
//        baseEntity.setCreateDate(createDateTime);
//        baseEntity.setCreateUser(userId);
//        baseEntity.setCreateOrg(org);
//        baseEntity.setUpdateDate(createDateTime);
//        baseEntity.setUpdateUser(userId);
//        baseEntity.setUpdateOrg(org);
//        baseEntity.setUpdateNo(1);
        baseEntity.setCreateBy(userId);
        baseEntity.setCreateAt(createDateTime);
        baseEntity.setUpdateAt(createDateTime);
        baseEntity.setCreateOrg(orgId);
        baseEntity.setEntityId(context.getEntityId());
    }

//    /**
//     * 构建Update时的公共字段
//     *
//     * @param baseEntity BaseCommonField
//     * @param context    SessionContext
//     */
//    public static void buildUpdate(BaseEntity baseEntity, Context context) {
//        baseEntity.setUpdateUser(context.getUserId());
//        baseEntity.setUpdateOrg(context.getOrgId());
//    }
}
