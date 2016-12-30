package com.exam.service;

import com.exam.domain.dto.PhotographerJSONExportDto;
import com.exam.domain.dto.PhotographerJSONImportDto;

import java.util.List;

public interface PhotographerService {

    void create(PhotographerJSONImportDto photographerJSONImportDto);
    List<PhotographerJSONExportDto> extract();
}
