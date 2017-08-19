package com.wl.college.service;

import com.wl.college.entity.Section;

import java.util.List;

/**
 * Created by DIY on 2017/8/19.
 */
public interface SectionService {
    Section create(Section section);

    Section update(Section section);

    void delete(Section section);

    List<Section> list(Section section);

    Integer total(Section section);
}
