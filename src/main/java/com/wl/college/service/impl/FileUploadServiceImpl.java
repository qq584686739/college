package com.wl.college.service.impl;

import com.wl.college.enums.ResultEnum;
import com.wl.college.service.FileUploadService;
import com.wl.college.utils.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import static com.wl.college.enums.Constants.*;

/**
 * Created by DIY on 2017/8/17.
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Override
    public String upload(MultipartFile file, String path, String name) {

        String relativePath=USER_FILE_SAVE_RELATIVE_PATH+path+"/"+name;
        String absolutePath=USER_FILE_SAVE_ABSOLUTE_PATH+path;
        if(!FileUtil.saveFile(file, absolutePath + "/", name)){
           throw new RuntimeException(ResultEnum.IMG_ERROR.getMsg());
        };
        return relativePath;
    }
}
