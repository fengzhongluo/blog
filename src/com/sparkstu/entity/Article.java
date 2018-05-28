package com.sparkstu.entity;

import java.util.Date;

public class Article {
	private String id;
	private String title;
	private String author;
	private String summary;
	private String content;
	private long commentNum;
	private long heartNum;
	private long readnum;
	private Date publishTime;
	private String url;
	private String signature;
	private String categoryID;
	private Date lastUpdateTime;
	private String path;
	private String coverURL;
	private long type;
	private long status;
	private String statusName;
	private String html;
	private String tags;
	private long shareNum;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(long commentNum) {
		this.commentNum = commentNum;
	}

	public void setHeartNum(long heartNum) {
		this.heartNum = heartNum;
	}

	public void setReadnum(long readnum) {
		this.readnum = readnum;
	}

	public void setType(long type) {
		this.type = type;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	public void setShareNum(long shareNum) {
		this.shareNum = shareNum;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getCoverURL() {
		return coverURL;
	}

	public void setCoverURL(String coverURL) {
		this.coverURL = coverURL;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}


}
