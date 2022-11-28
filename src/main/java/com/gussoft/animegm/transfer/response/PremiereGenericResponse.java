package com.gussoft.animegm.transfer.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PremiereGenericResponse<E> {

    private int status;

    private String message;

    private E response;

}
