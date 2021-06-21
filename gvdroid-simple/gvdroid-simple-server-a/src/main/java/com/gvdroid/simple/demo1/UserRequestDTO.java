package com.gvdroid.simple.demo1;

import com.gvdroidframework.base.component.XfaceGenericRequestDTO;
import com.gvdroidframework.logging.sensitive.DesensitionType;
import com.gvdroidframework.logging.sensitive.Desensitization;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO extends XfaceGenericRequestDTO {
    private String id;

    private String ic;

    @Desensitization(type= DesensitionType.IDENTITYNO)
    private String name;
}
