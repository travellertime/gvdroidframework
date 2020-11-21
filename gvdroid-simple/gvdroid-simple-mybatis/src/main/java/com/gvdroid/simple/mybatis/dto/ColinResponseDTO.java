package com.gvdroid.simple.mybatis.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ColinResponseDTO implements Serializable {

    String name;

    Date expiryDate;
}
