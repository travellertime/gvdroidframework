package com.gvdroidframework.core.test;

import com.gvdroidframework.base.component.XfaceGenericRequestDTO;
import com.gvdroidframework.base.component.R;
import com.gvdroidframework.base.component.Status;

public class BaseEntityTest {

    public R<ResponseDTO> make(XfaceGenericRequestDTO xfaceGenericRequestDTODTO) {

        return new R<>(new ResponseDTO("hello world"), new Status("1", "1"));
    }

    public static void main(String[] args) {
//        BaseEntityTest test = new BaseEntityTest();
//
//        RequestDTO requestDTO = new RequestDTO();
//        requestDTO.setId("111");
//
//        Response<ResponseDTO> response = test.make(request);
//        System.out.println(response.getBody().getName());
//        System.out.println(response.getStatus().getErrorCode());
    }
}
