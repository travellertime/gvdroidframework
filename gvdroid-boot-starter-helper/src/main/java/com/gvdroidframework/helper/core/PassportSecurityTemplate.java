package com.gvdroidframework.helper.core;

import com.gvdroidframework.security.component.Token;
import com.gvdroidframework.security.component.TokenClaim;

/**
 * 登录凭证的生成、刷新、移除
 * 用户登录的时候，返回凭证、签发时间、到期刷新偏移量（该时长由应用层决定给）、到期时间给到前端
 * 前端在发起接口调用的时候，首先判断发起时间+偏移量是否大于到期时间，如果大于到期时间则调用token刷新接口刷新token，并且将刷新后的token给到前端处理
 */
public interface PassportSecurityTemplate {

    Token generateToken(TokenClaim tokenClaim);

    Token refreshToken(String refreshToken);

    TokenClaim getTokenClaim(String accessToken);
}
