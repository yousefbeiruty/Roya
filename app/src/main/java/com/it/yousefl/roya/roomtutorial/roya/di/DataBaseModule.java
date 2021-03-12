package com.it.yousefl.roya.roomtutorial.roya.di;

import android.app.Application;

import androidx.room.Room;

import com.it.yousefl.roya.roomtutorial.roya.db.NewsDao;
import com.it.yousefl.roya.roomtutorial.roya.db.DataBase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class DataBaseModule {

    @Provides
    @Singleton
    public static DataBase providePokemonDataBase(Application application){
        return Room.databaseBuilder(application, DataBase.class,"DB")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

    @Provides
    @Singleton
    public static NewsDao providePokemonDao(DataBase dataBase){
        return dataBase.newsDao();
    }
}
