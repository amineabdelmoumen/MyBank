package org.sid.dao;

import org.sid.entities.operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface operationRepository extends JpaRepository<operation, Long> {
    @Query("select o from operation o where o.compte.numCompte=:x order by o.dateOperation desc")
    public Page<operation> listoperation(@Param("x") String codecmpt, Pageable pageable);
}
