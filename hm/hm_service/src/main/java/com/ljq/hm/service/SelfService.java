package com.ljq.hm.service;

import com.ljq.hm.entity.Member;

public interface SelfService {
    Member login(String account,String password);
    void changePassword(String id,String password);
}
