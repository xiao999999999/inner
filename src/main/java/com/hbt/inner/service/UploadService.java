package com.hbt.inner.service;

import com.hbt.inner.common.DataResult;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    DataResult upload(MultipartFile file);
}
