package com.ljq.hm.service.impl;

import com.ljq.hm.dao.LogDao;
import com.ljq.hm.entity.Log;
import com.ljq.hm.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("logService")
public class LogServiceImpl implements LogService {

    @Qualifier("logDao")
    @Autowired
    private LogDao logDao;
    public void add(Log log) {
        logDao.insert(log);
    }

    public void edit(Log log) {
        logDao.update(log);
    }

    public List<Log> getById(String id) {
        return logDao.selectById(id);
    }

    public List<Log> getByName(String name) {
        return logDao.selectByName(name);
    }

    public List<Log> getByRoomId(String roomId) {
        return logDao.selectByRoomId(roomId);
    }

    public List<Log> getAll() {
        return logDao.selectAll();
    }
}
