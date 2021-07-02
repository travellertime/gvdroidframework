package com.gvdroid.simple.complex.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CacheResponseSubDTO implements Serializable {

    String name;
    Integer age;
}
