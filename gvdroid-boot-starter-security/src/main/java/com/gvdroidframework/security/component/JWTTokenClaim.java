package com.gvdroidframework.security.component;

/**
 * 该常量类用于创建token的时候，选择哪些字段来构造map.
 *
 * @author Colin
 * @since 3.0.0
 */
public interface JWTTokenClaim {

    String KEY_TOKEN_PREFIX = "gvdroid-token-";
    /**
     * 用户编号
     */
    String KEY_USER = "userId";

    /**
     * 机构编号
     */
    String KEY_ORG = "orgId";

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


}
