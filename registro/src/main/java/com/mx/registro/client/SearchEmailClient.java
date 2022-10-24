package com.mx.registro.client;

import com.mx.registro.model.RequestEmail;
import com.mx.registro.model.ResponseEmailDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@FeignClient(name = "search-email", fallback = ErrorSearchEmail.class)
public interface SearchEmailClient {

    @RequestMapping(method = POST,value = "api/searchEmail",produces = "application/json")
    HashMap<String,String> searchEmail(@RequestBody RequestEmail request);
}

