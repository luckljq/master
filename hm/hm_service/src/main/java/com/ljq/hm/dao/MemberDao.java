package com.ljq.hm.dao;

import com.ljq.hm.entity.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("memberDao")
public interface MemberDao {

    void insert(Member member);
    void delete(String id);
    void update(Member member);
    Member selectById(String id);
    Member selectByRoomId(String roomId);
    Member selectByAccount(String account);
    List<Member> selectAll();
}
