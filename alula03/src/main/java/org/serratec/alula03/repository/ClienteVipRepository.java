package org.serratec.alula03.repository;

import org.serratec.alula03.domain.ClienteVip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteVipRepository extends JpaRepository<ClienteVip, Long> {

}
