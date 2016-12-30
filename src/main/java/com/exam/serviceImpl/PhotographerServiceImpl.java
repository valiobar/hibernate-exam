package com.exam.serviceImpl;

import com.exam.domain.dto.PhotographerJSONExportDto;
import com.exam.domain.dto.PhotographerJSONImportDto;
import com.exam.domain.model.Lens;
import com.exam.domain.model.Photographer;
import com.exam.parsers.ModelParser;
import com.exam.repository.LensRepository;
import com.exam.repository.PhotographerRepository;
import com.exam.service.PhotographerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PhotographerServiceImpl implements PhotographerService {

    @Autowired
    private ModelParser modelParser;
    @Autowired
    private PhotographerRepository photographerRepository;
    @Autowired
    private LensRepository lensRepository;

    @Override
    public void create(PhotographerJSONImportDto photographerJSONImportDto) {
        Photographer photographer = new Photographer();
        photographer.setFirstName(photographerJSONImportDto.getFirstName());
        photographer.setLastName(photographerJSONImportDto.getLastName());
        photographer.setPhone(photographerJSONImportDto.getPhone());
        for (long lensId :photographerJSONImportDto.getLenses() ) {
           if(this.lensRepository.findOne(lensId)!=null) {
               Lens existingLens = this.lensRepository.findOne(lensId);
               photographer.addLens(existingLens);
           }
        }
        this.photographerRepository.saveAndFlush(photographer);


    }

    @Override
    public List<PhotographerJSONExportDto> extract() {

        List<Photographer>photographers = this.photographerRepository.extract();
        List<PhotographerJSONExportDto> photographerJSONExportDtos= this.modelParser.convert(photographers,PhotographerJSONExportDto.class);
    return photographerJSONExportDtos;
    }
}
