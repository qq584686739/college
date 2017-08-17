package com.wl.college.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class FileUtil {
    public static synchronized boolean saveFile(MultipartFile file, String filePath, String name) {
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                File dir = new File(filePath);
                if (!dir.exists()) {
                    // 转存文件
                    dir.mkdirs();
                }
                file.transferTo(new File(filePath + "/" + name));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}