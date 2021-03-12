package com.it.yousefl.roya.roomtutorial.roya.model.news;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Section {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("show_in_homepage")
    @Expose
    private Integer showInHomepage;
    @SerializedName("show_in_app")
    @Expose
    private Integer showInApp;
    @SerializedName("order")
    @Expose
    private Integer order;
    @SerializedName("iframe")
    @Expose
    private Object iframe;
    @SerializedName("thumbs_images")
    @Expose
    private Integer thumbsImages;
    @SerializedName("alias_ar")
    @Expose
    private String aliasAr;
    @SerializedName("alias_en")
    @Expose
    private String aliasEn;
    @SerializedName("ads_code")
    @Expose
    private String adsCode;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("deleted_at")
    @Expose
    private Object deletedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getShowInHomepage() {
        return showInHomepage;
    }

    public void setShowInHomepage(Integer showInHomepage) {
        this.showInHomepage = showInHomepage;
    }

    public Integer getShowInApp() {
        return showInApp;
    }

    public void setShowInApp(Integer showInApp) {
        this.showInApp = showInApp;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Object getIframe() {
        return iframe;
    }

    public void setIframe(Object iframe) {
        this.iframe = iframe;
    }

    public Integer getThumbsImages() {
        return thumbsImages;
    }

    public void setThumbsImages(Integer thumbsImages) {
        this.thumbsImages = thumbsImages;
    }

    public String getAliasAr() {
        return aliasAr;
    }

    public void setAliasAr(String aliasAr) {
        this.aliasAr = aliasAr;
    }

    public String getAliasEn() {
        return aliasEn;
    }

    public void setAliasEn(String aliasEn) {
        this.aliasEn = aliasEn;
    }

    public String getAdsCode() {
        return adsCode;
    }

    public void setAdsCode(String adsCode) {
        this.adsCode = adsCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }
}
