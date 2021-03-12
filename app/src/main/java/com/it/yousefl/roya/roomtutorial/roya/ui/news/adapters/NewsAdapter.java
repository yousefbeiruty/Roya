package com.it.yousefl.roya.roomtutorial.roya.ui.news.adapters;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.it.yousefl.roya.R;
import com.it.yousefl.roya.databinding.ItemLoadingBinding;
import com.it.yousefl.roya.databinding.ItemNewsBinding;
import com.it.yousefl.roya.roomtutorial.roya.model.news.BreakingNews;
import com.it.yousefl.roya.roomtutorial.roya.model.news.NewsModel;
import com.it.yousefl.roya.roomtutorial.roya.model.news.SectionInfo;

import java.util.List;

public  class NewsAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private static final int VIEW_TYPE_LOADING = 0;
    private static final int VIEW_TYPE_NORMAL = 1;
    private boolean isLoaderVisible = false;
    private static final String TAG = "NewsAdapter";
    private Context context;
    private List<SectionInfo> news;
    //Animation
    long DURATION = 500;
    private boolean on_attach = true;

    public NewsAdapter(Context context, List<SectionInfo> list) {
        this.context = context;
        this.news = list;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                ItemNewsBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context)
                        , R.layout.item_news, parent, false);
                return new Holder(binding);
            case VIEW_TYPE_LOADING:
                ItemLoadingBinding bindingloading= DataBindingUtil.inflate(LayoutInflater.from(context)
                        , R.layout.item_loading, parent, false);
                return new ProgressHolder(bindingloading);
            default:
                return null;
        }
    }


    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, final int position) {
        holder.onBind(position);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                Log.d(TAG, "onScrollStateChanged: Called " + newState);
                on_attach = false;
                super.onScrollStateChanged(recyclerView, newState);
            }
        });

        super.onAttachedToRecyclerView(recyclerView);
    }

    private void setAnimation(View itemView, int i) {
        if (!on_attach) {
            i = -1;
        }
        boolean isNotFirstItem = i == -1;
        i++;
        itemView.setAlpha(0.f);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator animator = ObjectAnimator.ofFloat(itemView, "alpha", 0.f, 0.5f, 1.0f);
        ObjectAnimator.ofFloat(itemView, "alpha", 0.f).start();
        animator.setStartDelay(isNotFirstItem ? DURATION / 2 : (i * DURATION / 3));
        animator.setDuration(500);
        animatorSet.play(animator);
        animator.start();
    }


    @Override
    public int getItemViewType(int position) {
        if (isLoaderVisible) {
            return position == news.size() - 1 ? VIEW_TYPE_LOADING : VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_NORMAL;
        }
    }
    @Override
    public int getItemCount() {
        return news == null ? 0 : news.size();
    }
    public void addItems(List<SectionInfo> postItems) {
        news.addAll(postItems);
        notifyDataSetChanged();
    }
    public void addLoading() {
        isLoaderVisible = true;
        news.add(new SectionInfo());
        notifyItemInserted(news.size() - 1);
    }
    public void removeLoading() {
        isLoaderVisible = false;
        int position = news.size() - 1;
        SectionInfo item = getItem(position);
        if (item != null) {
            news.remove(position);
            notifyItemRemoved(position);
        }
    }
    public void clear() {
        news.clear();
        notifyDataSetChanged();
    }
    SectionInfo getItem(int position) {
        return news.get(position);
    }


    public  class   Holder extends BaseViewHolder {
        private int mCurrentPosition;
        private ItemNewsBinding binding;

        public Holder(@NonNull ItemNewsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        @Override
        public void onBind(int position) {
            super.onBind(position);
            setAnimation(binding.getRoot(), position);
            SectionInfo item = news.get(position);

            binding.tvSection.setText(item.getSectionName());
            binding.tvTitle.setText(item.getNewsTitle());
            Glide.with(context).load(news.get(position).getImageLink())
                    .into(binding.img);

        }

        @Override
        protected void clear() {

        }
    }

    public class ProgressHolder extends BaseViewHolder {
        ItemLoadingBinding bindingloading;
        ProgressHolder(ItemLoadingBinding bindingloading ) {
            super(bindingloading.getRoot());
            this.bindingloading=bindingloading;

        }

        @Override
        protected void clear() {
        }
    }

}


