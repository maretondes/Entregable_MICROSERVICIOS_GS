package com.mx.updatepassword.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Request {

    private String email;
    private String password;
    private String newPassword;
}
