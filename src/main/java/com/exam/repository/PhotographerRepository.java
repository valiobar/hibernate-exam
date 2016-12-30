package com.exam.repository;

import com.exam.domain.model.Photographer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by UserX on 12/8/2016.
 */

@Repository
@Transactional
public interface PhotographerRepository extends JpaRepository<Photographer, Long> {



    @Query(value = "SELECT p.firstName,p.lastName,p.phone FROM Photographer AS p " +
            "ORDER BY p.firstName,p.lastName desc" )
    List<Photographer> extract();



}
