package com.gvdroidframework.security.component;

/**
 * 该常量类用于创建token的时候，选择哪些字段来构造map.
 *
 * @author Colin
 * @since 3.0.0
 */
public interface JWTTokenClaim {

    /**
     * 用户编号
     */
    String KEY_USER = "#gvdroid.userId";

    /**
     * 机构编号
     */
    String KEY_ORG = "#gvdroid.orgId";

    /**
     * 角色
     */
    String KEY_ROLE = "#gvdroid.roles";

    /**
     * 权限
     */
    String KEY_PRIVILEGE = "#gvdroid.privileges";

    /**
     * 渠道编号
     */
    String KEY_CHANNEL = "#gvdroid.channel";

    /**
     * 实体编号
     */
    String KEY_ENTITY = "#gvdroid.entityId";


}
