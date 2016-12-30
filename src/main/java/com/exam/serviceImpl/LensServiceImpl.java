package com.exam.serviceImpl;

import com.exam.domain.dto.LensJSONIportDto;
import com.exam.domain.model.Lens;
import com.exam.parsers.ModelParser;
import com.exam.repository.LensRepository;
import com.exam.service.LensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by UserX on 12/11/2016.
 */
@Service
public class LensServiceImpl implements LensService {


    @Autowired
    private ModelParser modelParser;

    @Autowired
    private LensRepository lensRepository;

    @Override
    public void create(LensJSONIportDto lensJSONIportDto) {
        Lens lens = this.modelParser.convert(lensJSONIportDto,Lens.class);
        this.lensRepository.saveAndFlush(lens);
    }
}
