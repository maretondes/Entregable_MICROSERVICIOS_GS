package com.mx.searchemail.controller;

import com.mx.searchemail.model.Request;
import com.mx.searchemail.service.SearchEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SearchEmail {

    @Autowired
    SearchEmailService searchEmailService;

    @PostMapping("/searchEmail")
    public ResponseEntity<HashMap<String,String>> login(@RequestBody Request request){
        HashMap<String,String> mensaje = new HashMap<String,String>();
        String response = "";
        try {
            response = searchEmailService.searchEmail(request);
            mensaje.put("code","200");
            mensaje.put("Existe",response);

            return  new ResponseEntity<>(mensaje, HttpStatus.OK);
        }catch (Exception e){
            System.out.println("Error en Login "+ e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
