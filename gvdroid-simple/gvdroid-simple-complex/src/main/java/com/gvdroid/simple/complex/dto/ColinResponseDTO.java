package com.gvdroid.simple.complex.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ColinResponseDTO implements Serializable {

    String name;

    Date expiryDate;

    List<ColinResponseSubDTO> subList;
}
