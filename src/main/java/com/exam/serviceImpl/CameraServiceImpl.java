package com.exam.serviceImpl;

import com.exam.domain.dto.CamerasJSONIportDto;
import com.exam.domain.model.inheritance.DSLRCamera;
import com.exam.domain.model.inheritance.MirrorlessCamera;
import com.exam.parsers.ModelParser;
import com.exam.repository.CameraRepository;
import com.exam.repository.DSLRCamerRepository;
import com.exam.repository.MirrorlessCameraRepository;
import com.exam.service.CameraService;
import com.exam.service.DSLRCameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CameraServiceImpl implements CameraService {

    @Autowired
    private ModelParser modelParser;
    @Autowired
    private CameraRepository cameraRepository;
    @Autowired
    private DSLRCamerRepository dslrCamerRepository;
    @Autowired
    private MirrorlessCameraRepository mirrorlessCameraRepository;

    @Override
    public void create(CamerasJSONIportDto camerasJSONIportDto) {
       if(camerasJSONIportDto.getType().equals("DSLR")){
           DSLRCamera dslrCamera = this.modelParser.convert(camerasJSONIportDto,DSLRCamera.class);
           this.dslrCamerRepository.saveAndFlush(dslrCamera);
       }else{
           MirrorlessCamera mirrorlessCamera = this.modelParser.convert(camerasJSONIportDto,MirrorlessCamera.class);
           this.mirrorlessCameraRepository.saveAndFlush(mirrorlessCamera);
       }


    }
}
