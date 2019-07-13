package com.ljq.hm.service.impl;

import com.ljq.hm.dao.InRoomDao;
import com.ljq.hm.entity.InRoom;
import com.ljq.hm.service.InRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("inRoomService")
public class InRoomServiceImpl implements InRoomService {

    @Qualifier("inRoomDao")
    @Autowired
    private InRoomDao inRoomDao;
    public void add(InRoom inRoom) {
        inRoomDao.insert(inRoom);
    }

    public void remove(String roomId) {
        inRoomDao.delete(roomId);
    }

    public void edit(InRoom inRoom) {
        inRoomDao.update(inRoom);
    }

    public List<InRoom> getById(String roomId) {
        return inRoomDao.selectById(roomId);
    }

    public InRoom get(String id) {
        return inRoomDao.select(id);
    }

    public List<InRoom> getAll() {
        return inRoomDao.selectAll();
    }
}
