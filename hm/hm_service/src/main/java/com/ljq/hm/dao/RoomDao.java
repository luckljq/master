package com.ljq.hm.dao;

import com.ljq.hm.entity.Room;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("roomDao")
public interface RoomDao {
    void insert(Room room);
    void delete(String id);
    void update(Room room);
    Room selectById(String id);
    List<Room> selectByType(String roomType);
    List<Room> selectByState(String roomType,String state);
    List<Room> selectByFloor(String roomType,String state,String floor);
    List<Room> selectAll();
    List<Room> selectByYd(String state);
}
