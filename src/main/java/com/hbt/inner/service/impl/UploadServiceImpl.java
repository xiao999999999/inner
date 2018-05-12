package com.hbt.inner.service.impl;

import com.hbt.inner.common.DataResult;
import com.hbt.inner.service.UploadService;
import com.hbt.inner.utils.CommonUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class UploadServiceImpl implements UploadService {

    @Override
    public DataResult upload(MultipartFile file) {
        DataResult result=new DataResult();
        int doPos=file.getOriginalFilename().indexOf(".");
        if(doPos<0){
            return null;
        }
        String fileExt=file.getOriginalFilename().substring(doPos+1).toLowerCase();
        try {
            if (CommonUtils.isPic(fileExt)) {
                String fileName = UUID.randomUUID().toString().replaceAll("-", "") + doPos + fileExt;
                Files.copy(file.getInputStream(), new File(CommonUtils.IMAGE_PATH + fileName).toPath(), StandardCopyOption.REPLACE_EXISTING);
                result.setCode("0");
                result.setData(CommonUtils.IMAGE_PATH+fileName);
                return result;
            }
        }catch (Exception e){
            result.setCode("1");
            result.setMessage("上传失败");
            return result;
        }
        result.setCode("1");
        result.setMessage("上传失败");
        return result;
    }
}
