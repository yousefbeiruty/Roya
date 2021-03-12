package com.it.yousefl.roya.roomtutorial.roya.model.news;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.it.yousefl.roya.roomtutorial.roya.db.Converters;

@Entity(tableName = "SectionInfo")
public class SectionInfo {
    @PrimaryKey(autoGenerate = true)
    int section_info_id;

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("news_title")
    @Expose
    private String newsTitle;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("section_id")
    @Expose
    private Integer sectionId;
    @SerializedName("section_name")
    @Expose
    private String sectionName;
    @SerializedName("news_id")
    @Expose
    private Integer newsId;
    @SerializedName("created_age")
    @Expose
    private String createdAge;
    @SerializedName("main_image_path")
    @Expose
    private String mainImagePath;
    @SerializedName("imageLink")
    @Expose
    private String imageLink;
    @SerializedName("createdstamp")
    @Expose
    private Integer createdstamp;
    @SerializedName("updatedstamp")
    @Expose
    private Boolean updatedstamp;
    @SerializedName("createdDate")
    @Expose
    private String createdDate;
    @SerializedName("news_section")
    @Expose
    private String newsSection;
    @SerializedName("news_link")
    @Expose
    private String newsLink;
    @SerializedName("section")
    @Expose
    @Ignore
    private Section section;

    public int getSection_info_id() {
        return section_info_id;
    }

    public void setSection_info_id(int section_info_id) {
        this.section_info_id = section_info_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getCreatedAge() {
        return createdAge;
    }

    public void setCreatedAge(String createdAge) {
        this.createdAge = createdAge;
    }

    public String getMainImagePath() {
        return mainImagePath;
    }

    public void setMainImagePath(String mainImagePath) {
        this.mainImagePath = mainImagePath;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public Integer getCreatedstamp() {
        return createdstamp;
    }

    public void setCreatedstamp(Integer createdstamp) {
        this.createdstamp = createdstamp;
    }

    public Boolean getUpdatedstamp() {
        return updatedstamp;
    }

    public void setUpdatedstamp(Boolean updatedstamp) {
        this.updatedstamp = updatedstamp;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getNewsSection() {
        return newsSection;
    }

    public void setNewsSection(String newsSection) {
        this.newsSection = newsSection;
    }

    public String getNewsLink() {
        return newsLink;
    }

    public void setNewsLink(String newsLink) {
        this.newsLink = newsLink;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
