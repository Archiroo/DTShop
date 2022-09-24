package com.dtshop.app.Service;

import com.dtshop.app.Domain.FileUpload;
import com.dtshop.app.Dto.FileUploadDto;
import com.sun.xml.internal.ws.api.message.Attachment;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    FileUploadDto saveFileUpload(MultipartFile multipartFile);

    FileUpload getEntity(Long id);
}
