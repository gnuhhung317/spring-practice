package com.example.demo.service;

import com.example.demo.service.imp.FileServiceImp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Service
public class FileService implements FileServiceImp {
    @Value("${fileUpload.rootPath}")
    String rootPath;

    Path path;
    public void init(){
        try {
            path = Paths.get(rootPath);
            if (Files.notExists(path)) Files.createDirectory(path);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public boolean uploadFile(MultipartFile file) {
        try {
            init();
            Files.copy(file.getInputStream(),path.resolve(Objects.requireNonNull(file.getOriginalFilename())));
            return true;
        }catch (Exception e){
            System.out.println("Error when upload file: "+e.getMessage());
        }

        return false;
    }

    @Override
    public Resource getFile(String fileName) {
        try {
            init();
            Path file = path.resolve(fileName);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists()&& resource.isReadable()){
                return resource;
            }
        }catch (Exception e){
            System.out.println("Error load file: "+e.getMessage());
        }
        return null;
    }
}
