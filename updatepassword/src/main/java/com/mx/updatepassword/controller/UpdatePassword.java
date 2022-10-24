package com.mx.updatepassword.controller;

import com.mx.updatepassword.model.Request;
import com.mx.updatepassword.service.UpdatePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UpdatePassword {

    @Autowired
    UpdatePasswordService updatePasswordService;

    @PostMapping("/updatePassword")
    public ResponseEntity<HashMap<String,Object>> login(@RequestBody Request request){
        HashMap<String,Object> mensaje = new HashMap<String,Object>();
        int response = 0;
        try {
            response = updatePasswordService.updatePassword(request);

            if(response == 1){
                mensaje.put("Code","200");
                mensaje.put("Mensaje","Password actualizado exitosamente");
            }else if(response == 2){
                mensaje.put("Code","402");
                mensaje.put("Mensaje","El correo o Password son incorrectos");
            }else {
                mensaje.put("code","500");
                mensaje.put("Mensaje","Ocurrio un error al actualizar password");
            }

            return  new ResponseEntity<>(mensaje, HttpStatus.OK);
        }catch (Exception e){
            System.out.println("Error en Login "+ e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
