package com.wl.college.web;

import com.wl.college.dto.BaseResult;
import com.wl.college.dto.BootStrapTableResult;
import com.wl.college.entity.Course;
import com.wl.college.entity.Section;
import com.wl.college.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by DIY on 2017/8/19.
 */
@RestController
@RequestMapping("/section")
public class SectionController {

    private final SectionService sectionService;

    @Autowired
    public SectionController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    /**
     * 添加章节
     * @param section
     * @return
     */
    @PostMapping(produces = {"application/json;charset=UTF-8"})
    public BaseResult<Section> create(Section section) {
        return new BaseResult<>(true, sectionService.create(section));
    }

    /**
     * 更新
     * @param section
     * @return
     */
    @PutMapping(produces = {"application/json;charset=UTF-8"})
    public BaseResult<Section> update(Section section) {
        return new BaseResult<>(true, sectionService.update(section));
    }

    /**
     * 删除
     * @return
     */
    @DeleteMapping(value = "/{id}",produces = {"application/json;charset=UTF-8"})
    public BaseResult delete(@PathVariable Integer id) {
        sectionService.delete(id);
        return new BaseResult(true,null );
    }

    /**
     * 列表
     * @param section
     * @return
     */
    @GetMapping(produces = {"application/json;charset=UTF-8"})
    public BootStrapTableResult<Section> list(Section section) {

        return new BootStrapTableResult<>(sectionService.total(section),sectionService.list(section));
    }
}
