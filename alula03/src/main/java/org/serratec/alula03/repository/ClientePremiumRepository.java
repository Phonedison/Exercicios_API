package org.serratec.alula03.repository;

import org.serratec.alula03.domain.ClientePremium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientePremiumRepository extends JpaRepository<ClientePremium, Long> {

}
