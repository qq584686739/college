package com.wl.college.utils;

import com.wl.college.entity.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by DIY on 2017/8/18.
 */
public class IdCardUtil {


    public static void getBirthdateAndGender(User manager) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        String idCard = manager.getIdCard();
        String birth = idCard.substring(6, 14);
        Integer gender = Integer.parseInt(idCard.substring(16, 17))%2;
        System.out.println(birth);
        System.out.println(gender);
        try {
            manager.setBirthdate(sdf.parse(birth));
            manager.setGender(gender+"");
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
