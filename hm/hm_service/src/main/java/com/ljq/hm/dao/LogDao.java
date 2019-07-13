package com.ljq.hm.dao;

import com.ljq.hm.entity.Log;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("logDao")
public interface LogDao {
    void insert(Log log);
    void update(Log log);
    List<Log> selectById(String id);
    List<Log> selectByName(String name);
    List<Log> selectByRoomId(String roomId);
    List<Log> selectAll();
}
