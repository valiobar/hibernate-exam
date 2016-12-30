package com.exam.repository;

import com.exam.domain.model.Accessorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessoryRepository extends JpaRepository<Accessorie, Long>{


}
