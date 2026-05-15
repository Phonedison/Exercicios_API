package org.serratec.aula05.repository;

import org.serratec.aula05.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicosRepository extends JpaRepository<Servico, Long> {

}
