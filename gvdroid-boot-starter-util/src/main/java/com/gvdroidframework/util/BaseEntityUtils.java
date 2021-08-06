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
