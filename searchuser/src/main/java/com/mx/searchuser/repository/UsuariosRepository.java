package com.mx.searchuser.repository;

import com.mx.searchuser.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, String> {

    List<Usuarios> findByUsuario(String usuario);

}
