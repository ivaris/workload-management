package com.wawa.repository.dao;

import com.wawa.model.Member;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.math.BigInteger;

public interface MemberDao {
    @RegisterRowMapper(MemberMapper.class)
    @SqlQuery("SELECT * FROM MEMBER WHERE MEMBER_ID = :id")
    Member fetchStaffById(@Bind("id") Integer id);
}
