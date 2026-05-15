package org.serratec.aula07.repository;

import java.util.List;

import org.serratec.aula07.domain.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    List<Topico> findByCursoId(Long id);
}
