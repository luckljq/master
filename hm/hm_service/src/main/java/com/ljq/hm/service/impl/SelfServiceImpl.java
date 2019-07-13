package com.ljq.hm.service.impl;

import com.ljq.hm.dao.MemberDao;
import com.ljq.hm.dao.SelfDao;
import com.ljq.hm.entity.Member;
import com.ljq.hm.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("selfService")
public class SelfServiceImpl implements SelfService {

    @Qualifier("selfDao")
    @Autowired
    private SelfDao selfDao;

    @Qualifier("memberDao")
    @Autowired
    private MemberDao memberDao;
    public Member login(String account, String password) {
        Member member =selfDao.selectByAccount(account);
        if(member==null)return null;
        if(member.getPassword().equals(password))return member;
        return null;
    }

    public void changePassword(String id, String password) {
        Member member = memberDao.selectById(id);
        member.setPassword(password);
        memberDao.update(member);
    }
}
