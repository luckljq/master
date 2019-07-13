package com.ljq.hm.service;

import com.ljq.hm.entity.Member;

import java.util.List;

public interface MemberService {
    void add(Member member);
    void remove(String id);
    void edit(Member member);
    Member getById(String id);
    Member getByAccount(String account);
    Member getByRoomId(String roomId);
    List<Member> getAll();
}
