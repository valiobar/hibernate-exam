package com.exam.terminal;

import com.exam.annoitationValidations.DtoValidator;
import com.exam.domain.dto.*;
import com.exam.io.XmlParser;
import com.exam.io.interfaces.ConsoleIO;
import com.exam.service.AccessoriesService;
import com.exam.service.CameraService;
import com.exam.service.LensService;
import com.exam.service.PhotographerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class Terminal implements CommandLineRunner {
    @Autowired
    private com.exam.io.JsonParser jsonParser;
    @Autowired
    private DtoValidator dtoValidator;
    @Autowired
    private ConsoleIO consoleIO;
    @Autowired
    private CameraService cameraService;
    @Autowired
    private LensService lensService;
    @Autowired
   private PhotographerService photographerService;
    @Autowired
    private XmlParser xmlParser;
    @Autowired
    private AccessoriesService accessoriesService;

    @Override
    public void run(String... strings) throws Exception {

        readFromLenses();
        readCameras();
        readPhotograpers();
        importAccessoriesFromXML();

    }

   private void readFromLenses() throws IOException {
        StringBuilder result = new StringBuilder();

        LensJSONIportDto[] lensJSONIportDtos = null;

        lensJSONIportDtos = this.jsonParser.importJson(LensJSONIportDto[].class, "/files/json/input/lenses.json");
        for (LensJSONIportDto lensJSONIportDto : lensJSONIportDtos) {
            try{
                this.lensService.create(lensJSONIportDto);
                this.consoleIO.write(("Successfully imported "+ lensJSONIportDto.getMake()+" "+lensJSONIportDto.getFocalLength()+"mm"+" "+lensJSONIportDto.getMaxAperture()));
            } catch (Exception e){
                this.consoleIO.write("Error. Invalid data provided");
            }
        }
    }
    private void readCameras() throws IOException {


        CamerasJSONIportDto[] camerasJSONIportDtos = null;

        camerasJSONIportDtos = this.jsonParser.importJson(CamerasJSONIportDto[].class, "/files/json/input/cameras.json");
        for (CamerasJSONIportDto camerasJSONIportDto : camerasJSONIportDtos) {
            try{
                this.cameraService.create(camerasJSONIportDto);
                this.consoleIO.write(("Successfully imported "+ camerasJSONIportDto.getType()+" "+camerasJSONIportDto.getMake()+" "+camerasJSONIportDto.getModel()));
            } catch (Exception e){
                this.consoleIO.write("Error. Invalid data provided");
            }
        }
    }
    private void readPhotograpers() throws IOException {
        PhotographerJSONImportDto[] photographerJSONImportDtos = null;

        photographerJSONImportDtos = this.jsonParser.importJson(PhotographerJSONImportDto[].class, "/files/json/input/photographers.json");
        for (PhotographerJSONImportDto photographerJSONImportDto : photographerJSONImportDtos) {
            try{
                if(this.dtoValidator.isValid(photographerJSONImportDto)) {
                    this.photographerService.create(photographerJSONImportDto);
                    this.consoleIO.write(("Successfully imported " + photographerJSONImportDto.getFirstName() + " " +
                            photographerJSONImportDto.getLastName() + " | " + photographerJSONImportDto.getLenses().size()));
                } else{
                    this.consoleIO.write("Error. Invalid data provided");
                }
            } catch (Exception e){
                this.consoleIO.write("Error. Invalid data provided");
            }
        }
    }
    private void importAccessoriesFromXML(){
        AccessoriesXMLImportDto accessoriesXMLImportDto = null;
        try {
            accessoriesXMLImportDto = this.xmlParser.read(AccessoriesXMLImportDto.class, "/files/xml/input/accessories.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (AccessoryXMLImportDto accessoryXMLImportDto : accessoriesXMLImportDto.getAccessoryXMLImportDtos()) {
            try{
                this.accessoriesService.create(accessoryXMLImportDto);
                this.consoleIO.write(String.format("Successfully imported "+accessoryXMLImportDto.getName()));
            } catch (Exception e){
                this.consoleIO.write(String.format("Error: Invalid data."));
            }
        }
    }
    private void exportPhotigraphersToJson(){
        List<PhotographerJSONExportDto> planetExportJSONDtoList = this.photographerService.extract();
        try {
            this.jsonParser.exportJson(planetExportJSONDtoList, "src/main/resourses/files/json/output/accessories.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}