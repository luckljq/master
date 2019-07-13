package com.ljq.hm.service.impl;

import com.ljq.hm.dao.MemberDao;
import com.ljq.hm.entity.Member;
import com.ljq.hm.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

    @Qualifier("memberDao")
    @Autowired
    private MemberDao memberDao;
    public void add(Member member) {
        memberDao.insert(member);
    }

    public void remove(String id) {
        memberDao.delete(id);
    }

    public void edit(Member member) {
        memberDao.update(member);
    }

    public Member getById(String id) {
        return memberDao.selectById(id);
    }

    public Member getByAccount(String account) {
        return memberDao.selectByAccount(account);
    }

    public Member getByRoomId(String roomId) {
        return memberDao.selectByRoomId(roomId);
    }

    public List<Member> getAll() {
        return memberDao.selectAll();
    }
}
