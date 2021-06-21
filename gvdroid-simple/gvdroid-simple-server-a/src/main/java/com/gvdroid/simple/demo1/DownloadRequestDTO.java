package com.gvdroid.simple.demo1;

import com.gvdroidframework.base.component.XfaceGenericRequestDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DownloadRequestDTO extends XfaceGenericRequestDTO {

    String fileName;
    String filePath;
}
