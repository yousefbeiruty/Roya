package com.it.yousefl.roya.roomtutorial.roya.viewmodels;

import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.it.yousefl.roya.roomtutorial.roya.model.news.NewsModel;
import com.it.yousefl.roya.roomtutorial.roya.model.news.SectionInfo;
import com.it.yousefl.roya.roomtutorial.roya.repository.Repository;
import com.it.yousefl.roya.roomtutorial.roya.utils.Resource;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;

public class NewsViewModel extends ViewModel {

    private static final String TAG = "NewsViewModel";

    private Repository repository;


    LiveData<List<SectionInfo>> sectionInfoList = null;
    private MediatorLiveData<Resource<NewsModel>> news;
    private String error;

    @ViewModelInject
    public NewsViewModel(Repository repository) {
        this.repository = repository;
    }


    public LiveData<Resource<NewsModel>> getNews(int page) {

            news = new MediatorLiveData<>();
            news.setValue(Resource.loading((NewsModel) null));

            Log.d(TAG, "getNews: page No= "+page);
            final LiveData<Resource<NewsModel>> source = LiveDataReactiveStreams
                    .fromPublisher(repository.getNews(page)
                            .subscribeOn(io.reactivex.schedulers.Schedulers.io())

                            .onErrorReturn(new io.reactivex.functions.Function<Throwable, NewsModel>() {
                                @Override
                                public NewsModel apply(@NonNull Throwable throwable) throws Exception {
                                    NewsModel newsModel = new NewsModel();
                                    error = throwable.getMessage();
                                    return newsModel;
                                }
                            }).map(new io.reactivex.functions.Function<NewsModel, Resource<NewsModel>>() {
                                @Override
                                public Resource<NewsModel> apply(@NonNull NewsModel newsModel) throws Exception {
                                    if (error != null) {
                                        return Resource.error("Something went wrong " + error, null);
                                    }

                                    return Resource.success(newsModel);
                                }
                            }).observeOn(io.reactivex.android.schedulers.AndroidSchedulers.mainThread()));
            news.addSource(source, new Observer<Resource<NewsModel>>() {
                @Override
                public void onChanged(Resource<NewsModel> responseBodyResource) {
                    news.setValue(responseBodyResource);
                    news.removeSource(source);
                }
            });

        return news;
    }

    public void insertSectionNews(List<SectionInfo> list) {
        repository.insertSectionNews(list);
    }

    public void getSectionInfoNews() {
        sectionInfoList = repository.getSectionNews();
    }

    public LiveData<List<SectionInfo>> getSectionInfoNewsList() {
        return sectionInfoList;
    }

}
