package com.exam.serviceImpl;

import com.exam.domain.dto.AccessoryXMLImportDto;
import com.exam.domain.model.Accessorie;
import com.exam.parsers.ModelParser;
import com.exam.repository.AccessoryRepository;
import com.exam.service.AccessoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessoriesServiceImpl implements AccessoriesService {
    @Autowired
    private ModelParser modelParser;
    @Autowired
    private AccessoryRepository accessoryRepository;

    @Override
    public void create(AccessoryXMLImportDto accessoryXMLImportDto) {
        Accessorie accessorie = this.modelParser.convert(accessoryXMLImportDto,Accessorie.class);
        this.accessoryRepository.saveAndFlush(accessorie);

    }
}
