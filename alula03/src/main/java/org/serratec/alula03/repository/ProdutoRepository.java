package org.serratec.alula03.repository;

import org.serratec.alula03.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // extends JpaRepository<Classe,Tipo o ID>
    // passa a classe e o tipo da ID
}
