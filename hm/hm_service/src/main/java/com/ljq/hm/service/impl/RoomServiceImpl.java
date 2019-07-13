package com.ljq.hm.service.impl;

import com.ljq.hm.dao.RoomDao;
import com.ljq.hm.entity.Room;
import com.ljq.hm.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roomService")
public class RoomServiceImpl implements RoomService {

    @Qualifier("roomDao")
    @Autowired
    private RoomDao roomDao;

    public void add(Room room) {
        roomDao.insert(room);
    }

    public void remove(String id) {
        roomDao.delete(id);
    }

    public void edit(Room room) {
        roomDao.update(room);
    }

    public Room getById(String id) {
        return roomDao.selectById(id);
    }

    public List<Room> getByType(String roomType) {
        return roomDao.selectByType(roomType);
    }

    public List<Room> getByState(String roomType, String state) {
        return roomDao.selectByState(roomType,state);
    }

    public List<Room> getByFloor(String roomType, String state, String floor) {
        return roomDao.selectByFloor(roomType,state,floor);
    }

    public List<Room> getAll() {
        return roomDao.selectAll();
    }

    public List<Room> getByYd(String state) {
        return roomDao.selectByYd(state);
    }

}
