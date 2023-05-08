package com.ysu.recipeninja.commons.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CommonsController {
	
	@PostMapping("/uploadImage")
    public String uploadImage(@RequestParam("file") MultipartFile file) throws Exception {
        // 파일을 저장하고, 저장된 파일의 경로를 반환
        String filePath = saveFile(file);
        return filePath;
    }

    private String saveFile(MultipartFile file) throws Exception {
        String fileName = file.getOriginalFilename();
        String filePath = "static/img/" + fileName;
        File dest = new File(filePath);
        file.transferTo(dest);
        return filePath;
    }
}
