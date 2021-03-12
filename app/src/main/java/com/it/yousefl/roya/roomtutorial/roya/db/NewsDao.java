package com.it.yousefl.roya.roomtutorial.roya.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.it.yousefl.roya.roomtutorial.roya.model.news.SectionInfo;

import java.util.List;

@Dao
public interface NewsDao {

    @Insert
    public void insertSectionNews(List<SectionInfo> list);


    @Query("select * from SectionInfo")
    public LiveData<List<SectionInfo>>getSectionNews();

}
