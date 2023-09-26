package com.mora.armazem.repository;

import java.util.Optional;

/*
 * @author Ayowole_Agbedejobi and Alessandro_Eloy
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mora.armazem.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	Optional<Produto> findByCodigo(String codigo);
	Optional<Produto> findByNome(String nome);
}