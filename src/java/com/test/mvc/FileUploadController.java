/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.mvc;

import com.accenture.master.template.TemplateGenerator;
import com.accenture.parser.MonkParser;
import com.accenture.utils.MasterTemplateUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ChethanSeenappa
 */
@Controller
public class FileUploadController {
    
    @RequestMapping(value="/upload", method =RequestMethod.GET)
    public String create(ModelMap model){
        return "upload";
    }
    
    @RequestMapping(value="/save", headers=("content-type=multipart/*"), method = RequestMethod.POST)
    public @ResponseBody String download(@RequestParam("file") MultipartFile file, ModelMap model){
        MonkParser monkParser = new MonkParser();
        MasterTemplateUtil masterTemplate = new MasterTemplateUtil();
        masterTemplate.buildMasterForAllSegement();
        masterTemplate.buildMSHSegment();
        masterTemplate.buildEVNSegment();
        masterTemplate.buildPIDSegment();
        try {
            file.transferTo(new File("c:\\monkParser\\"+file.getOriginalFilename()));
        } catch (IOException ex) {
            Logger.getLogger(FileUploadController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex) {
            Logger.getLogger(FileUploadController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String filePath = "c:\\monkParser\\"+file.getOriginalFilename();
        monkParser.setFilePath(filePath);
        String resultPath = monkParser.getResultPath();
        TemplateGenerator templateGenerator = new TemplateGenerator(resultPath);
        try {
            monkParser.readFile();
            monkParser.constructFinalLogic(masterTemplate);
            templateGenerator.generateTemplateWithHL7Standards(masterTemplate);
        } catch (FileNotFoundException ex) {
            System.out.println("Was Not able to find file:   "+ex);
            Logger.getLogger(TemplateGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Reading File has some difficulties:   "+ex);
            Logger.getLogger(TemplateGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "File uploaded and converted succesfully.";
    }
}
