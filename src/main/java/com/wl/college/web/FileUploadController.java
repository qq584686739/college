package com.wl.college.web;

import com.wl.college.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**文件上传
 * Created by DIY on 2017/8/17.
 */
@RestController
@RequestMapping("/file")
public class FileUploadController {
    private final FileUploadService fileUploadService;

    @Autowired
    public FileUploadController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    /**
     * 管理员给别人上传
     * @param file
     * @param filePath
     * @param name
     * @param type
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Object register(@RequestParam("uploadFile") MultipartFile file,
                           String filePath, String name,String type,Integer id) {
        try {
            String path=type+"/"+id+"/"+filePath;
            return fileUploadService.upload(file,path,name+".jpg");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

}
