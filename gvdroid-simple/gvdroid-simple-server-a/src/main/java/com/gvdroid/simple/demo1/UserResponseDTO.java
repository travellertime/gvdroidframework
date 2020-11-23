package com.gvdroid.simple.demo1;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserResponseDTO {

    String name;

    List<String> dataList;
}
