package com.gvdroidframework.helper.core;

public interface PassportSecurityTemplate {

    void remove(String tokenId);

    String generateTokenId(String customerId, String entityCode, String channelId, String saltCode);

    String generateTokenId(String customerId, String entityCode, String channelId, String saltCode, int expirySeconds);

    String getTokenSecretKey(String tokenId);
}
