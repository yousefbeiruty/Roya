package com.it.yousefl.roya.roomtutorial.roya.network;

import com.it.yousefl.roya.roomtutorial.roya.model.news.NewsModel;


import io.reactivex.Flowable;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiService {
    @GET
    Flowable<NewsModel>getNews(@Url String url);
}
