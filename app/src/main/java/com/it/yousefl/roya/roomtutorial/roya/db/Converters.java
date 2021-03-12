package com.it.yousefl.roya.roomtutorial.roya.db;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.it.yousefl.roya.roomtutorial.roya.model.news.SectionInfo;

public class Converters {
    @TypeConverter
    public String fromSectionInfoToString(SectionInfo sectionInfo){
        return new Gson().toJson(sectionInfo);
    }

    @TypeConverter
    public SectionInfo fromStringToSectionInfo(String stringSectionInfo){
        return new Gson().fromJson(stringSectionInfo,SectionInfo.class);
    }
}
