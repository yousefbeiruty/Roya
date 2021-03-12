package com.it.yousefl.roya.roomtutorial.roya.model.news;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SpecialEvent {
    @SerializedName("event_id")
    @Expose
    private Integer eventId;
    @SerializedName("event_title")
    @Expose
    private String eventTitle;
    @SerializedName("event_topbar_text")
    @Expose
    private String eventTopbarText;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("event_topbar_text1")
    @Expose
    private String eventTopbarText1;
    @SerializedName("created_age")
    @Expose
    private String createdAge;

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventTopbarText() {
        return eventTopbarText;
    }

    public void setEventTopbarText(String eventTopbarText) {
        this.eventTopbarText = eventTopbarText;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getEventTopbarText1() {
        return eventTopbarText1;
    }

    public void setEventTopbarText1(String eventTopbarText1) {
        this.eventTopbarText1 = eventTopbarText1;
    }

    public String getCreatedAge() {
        return createdAge;
    }

    public void setCreatedAge(String createdAge) {
        this.createdAge = createdAge;
    }
}
