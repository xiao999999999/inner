package com.hbt.inner.service;

import com.hbt.inner.common.DataResult;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    /**
     * 文件上传功能
     * @param file
     * @return
     */
    DataResult upload(MultipartFile file);
}
