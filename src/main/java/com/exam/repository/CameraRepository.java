package com.exam.repository;

import com.exam.domain.model.inheritance.DSLRCamera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by UserX on 12/8/2016.
 */

@Repository
@Transactional
public interface CameraRepository extends JpaRepository<DSLRCamera, Long> {


}
