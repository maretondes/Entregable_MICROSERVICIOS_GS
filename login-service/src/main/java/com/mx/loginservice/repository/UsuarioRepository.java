package com.mx.loginservice.repository;

import com.mx.loginservice.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios,String> {

    Usuarios findByUsuarioAndPassword(String usuario, String password);

    @Query(value = "SELECT * FROM usuarios WHERE usuario=:usuario AND password = :password",
            nativeQuery = true)
    Usuarios buscarUser(@Param("usuario")String usuario, @Param("password") String password);
}
