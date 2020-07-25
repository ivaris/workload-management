package com.wawa.repository.dao;

import com.wawa.model.Member;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberMapper implements RowMapper<Member> {
    @Override
    public Member map(ResultSet rs, StatementContext ctx) throws SQLException {
        Member member = new Member();
        member.setId(rs.getInt("MEMBER_ID"));
        member.setName(rs.getString("NAME"));
        return member;
    }
}
