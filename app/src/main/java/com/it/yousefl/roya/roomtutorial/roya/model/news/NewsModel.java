package com.it.yousefl.roya.roomtutorial.roya.model.news;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsModel {
    @SerializedName("section_info")
    @Expose
    private List<SectionInfo> sectionInfo = null;
    @SerializedName("surveys")
    @Expose
    private List<Object> surveys = null;
    @SerializedName("special_events")
    @Expose
    private List<SpecialEvent> specialEvents = null;
    @SerializedName("now_showing")
    @Expose
    private Object nowShowing;
    @SerializedName("breaking_news")
    @Expose
    private List<BreakingNews> breakingNews = null;

    public List<SectionInfo> getSectionInfo() {
        return sectionInfo;
    }

    public void setSectionInfo(List<SectionInfo> sectionInfo) {
        this.sectionInfo = sectionInfo;
    }

    public List<Object> getSurveys() {
        return surveys;
    }

    public void setSurveys(List<Object> surveys) {
        this.surveys = surveys;
    }

    public List<SpecialEvent> getSpecialEvents() {
        return specialEvents;
    }

    public void setSpecialEvents(List<SpecialEvent> specialEvents) {
        this.specialEvents = specialEvents;
    }

    public Object getNowShowing() {
        return nowShowing;
    }

    public void setNowShowing(Object nowShowing) {
        this.nowShowing = nowShowing;
    }

    public List<BreakingNews> getBreakingNews() {
        return breakingNews;
    }

    public void setBreakingNews(List<BreakingNews> breakingNews) {
        this.breakingNews = breakingNews;
    }
}
