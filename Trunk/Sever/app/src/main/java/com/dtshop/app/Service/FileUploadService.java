package com.dtshop.app.Service;

import com.dtshop.app.Domain.FileUpload;
import com.dtshop.app.Dto.FileUploadDto;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    FileUploadDto saveFileUpload(MultipartFile multipartFile);

    FileUpload getEntity(Long id);
}
