package com.wl.college.web;

import com.wl.college.service.FileUploadService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;


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
     * @param name   id_card_back 等
     * @param type  dept / user
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Object register(@RequestParam("uploadFile") MultipartFile file,
                            String name,String type,Integer id) {
        try {
            String path=type+"/"+id+"/"+name;
            return fileUploadService.upload(file,path,new Date().getTime()+".jpg");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    /**
     * 自己上传
     * @param file
     * @param name   id_card_back 等
     * @param type  dept / user
     * @return
     */
    @RequestMapping(value = "/user",method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Object userRegister(@RequestParam("uploadFile") MultipartFile file,
                           String name,String type) {
        try {
            String path=type+"/"+SecurityUtils.getSubject().getPrincipal()+"/"+name;
            return fileUploadService.upload(file,path,new Date().getTime()+".jpg");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

}
