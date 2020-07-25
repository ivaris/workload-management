package com.wawa.repository;

import com.wawa.model.Member;
import com.wawa.repository.dao.GroupDao;
import com.wawa.repository.dao.MemberDao;
import com.wawa.repository.dao.MemberGroupDao;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.math.BigInteger;
import java.util.List;

@Component
public class MemberRepository  {
    @Autowired
    private Jdbi jdbi;
    private MemberDao memberDao;
    private MemberGroupDao memberGroupDao;
    private GroupDao groupDao;

    @PostConstruct
    public void init() {
        memberDao = jdbi.onDemand(MemberDao.class);
        memberGroupDao = jdbi.onDemand(MemberGroupDao.class);
        groupDao = jdbi.onDemand(GroupDao.class);
    }

    public Member getMemberbyId(Integer id){
        Member member = memberDao.fetchStaffById(id);
        List<Integer> groupIds = memberGroupDao.fetchMemberGroups(id);
        if(groupIds!=null && groupIds.size()>0) {
            member.setGroups(groupDao.fetchGroups(groupIds));
        }
        return member;
    }

}
