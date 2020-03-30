package com.example.vk;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import java.io.Serializable;

public class Post implements Parcelable{
    private String name;
    private String date;
    private int imgAva;
    private String description;
    private int img;
    private int imgLike;
    private boolean liked;
    private int likes;
    private int imgComment;
    private int comment;
    private int imgSend;
    private int send;
    private int imgViews;
    private int views;

    public Post(
            String name,
            String date,
            int imgAva,
            String description,
            int img,
            int imgLike,
            boolean liked,
            int likes,
            int imgComment,
            int comment,
            int imgSend,
            int send,
            int imgViews,
            int views
    ){
        this.name=name;
        this.date=date;
        this.imgAva=imgAva;
        this.description=description;
        this.img=img;
        this.imgLike=imgLike;
        this.liked=liked;
        this.likes=likes;
        this.imgComment=imgComment;
        this.comment=comment;
        this.imgSend=imgSend;
        this.send=send;
        this.imgViews=imgViews;
        this.views=views;
    }

    public Post() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String name) {
        this.date = date;
    }

    public int getImgAva() {
        return imgAva;
    }

    public void setImgAva(int imgAva) {
        this.imgAva = imgAva;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getImgLike() {
        return imgLike;
    }

    public void setImgLike(int imgLike) {
        this.imgLike = imgLike;
    }

    public boolean getLike() {
        return liked;
    }

    public void setLike(boolean like) {
        this.liked = like;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes){
        this.likes=likes;
    }

    public int getImgComment() {
        return imgComment;
    }

    public void setImgComment(int imgComment) {
        this.imgComment = imgComment;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public int getImgSend() {
        return imgSend;
    }

    public void setImgSend(int imgSend) {
        this.imgSend = imgSend;
    }

    public int getSend() {
        return send;
    }

    public void setSend(int send) {
        this.send = send;
    }

    public int getImgViews() {
        return imgViews;
    }

    public void setImgViews(int imgViews) {
        this.imgViews = imgViews;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(this.name);
        dest.writeString(this.date);
        dest.writeInt(this.imgAva);
        dest.writeString(this.description);
        dest.writeInt(this.img);
        dest.writeInt(this.imgLike);
        dest.writeBoolean(this.liked);
        dest.writeInt(this.likes);
        dest.writeInt(this.imgComment);
        dest.writeInt(comment);
        dest.writeInt(imgSend);
        dest.writeInt(send);
        dest.writeInt(this.imgViews);
        dest.writeInt(this.views);
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    protected Post(Parcel in) {
        this.name=in.readString();
        this.date=in.readString();
        this.imgAva=in.readInt();
        this.description=in.readString();
        this.img=in.readInt();
        this.imgLike=in.readInt();
        this.liked=in.readBoolean();
        this.likes=in.readInt();
        this.imgComment=in.readInt();
        this.comment=in.readInt();
        this.imgSend=in.readInt();
        this.imgViews=in.readInt();
        this.views=in.readInt();
    }

    public static final Parcelable.Creator<Post> CREATOR = new Parcelable.Creator<Post>(){
        @RequiresApi(api = Build.VERSION_CODES.Q)
        @Override
        public Post createFromParcel(Parcel source) {
            return new Post(source);
        }
        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };
}
