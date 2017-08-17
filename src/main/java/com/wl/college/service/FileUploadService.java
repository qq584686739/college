package com.wl.college.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by DIY on 2017/8/17.
 */
@Service
public interface FileUploadService {

    String upload(MultipartFile file, String path, String name);
}
