package org.sid.dao;

import org.sid.entities.compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface compteRepository extends JpaRepository<compte, String> {

}
