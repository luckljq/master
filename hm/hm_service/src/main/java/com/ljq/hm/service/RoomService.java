package com.ljq.hm.service;

import com.ljq.hm.entity.Room;

import java.util.List;

public interface RoomService {
    void add(Room room);
    void remove(String id);
    void edit(Room room);
    Room getById(String id);
    List<Room> getByType(String roomType);
    List<Room> getByState(String roomType,String state);
    List<Room> getByFloor(String roomType,String state,String floor);
    List<Room> getAll();
    List<Room> getByYd(String state);
}
