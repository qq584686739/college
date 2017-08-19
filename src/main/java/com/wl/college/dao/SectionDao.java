package com.wl.college.dao;

import com.wl.college.entity.Section;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by DIY on 2017/8/19.
 */
public interface SectionDao {
    Integer create(@Param("section") Section section);

    Section findById(@Param("id") Integer id);

    Integer update(@Param("section") Section section);

    void delete(@Param("section") Section section);

    List<Section> list(@Param("section") Section section);

    Integer total(@Param("section") Section section);
}
