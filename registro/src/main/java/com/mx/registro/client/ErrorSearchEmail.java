package com.mx.registro.client;

import com.mx.registro.model.RequestEmail;
import com.mx.registro.model.ResponseEmailDTO;

import java.util.HashMap;

public class ErrorSearchEmail implements SearchEmailClient{

    @Override
    public HashMap<String, String> searchEmail(RequestEmail request) {
        HashMap<String,String> response = new HashMap<String,String>();
        response.put("Mensaje","cliente no disponible");
        System.out.println("No se pudo conectar con cliente Search Email buelva a ibntentar");
        return response;
    }
}
