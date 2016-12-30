package com.exam.repository;

import com.exam.domain.model.inheritance.MirrorlessCamera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MirrorlessCameraRepository extends JpaRepository<MirrorlessCamera, Long>{


}
