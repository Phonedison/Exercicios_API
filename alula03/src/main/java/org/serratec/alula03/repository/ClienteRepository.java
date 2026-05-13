package org.serratec.alula03.repository;

import org.serratec.alula03.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // @Query("Select c FROM Cliente c WHERE c.nome LIKE %:parte%")
    // List<Cliente> findByNome(@Param("parte") String valor);

    // Optional<Cliente> findByCpf(String cpf);

    // List<Cliente> findByEmail(String email);

    // List<Cliente> findByDataNascimento(LocalDate data);

}
