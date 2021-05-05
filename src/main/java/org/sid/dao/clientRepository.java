package org.sid.dao;

import org.sid.entities.client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface clientRepository extends JpaRepository<client, Long> {

}
