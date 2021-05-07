package org.sid.dao;

import org.sid.entities.compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface compteRepository extends JpaRepository<compte, String> {
    @Query("select c from compte c where c.numCompte=:x")
    public compte findOne(@Param("x") String codecmp);
}
