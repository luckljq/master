package com.ljq.hm.entity;

/**
 * 客人信息
 */
public class InRoom {

    private String id;     //身份证号码
    private String name;    //姓名
    private String sex;     //性别
    private String roomId;  //房间号
    private String state;   //状态（已预定/已入住)
    private String diction; //客人备注

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomid) {
        this.roomId = roomid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDiction() {
        return diction;
    }

    public void setDiction(String diction) {
        this.diction = diction;
    }
}
