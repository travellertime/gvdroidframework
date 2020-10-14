package com.gvdroidframework.core.test;

import com.gvdroidframework.base.component.Context;
import com.gvdroidframework.base.component.Response;
import com.gvdroidframework.base.component.Request;
import com.gvdroidframework.base.component.Status;

public class BaseEntityTest {

    public Response<ResponseDTO> make(Request<RequestDTO> RequestDTO) {

        return new Response<>(new ResponseDTO("hello world"), new Status("1", "1"));
    }

    public static void main(String[] args) {
        BaseEntityTest test = new BaseEntityTest();

        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setId("111");
        Request<RequestDTO> request = new Request<>(new Context(), requestDTO);

        Response<ResponseDTO> response = test.make(request);
        System.out.println(response.getBody().getName());
        System.out.println(response.getStatus().getErrorCode());
    }
}
