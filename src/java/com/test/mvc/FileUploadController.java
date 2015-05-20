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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import static org.springframework.util.StreamUtils.BUFFER_SIZE;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @RequestMapping(value="/generateOutput", method = RequestMethod.POST)
    public String generateOutput(@RequestParam("file") MultipartFile file, ModelMap model){
        MonkParser monkParser = new MonkParser();
        MasterTemplateUtil masterTemplate = new MasterTemplateUtil();
        masterTemplate.buildMasterForAllSegement();
        masterTemplate.buildMSHSegment();
        masterTemplate.buildEVNSegment();
        masterTemplate.buildPIDSegment();
        masterTemplate.buildPV1Segment();
        masterTemplate.buildPV2Segment();
        masterTemplate.buildDG1Segment();
        masterTemplate.buildIN1Segment();
        masterTemplate.buildNTESegment();
        masterTemplate.buildOBRSegment();
        masterTemplate.buildORCSegment();
        masterTemplate.buildOBXSegment();
        String fileName = file.getOriginalFilename();
        String filePath = System.getProperty("java.io.tmpdir")+"\\"+fileName;
        try {
            file.transferTo(new File(filePath));
        } catch (IOException | IllegalStateException ex) {
            Logger.getLogger(FileUploadController.class.getName()).log(Level.SEVERE, null, ex);
        }
        monkParser.setFilePath(filePath);
        String resultPath = monkParser.getResultPath();
        TemplateGenerator templateGenerator = new TemplateGenerator(resultPath);
        try {
            monkParser.readFile();
            monkParser.constructFinalLogic(masterTemplate);
            templateGenerator.generateTemplateWithHL7Standards(masterTemplate);
        } catch (FileNotFoundException ex) {
            System.out.println("Was Not able to find file:   "+ex);
        } catch (IOException ex) {
            System.out.println("Reading File has some difficulties:   "+ex);
        }
        model.addAttribute("fileName", "Legacy_"+fileName.split("\\.")[0]+"_TR");
        model.addAttribute("resultPath", templateGenerator.getDestinationFilePath());
        model.addAttribute("contentType", file.getContentType());
        return "generateOutput";
    }
    
    @RequestMapping(value="/download", method = RequestMethod.POST)
    public void download(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String filePath = request.getParameter("filePath");
        File downloadFile = new File(filePath);
        OutputStream outStream;
        try (FileInputStream inputStream = new FileInputStream(downloadFile)) {
            String mimeType = request.getParameter("contentType");
            if (mimeType == null) {
                mimeType = "application/octet-stream";
            }   
            response.setContentType(mimeType);
            response.setContentLength((int) downloadFile.length());
            String headerKey = "Content-Disposition";
            String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
            response.setHeader(headerKey, headerValue);
            outStream = response.getOutputStream();
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
        }
        outStream.close();
    }
}
