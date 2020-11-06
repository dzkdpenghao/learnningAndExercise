package entity;

import java.util.Date;

public class Album {
    private Integer id;

    private String gmId;

    private Integer categoryId;

    private String cateCode;

    private String type;

    private String albumId;

    private String albumName;

    private String albumPinyin;

    private String albumVerpic;

    private String albumHorpic;

    private String albumVerSmallPic;

    private String albumHorSmallPic;

    private String episodeUpdated;

    private String episodeTotal;

    private String genre;

    private String area;

    private Short year;

    private String language;

    private String source;

    private String director;

    private String actor;

    private Date publishTime;

    private Long duration;

    private Boolean fee;

    private Boolean isClip;

    private Date updateTime;

    private Boolean isShow;

    private Boolean isEarly;

    private String dataRights;

    private Integer createdAt;

    private Integer updatedAt;

    private String albumDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGmId() {
        return gmId;
    }

    public void setGmId(String gmId) {
        this.gmId = gmId == null ? null : gmId.trim();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCateCode() {
        return cateCode;
    }

    public void setCateCode(String cateCode) {
        this.cateCode = cateCode == null ? null : cateCode.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId == null ? null : albumId.trim();
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName == null ? null : albumName.trim();
    }

    public String getAlbumPinyin() {
        return albumPinyin;
    }

    public void setAlbumPinyin(String albumPinyin) {
        this.albumPinyin = albumPinyin == null ? null : albumPinyin.trim();
    }

    public String getAlbumVerpic() {
        return albumVerpic;
    }

    public void setAlbumVerpic(String albumVerpic) {
        this.albumVerpic = albumVerpic == null ? null : albumVerpic.trim();
    }

    public String getAlbumHorpic() {
        return albumHorpic;
    }

    public void setAlbumHorpic(String albumHorpic) {
        this.albumHorpic = albumHorpic == null ? null : albumHorpic.trim();
    }

    public String getAlbumVerSmallPic() {
        return albumVerSmallPic;
    }

    public void setAlbumVerSmallPic(String albumVerSmallPic) {
        this.albumVerSmallPic = albumVerSmallPic == null ? null : albumVerSmallPic.trim();
    }

    public String getAlbumHorSmallPic() {
        return albumHorSmallPic;
    }

    public void setAlbumHorSmallPic(String albumHorSmallPic) {
        this.albumHorSmallPic = albumHorSmallPic == null ? null : albumHorSmallPic.trim();
    }

    public String getEpisodeUpdated() {
        return episodeUpdated;
    }

    public void setEpisodeUpdated(String episodeUpdated) {
        this.episodeUpdated = episodeUpdated == null ? null : episodeUpdated.trim();
    }

    public String getEpisodeTotal() {
        return episodeTotal;
    }

    public void setEpisodeTotal(String episodeTotal) {
        this.episodeTotal = episodeTotal == null ? null : episodeTotal.trim();
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre == null ? null : genre.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public Short getYear() {
        return year;
    }

    public void setYear(Short year) {
        this.year = year;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director == null ? null : director.trim();
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor == null ? null : actor.trim();
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Boolean getFee() {
        return fee;
    }

    public void setFee(Boolean fee) {
        this.fee = fee;
    }

    public Boolean getIsClip() {
        return isClip;
    }

    public void setIsClip(Boolean isClip) {
        this.isClip = isClip;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    public Boolean getIsEarly() {
        return isEarly;
    }

    public void setIsEarly(Boolean isEarly) {
        this.isEarly = isEarly;
    }

    public String getDataRights() {
        return dataRights;
    }

    public void setDataRights(String dataRights) {
        this.dataRights = dataRights == null ? null : dataRights.trim();
    }

    public Integer getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Integer updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getAlbumDesc() {
        return albumDesc;
    }

    public void setAlbumDesc(String albumDesc) {
        this.albumDesc = albumDesc == null ? null : albumDesc.trim();
    }
}