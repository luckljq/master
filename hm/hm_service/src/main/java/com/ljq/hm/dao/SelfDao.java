package com.ljq.hm.dao;

import com.ljq.hm.entity.Member;
import org.springframework.stereotype.Repository;

@Repository("selfDao")
public interface SelfDao {
    Member selectByAccount(String account);
}
