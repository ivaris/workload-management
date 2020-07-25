package com.wawa.repository.dao;

import com.wawa.model.Member;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.math.BigInteger;
import java.util.List;

public interface MemberGroupDao {
    @SqlQuery("SELECT GROUP_ID FROM GROUP_MEMBER WHERE MEMBER_ID = :id")
    List<Integer> fetchMemberGroups(@Bind("id") Integer id);
}
