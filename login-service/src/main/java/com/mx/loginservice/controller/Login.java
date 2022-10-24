package com.mx.loginservice.controller;


import com.mx.loginservice.model.LoginDTO;
import com.mx.loginservice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class Login {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<HashMap<String,String>> login(@RequestBody LoginDTO request){
        HashMap<String,String> mensaje = new HashMap<String,String>();

        try {
            int total = loginService.login(request);
            if(total == 1){
                mensaje.put("code","200");
                mensaje.put("Mensaje","Password Correcto");
            }else{
                mensaje.put("code","401");
                mensaje.put("Mensaje","Error en Usuario o Password");
            }
            return  new ResponseEntity<>(mensaje, HttpStatus.OK);
        }catch (Exception e){
            System.out.println("Error en Login "+ e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
