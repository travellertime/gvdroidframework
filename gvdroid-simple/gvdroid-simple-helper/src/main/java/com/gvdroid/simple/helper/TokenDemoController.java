package com.gvdroid.simple.helper;

import com.alibaba.fastjson.JSON;
import com.gvdroidframework.helper.core.PassportSecurityTemplate;
import com.gvdroidframework.security.component.TokenClaimResponse;
import com.gvdroidframework.security.component.TokenClaimRequest;
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
        TokenClaimRequest tokenClaimRequest = TokenClaimRequest.builder().userId(customerId)
                .entityId(entityId)
                .channelId(channelId)
                .roles("")
                .privileges("").expiresIn(100).build();
        TokenClaimResponse tokenClaimResponse = this.passportSecurityTemplate.generateToken(tokenClaimRequest);

        return JSON.toJSONString(tokenClaimResponse);
    }

    @GetMapping(value = "/token/refresh/{token}")
    public String refreshToken(@PathVariable("token") String token) {
        TokenClaimResponse tokenClaimResponse = this.passportSecurityTemplate.refreshToken(token);
        return JSON.toJSONString(tokenClaimResponse);
    }

    @GetMapping(value = "/token/delete/{token}")
    public String deleteToken(@PathVariable("token") String token) {
        return "done";
    }
}
