package org.sid.dao;

import org.sid.entities.operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface operationRepository extends JpaRepository<operation, Long> {

}
