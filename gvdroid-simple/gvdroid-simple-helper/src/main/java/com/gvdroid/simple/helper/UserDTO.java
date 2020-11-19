package com.gvdroid.simple.helper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {

    String id;
    String name;

    UserSubDTO subDTO;

    List<UserSubDTO> dataList;
}
