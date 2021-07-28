package com.gvdroidframework.desire;

import com.gvdroidframework.desire.core.SerialTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DesireApplication.class)
public class DesireTest {

    @Autowired
    private SerialTemplate serialTemplate;

    @Test
    public void desireTests() {
        serialTemplate.serialInquiry("1", "20201111");
    }
}
