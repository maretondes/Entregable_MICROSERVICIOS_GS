package com.mx.registro.repository;

import com.mx.registro.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, String> {

    @Modifying
    @Query(value = "Insert into usuarios values(:id,:nombre,:ap,:am,:email," +
            ":password,:usuario)",nativeQuery = true)
    @Transactional
    int guardar(@Param("id") String id, @Param("nombre") String nombre,
                       @Param("ap") String ap, @Param("am") String am,
                       @Param("email") String email, @Param("password") String password,
                       @Param("usuario") String usuario);
}
