package com.dtshop.app.RestController.File;

import com.dtshop.app.Domain.FileUpload;
import com.dtshop.app.Dto.FileUploadDto;
import com.dtshop.app.Service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/file")
public class RestFileUploadController {
    @Autowired
    private FileUploadService fileUploadService;

    @RequestMapping(value = "/upload_image", method = RequestMethod.POST)
    public FileUploadDto uploadFile(@RequestParam("fileimage")MultipartFile multipartFile) {
        FileUploadDto result = this.fileUploadService.saveFileUpload(multipartFile);
        return result;
    }

    @RequestMapping(value = "/download_image/{id}", method = RequestMethod.GET)
    public ResponseEntity<Resource> dowloadFile(@PathVariable Long id) {
        FileUpload entity = this.fileUploadService.getEntity(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(entity.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; fileName=\"" + entity.getName() +
                        "\"")
                .body(new ByteArrayResource(entity.getData()));
    }
}
