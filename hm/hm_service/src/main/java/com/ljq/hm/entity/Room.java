package com.ljq.hm.entity;

/**
 * 房间信息
 */
public class Room {

    private String roomId;      //房间编号
    private String state;       //房间状态（空闲/有课/预定
    private String roomType;        //房间类型
    private Integer price;      //房间价格
    private String diction;     //房间描述

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDiction() {
        return diction;
    }

    public void setDiction(String diction) {
        this.diction = diction;
    }
}
