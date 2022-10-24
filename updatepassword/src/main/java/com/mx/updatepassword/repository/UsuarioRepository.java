package com.mx.updatepassword.repository;

import com.mx.updatepassword.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, String> {

    Usuarios findByEmailAndPassword(String email, String password);

    @Transactional
    @Query(value = "UPDATE usuarios SET password = :password WHERE id = :id",nativeQuery = true)
    @Modifying
    public void updatePassword(@Param("id") String id, @Param("password") String password);

}
