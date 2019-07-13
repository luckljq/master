package com.ljq.hm.service;

import com.ljq.hm.entity.Log;

import java.util.List;

public interface LogService {
    void add(Log log);
    void edit(Log log);
    List<Log> getById(String id);
    List<Log> getByName(String name);
    List<Log> getByRoomId(String roomId);
    List<Log> getAll();
}
