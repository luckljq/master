package com.ljq.hm.dao;

import com.ljq.hm.entity.InRoom;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("inRoomDao")
public interface InRoomDao {
    void insert(InRoom inRoom);
    void delete(String roomId);
    void update(InRoom inRoom);
    List<InRoom> selectById(String roomId);
    InRoom select(String id);
    List<InRoom> selectAll();
}
