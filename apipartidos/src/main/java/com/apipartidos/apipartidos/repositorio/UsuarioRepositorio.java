package com.apipartidos.apipartidos.repositorio;

import com.apipartidos.apipartidos.entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    public Usuario findByEmail(String email);

    public Usuario findByUsername(String username);
}
