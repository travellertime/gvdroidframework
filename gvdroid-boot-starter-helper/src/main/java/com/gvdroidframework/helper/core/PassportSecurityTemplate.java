package com.gvdroidframework.helper.core;

import com.gvdroidframework.security.component.Token;
import com.gvdroidframework.security.component.TokenClaim;

/**
 * 登录凭证的生成、刷新、移除
 * 用户登录的时候，返回凭证、签发时间、到期刷新偏移量（该时长由应用层决定给）、到期时间给到前端
 * 前端在发起接口调用的时候，首先判断发起时间+偏移量是否大于到期时间，如果大于到期时间则调用token刷新接口刷新token，并且将刷新后的token给到前端处理
 */
public interface PassportSecurityTemplate {

//    /**
//     * 根据tokenClaim生成accessToken和refreshToken,
//     * accessToken的有效时间为tokenClaim里的expiresIn（秒）
//     * refreshToken的有效时间为accessToken有效时间的两倍
//     *
//     * @param tokenClaim token请求参数
//     * @return token
//     */
//    Token generateToken(TokenClaim tokenClaim);

    /**
     * 使用refreshToken重新生成accessToken
     * 重新生成的accessToken的有效时间等于上次accessToken的时间
     * 仅当refreshToken在有效时间内才能够重新生成accessToken
     *
     * 当并发调用的时候，会采用分布式锁将线程锁住，只允许一个线程进行处理
     * 获得锁的线程，到redis中获取accessToken，如果存在则直接返回
     * 如果不存在则生成token并写入redis中，锁的最长时间为10s
     *
     *
     * @param refreshToken refreshToken
     * @return Token
     */
    Token refreshToken(String refreshToken);

//    /**
//     * 解析已经生成好的AccessToken
//     *
//     * @param accessToken accessToken
//     * @return 解析后的Token对象
//     */
//    TokenClaim getTokenClaim(String accessToken);
}
