package com.gvdroid.simple.demo2;

import com.gvdroidframework.base.component.R;
import com.gvdroidframework.base.component.Status;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = "gvdroid-cloud-a-server", fallback = Demo1Service.Demo1ServiceImpl.class)
public interface Demo1Service {

    @PostMapping(value = "/demo/1")
    @ResponseBody
    R<UserResponseDTO> processRequest(@RequestBody UserRequestDTO requestDTO);

    @Component
    class Demo1ServiceImpl implements Demo1Service {

        @Override
        public R<UserResponseDTO> processRequest(UserRequestDTO requestDTO) {
            return new R<>(new UserResponseDTO(), Status.of("gvdroid-cloud-a-server", requestDTO.getContext().getServiceId()));
        }
    }
}
