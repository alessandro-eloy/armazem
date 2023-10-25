package com.mora.armazem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.mora.armazem.entity.Usuario;

 /*
 * @author Ayowole_Agbedejobi and Alessandro_Eloy
 */

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	Optional<Usuario> findById(Integer id);
	UserDetails findByLogin(String login);
}
