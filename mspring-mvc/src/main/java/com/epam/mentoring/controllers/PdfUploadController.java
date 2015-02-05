package com.epam.mentoring.controllers;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by alehatsman on 12/28/14.
 */
@Controller
public class PdfUploadController {

    private static final String NAME = "name";

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String getUploadForm() {
        return "upload";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String handleFileUpload(@RequestParam(NAME) String name, @RequestParam("file") MultipartFile file, Model model) {
        String message;
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(name)));
                stream.write(bytes);
                stream.close();
                message = "You successfully uploaded " + name + "!";
            } catch (Exception e) {
                message =  "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            message = "You failed to upload " + name + " because the file was empty.";
        }
        model.addAttribute("message", message);
        return "message";
    }

    @RequestMapping(value = "/files/{name}")
    public void handleDownload(@PathVariable(NAME) String name, HttpServletResponse response) {
        File file = new File(name);
        if(file.exists()) {
            try (InputStream is = new BufferedInputStream(new FileInputStream(file))) {
                response.getOutputStream().write(IOUtils.toByteArray(is));
                is.close();
            } catch (IOException ex) {
                throw new RuntimeException("IOError writing file to output stream");
            }
        } else {
            response.setStatus(404);
        }
    }

}
