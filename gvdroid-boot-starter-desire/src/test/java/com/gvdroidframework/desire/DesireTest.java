package com.gvdroidframework.desire;

import com.gvdroidframework.desire.core.SerialTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DesireApplication.class)
public class DesireTest {

    @Autowired
    private SerialTemplate serialTemplate;

    @Test
    public void desireTests() {
        serialTemplate.serialInquiry("1", "20201111");
    }
}
