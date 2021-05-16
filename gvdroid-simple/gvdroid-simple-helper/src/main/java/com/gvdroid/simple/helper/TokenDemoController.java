package com.gvdroid.simple.helper;

import com.alibaba.fastjson.JSON;
import com.gvdroidframework.helper.core.PassportSecurityTemplate;
import com.gvdroidframework.helper.core.TokenObject;
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
                .privileges("").build();
        TokenObject tokenObject = this.passportSecurityTemplate.generateToken(tokenClaim, saltCode, 100);

        return JSON.toJSONString(tokenObject);
    }

    @GetMapping(value = "/token/refresh/{token}")
    public String refreshToken(@PathVariable("token") String token) {
        TokenObject tokenObject = this.passportSecurityTemplate.refreshToken(token, "123456", 100);
        return JSON.toJSONString(tokenObject);
    }

    @GetMapping(value = "/token/delete/{token}")
    public String deleteToken(@PathVariable("token") String token) {
        return "done";
    }
}
