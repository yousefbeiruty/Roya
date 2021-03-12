package com.it.yousefl.roya.roomtutorial.roya.model.news;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BreakingNews {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("news_id")
    @Expose
    private Object newsId;
    @SerializedName("notifiable")
    @Expose
    private Integer notifiable;
    @SerializedName("active")
    @Expose
    private Integer active;
    @SerializedName("views")
    @Expose
    private Integer views;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("deleted_at")
    @Expose
    private Object deletedAt;
    @SerializedName("breaking_news_id")
    @Expose
    private Integer breakingNewsId;
    @SerializedName("breaking_news_title")
    @Expose
    private String breakingNewsTitle;
    @SerializedName("breaking_news_active")
    @Expose
    private Integer breakingNewsActive;
    @SerializedName("breaking_news_views")
    @Expose
    private Integer breakingNewsViews;
    @SerializedName("breaking_createdstamp")
    @Expose
    private Integer breakingCreatedstamp;
    @SerializedName("breaking_updatedstamp")
    @Expose
    private Integer breakingUpdatedstamp;
    @SerializedName("createdDate")
    @Expose
    private String createdDate;
    @SerializedName("created_age")
    @Expose
    private String createdAge;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getNewsId() {
        return newsId;
    }

    public void setNewsId(Object newsId) {
        this.newsId = newsId;
    }

    public Integer getNotifiable() {
        return notifiable;
    }

    public void setNotifiable(Integer notifiable) {
        this.notifiable = notifiable;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Integer getBreakingNewsId() {
        return breakingNewsId;
    }

    public void setBreakingNewsId(Integer breakingNewsId) {
        this.breakingNewsId = breakingNewsId;
    }

    public String getBreakingNewsTitle() {
        return breakingNewsTitle;
    }

    public void setBreakingNewsTitle(String breakingNewsTitle) {
        this.breakingNewsTitle = breakingNewsTitle;
    }

    public Integer getBreakingNewsActive() {
        return breakingNewsActive;
    }

    public void setBreakingNewsActive(Integer breakingNewsActive) {
        this.breakingNewsActive = breakingNewsActive;
    }

    public Integer getBreakingNewsViews() {
        return breakingNewsViews;
    }

    public void setBreakingNewsViews(Integer breakingNewsViews) {
        this.breakingNewsViews = breakingNewsViews;
    }

    public Integer getBreakingCreatedstamp() {
        return breakingCreatedstamp;
    }

    public void setBreakingCreatedstamp(Integer breakingCreatedstamp) {
        this.breakingCreatedstamp = breakingCreatedstamp;
    }

    public Integer getBreakingUpdatedstamp() {
        return breakingUpdatedstamp;
    }

    public void setBreakingUpdatedstamp(Integer breakingUpdatedstamp) {
        this.breakingUpdatedstamp = breakingUpdatedstamp;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedAge() {
        return createdAge;
    }

    public void setCreatedAge(String createdAge) {
        this.createdAge = createdAge;
    }
}
