package com.kh.jdbc.librarysystem.vo;

import java.sql.Date;

public class PostVO {
    private int postNo;
    private String title;
    private String userID;
    private String content;
    private Date postDate;

    public PostVO(int postNo, String title, String userID, String content, Date postDate) {
        this.postNo = postNo;
        this.title = title;
        this.userID = userID;
        this.content = content;
        this.postDate = postDate;
    }

    public int getPostNo() {
        return postNo;
    }

    public void setPostNo(int postNo) {
        this.postNo = postNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }
}
