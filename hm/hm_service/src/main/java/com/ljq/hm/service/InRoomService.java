package com.ljq.hm.service;

import com.ljq.hm.entity.InRoom;

import java.util.List;

public interface InRoomService {
    void add(InRoom inRoom);
    void remove(String roomId);
    void edit(InRoom inRoom);
    List<InRoom> getById(String roomId);
    InRoom get(String id);
    List<InRoom> getAll();
}
