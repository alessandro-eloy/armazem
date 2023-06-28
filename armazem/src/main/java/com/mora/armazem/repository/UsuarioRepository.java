package com.mora.armazem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mora.armazem.entity.Usuario;

 /*
 * @author Ayowole_Agbedejobi and Alessandro_Eloy
 */

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
