package com.mx.searchuser.controller;

import com.mx.searchuser.model.Request;
import com.mx.searchuser.service.SearchUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SearchUser {

    @Autowired
    SearchUserService searchUserService;

    @PostMapping("/searchUser")
    public ResponseEntity<HashMap<String,Object>> login(@RequestBody Request request){
        HashMap<String,Object> mensaje = new HashMap<String,Object>();
        boolean response = false;
        try {
            response = searchUserService.searchUsuario(request);
            mensaje.put("code","200");
            mensaje.put("Existe",response);

            return  new ResponseEntity<>(mensaje, HttpStatus.OK);
        }catch (Exception e){
            System.out.println("Error en Login "+ e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
