package com.demoyageek.practica_springboot.Services;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class ImagenesServices {

    public static String uploadDirectory = "images";

    public String guardarFoto(MultipartFile img) throws IOException {
        Path tempFile= null;
        String ruta = null;
        if(img.getSize() > 0){
            try(InputStream input = img.getInputStream()){
                tempFile = Files.createTempFile(Paths.get(uploadDirectory), "", ".png");
                Files.copy(input, tempFile, StandardCopyOption.REPLACE_EXISTING);
                ruta = tempFile.getFileName().toString();
            }
        }
        return ruta;
    }
}
