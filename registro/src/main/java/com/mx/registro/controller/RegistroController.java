package com.mx.registro.controller;

import com.mx.registro.model.registroDTO;
import com.mx.registro.service.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class RegistroController {

    @Autowired
    RegistroService registroService;

    @PostMapping("/registro")
    public ResponseEntity<HashMap<String,String>> registro(@RequestBody registroDTO request){
        HashMap<String,String> mensaje = new HashMap<String,String>();
        int response = 0;
        try {
            response = registroService.guardar(request);
            if(response == 1){
                mensaje.put("code","200");
                mensaje.put("Mensaje","Cuenta creada exitosamente");
            }else if( response == 2){
                mensaje.put("code","402");
                mensaje.put("Mensaje","El Email ingresado ya se encuentra registrado");
            }else if(response == 3){
                mensaje.put("code","402");
                mensaje.put("Mensaje","El Usuario ingresado ya se encuentra registrado");
            }else{
                mensaje.put("code","500");
                mensaje.put("Mensaje","Ocurrio un error al registrar");
            }
            return  new ResponseEntity<>(mensaje, HttpStatus.OK);
        }catch (Exception e){
            System.out.println("Error en Login "+ e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
