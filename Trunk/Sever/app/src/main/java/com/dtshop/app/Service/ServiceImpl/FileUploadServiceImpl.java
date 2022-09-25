package com.dtshop.app.Service.ServiceImpl;

import com.dtshop.app.Domain.FileUpload;
import com.dtshop.app.Dto.FileUploadDto;
import com.dtshop.app.Repository.FileUploadRepository;
import com.dtshop.app.Service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Autowired
    private FileUploadRepository fileUploadRepos;
    @Override
    public FileUploadDto saveFileUpload(MultipartFile multipartFile) {
        FileUpload entity = new FileUpload();
        if(multipartFile != null) {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
            try {
                if(fileName.contains("..")) {
                    throw new Exception("File name contains invalid path sequence." + fileName);
                }
                entity.setName(fileName);
                entity.setType(multipartFile.getContentType());
                entity.setData(multipartFile.getBytes());
                entity = this.fileUploadRepos.save(entity);
                return new FileUploadDto(entity);
            } catch (Exception e) {

            }
        }
        return null;
    }

    @Override
    public FileUpload getEntity(Long id) {
        FileUpload entity = null;
        if(id != null) {
            Optional<FileUpload> fileUploadOptional = this.fileUploadRepos.findById(id);
            if(fileUploadOptional.isPresent()) {
                entity = fileUploadOptional.get();
                return entity;
            }
        }
        return null;
    }
}
