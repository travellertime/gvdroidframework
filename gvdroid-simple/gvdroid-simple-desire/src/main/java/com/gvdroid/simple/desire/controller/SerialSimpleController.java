package com.gvdroid.simple.desire.controller;

import com.gvdroidframework.desire.core.SerialTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SerialSimpleController {

    final SerialTemplate serialTemplate;

    @GetMapping(value = "/serial/inquiry/{key}/{date}")
    public Integer serialInquiry(@PathVariable("key") String key, @PathVariable("date") String date) {
        return this.serialTemplate.serialInquiry(key, date);
    }

    @GetMapping(value = "/serial/inquiry/{key}/{date}/{required}")
    public Integer serialInquiry(@PathVariable("key") String key, @PathVariable("date") String date, @PathVariable("required") boolean required) {
        return this.serialTemplate.serialInquiry(key, date, required);
    }
}
