package com.it.yousefl.roya.roomtutorial.roya.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.it.yousefl.roya.roomtutorial.roya.model.news.SectionInfo;

@Database(entities = {SectionInfo.class}, version = 4,exportSchema = false)
@TypeConverters(Converters.class)
public abstract class DataBase extends RoomDatabase {
       public abstract NewsDao newsDao();
}
