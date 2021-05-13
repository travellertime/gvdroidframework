package com.gvdroid.simple.helper;

import com.gvdroidframework.helper.core.PassportSecurityTemplate;
import com.gvdroidframework.security.util.JWTUtils;
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
        String token = this.passportSecurityTemplate.generateTokenId(customerId, entityId, channelId, saltCode);

        return token;
    }

    @GetMapping(value = "/token/refresh/{token}")
    public String refreshToken(@PathVariable("token") String token) {
        return "";
    }

    @GetMapping(value = "/token/delete/{token}")
    public String deleteToken(@PathVariable("token") String token) {
        return "done";
    }
}
