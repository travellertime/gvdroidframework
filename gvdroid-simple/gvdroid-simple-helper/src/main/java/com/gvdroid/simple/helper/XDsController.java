package com.gvdroid.simple.helper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class XDsController {

    final DxService dxService;

    @GetMapping(value = "/h/g/{id}")
    public String get(@PathVariable("id") String id){
        return this.dxService.getA(id);
    }

    @GetMapping(value = "/h/l/{id}")
    public List<String> getList(@PathVariable("id") String id){
        return this.dxService.getList(id);
    }

    @GetMapping(value = "/h/l2/{id}")
    public List<UserDTO> getUserList(@PathVariable("id") String id){
        return this.dxService.getUserList(id);
    }
}
