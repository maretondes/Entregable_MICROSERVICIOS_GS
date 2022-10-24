package com.mx.registro.client;

import com.mx.registro.model.RequestUsuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@FeignClient(name = "search-user")
public interface SearchUserClient {

    @RequestMapping(method = POST, value = "api/searchUser",produces = "application/json")
    HashMap<String,Object> searchUser(@RequestBody RequestUsuario request);
}
