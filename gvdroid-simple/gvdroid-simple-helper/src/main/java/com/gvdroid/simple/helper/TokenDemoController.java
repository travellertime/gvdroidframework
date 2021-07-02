package com.gvdroid.simple.helper;

import com.alibaba.fastjson.JSON;
import com.gvdroidframework.helper.core.PassportSecurityTemplate;
import com.gvdroidframework.security.component.Token;
import com.gvdroidframework.security.component.TokenClaim;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TokenDemoController {

    final PassportSecurityTemplate passportSecurityTemplate;

    @GetMapping(value = "/token/get/{id}")
    public String getToken(@PathVariable("id") String id) {
        String customerId = "TravellerTime";
        String entityId = "TAT_M";
        String channelId = "channelId";
        String saltCode = "123456";
        TokenClaim tokenClaim = TokenClaim.builder().userId(customerId)
                .entityId(entityId)
                .channelId(channelId)
                .roles("")
                .privileges("").expiresIn(100).build();
        Token token = this.passportSecurityTemplate.generateToken(tokenClaim);

        return JSON.toJSONString(token);
    }

    @GetMapping(value = "/token/refresh/{token}")
    public String refreshToken(@PathVariable("token") String token) {
        Token tokenClaimResponse = this.passportSecurityTemplate.refreshToken(token);
        return JSON.toJSONString(tokenClaimResponse);
    }

    @GetMapping(value = "/token/decode/{token}")
    public String deleteToken(@PathVariable("token") String token) {
        TokenClaim tokenClaim = this.passportSecurityTemplate.getTokenClaim(token);
        return JSON.toJSONString(tokenClaim);
    }
}
