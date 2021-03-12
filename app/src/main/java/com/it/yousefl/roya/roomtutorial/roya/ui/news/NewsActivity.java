package com.it.yousefl.roya.roomtutorial.roya.ui.news;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.google.android.material.snackbar.Snackbar;
import com.it.yousefl.roya.R;
import com.it.yousefl.roya.databinding.ActivityNewsBinding;
import com.it.yousefl.roya.roomtutorial.roya.model.news.NewsModel;
import com.it.yousefl.roya.roomtutorial.roya.model.news.SectionInfo;
import com.it.yousefl.roya.roomtutorial.roya.ui.news.adapters.NewsAdapter;
import com.it.yousefl.roya.roomtutorial.roya.ui.news.adapters.PaginationListener;
import com.it.yousefl.roya.roomtutorial.roya.utils.Resource;
import com.it.yousefl.roya.roomtutorial.roya.viewmodels.NewsViewModel;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

import static com.it.yousefl.roya.roomtutorial.roya.ui.news.adapters.PaginationListener.PAGE_START;

@AndroidEntryPoint
public class NewsActivity extends AppCompatActivity  implements SwipeRefreshLayout.OnRefreshListener{
    private static final String TAG = "NewsActivity";

    ActivityNewsBinding binding;
    //Val
    private NewsViewModel viewModel;
    private NewsAdapter adapter;

    private int currentPage = PAGE_START;
    private boolean isLastPage = false;
    private int totalPage = Integer.MAX_VALUE;
    private boolean isLoading = false;
    int itemCount = 0;

    Sprite doubleBounce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_news);
        viewModel=new ViewModelProvider(this).get(NewsViewModel.class);
        binding.swipeRefresh.setOnRefreshListener(this);
        binding.rcNews.setHasFixedSize(true);
        // use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.rcNews.setLayoutManager(layoutManager);
        List<SectionInfo>list=new ArrayList<>();
        adapter=new NewsAdapter(this,list);
        binding.rcNews.setAdapter(adapter);
        doubleBounce = new DoubleBounce();

        getNews();

/**
 * add scroll listener while user reach in bottom load more will call
 */
        binding.rcNews.addOnScrollListener(new PaginationListener(layoutManager) {
            @Override
            protected void loadMoreItems() {
                isLoading = true;
                currentPage++;
                getNews();
            }
            @Override
            public boolean isLastPage() {
                return isLastPage;
            }
            @Override
            public boolean isLoading() {
                return isLoading;
            }
        });
    }

    private void getNews() {
        viewModel.getNews(currentPage).observe(this, new Observer<Resource<NewsModel>>() {
            @Override
            public void onChanged(Resource<NewsModel> newsModelResource) {
                switch (newsModelResource.status){
                    case LOADING:
                        Log.d(TAG, "onChanged: LOADING");
                        binding.progerssbar.setIndeterminateDrawable(doubleBounce);
                        break;
                    case SUCCESS:
                         binding.progerssbar.setVisibility(View.GONE);
                         binding.spinKit.setVisibility(View.GONE);
                        Log.d(TAG, "onChanged: SUCCESS");
                        if (newsModelResource.data.getSectionInfo()!=null && newsModelResource.data.getSectionInfo().size()!=0){
                            setData(newsModelResource.data.getSectionInfo());
                            saveNews(newsModelResource.data.getSectionInfo());
                        }
                        break;
                    case ERROR:
                        binding.progerssbar.setVisibility(View.GONE);
                        binding.spinKit.setVisibility(View.GONE);
                        if (!isInternetAvailable()){
                            Snackbar.make( binding.rcNews,"Check your internet Connection", Snackbar.LENGTH_LONG)
                                   // .setAction("Action", null)
                                    .show();
                        }else {
                            getNews();
                        }
                        Log.d(TAG, "onChanged: ERROR= "+newsModelResource.message);
                        getLocalNews();
                        break;
                }
            }
        });

    }

    private void saveNews(List<SectionInfo> sectionInfoList) {
        viewModel.insertSectionNews(sectionInfoList);
    }


    private void getLocalNews() {
        viewModel.getSectionInfoNews();
        viewModel.getSectionInfoNewsList().observe(this, new Observer<List<SectionInfo>>() {
            @Override
            public void onChanged(List<SectionInfo> sectionInfoList) {
                setData(sectionInfoList);
            }
        });
    }

    public void setData(List<SectionInfo> sectionInfoList){
        final ArrayList<SectionInfo> items = new ArrayList<>();
        for (int i = 0; i < sectionInfoList.size() ; i++) {
            itemCount++;
            SectionInfo sectionInfo = new SectionInfo();
            sectionInfo.setSectionName(sectionInfoList.get(i).getSectionName() );
            sectionInfo.setNewsTitle(sectionInfoList.get(i).getNewsTitle());
            sectionInfo.setImageLink(sectionInfoList.get(i).getImageLink());
            items.add(sectionInfo);
        }
        /**
         * manage progress view
         */
        if (currentPage != PAGE_START) adapter.removeLoading();
        adapter.addItems(items);
        binding.swipeRefresh.setRefreshing(false);
        // check weather is last page or not
        if (currentPage < totalPage) {
            adapter.addLoading();
        } else {
            isLastPage = true;
        }
        isLoading = false;

    }

    @Override
    public void onRefresh() {
        itemCount = 0;
        currentPage = PAGE_START;
        isLastPage = false;
        adapter.clear();
        getNews();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    public boolean isInternetAvailable() {
        try {
            InetAddress ipAddr = InetAddress.getByName("google.com");
            //You can replace it with your name
            return !ipAddr.equals("");

        } catch (Exception e) {
            return false;
        }
    }
}