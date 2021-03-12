package com.it.yousefl.roya.roomtutorial.roya.repository;

import androidx.lifecycle.LiveData;

import com.it.yousefl.roya.roomtutorial.roya.db.NewsDao;
import com.it.yousefl.roya.roomtutorial.roya.model.news.NewsModel;
import com.it.yousefl.roya.roomtutorial.roya.model.news.SectionInfo;
import com.it.yousefl.roya.roomtutorial.roya.network.ApiService;
import com.it.yousefl.roya.roomtutorial.roya.utils.Constants;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.rxjava3.core.Observable;

public class Repository {

    private ApiService apiService;
    private NewsDao newsDao;


    private String error;

    @Inject
    public Repository(ApiService apiService, NewsDao newsDao) {
        this.apiService = apiService;
        this.newsDao = newsDao;
    }

    public Flowable<NewsModel>getNews(int page){
        String url = Constants.BASE_URL + "section/get/1/info/"+page;
        return apiService.getNews(url);
    }


    public void insertSectionNews(List<SectionInfo>list){
        newsDao.insertSectionNews(list);
    }

    public LiveData<List<SectionInfo>>getSectionNews(){
        return newsDao.getSectionNews();
    }



}
