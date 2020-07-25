package com.wawa.repository.dao;

import com.wawa.model.Group;
import com.wawa.model.Member;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupMapper implements RowMapper<Group> {
    @Override
    public Group map(ResultSet rs, StatementContext ctx) throws SQLException {
        Group group = new Group();
        group.setId(rs.getInt("GROUP_ID"));
        group.setName(rs.getString("NAME"));
        return group;
    }
}
