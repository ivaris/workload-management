package com.wawa.repository.dao;

import com.wawa.model.Group;
import com.wawa.model.Member;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindList;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;

import java.math.BigInteger;
import java.util.List;

public interface GroupDao {
    @RegisterRowMapper(GroupMapper.class)
    @SqlQuery("SELECT * FROM VAWA_GROUP WHERE GROUP_ID in (<groupId>)")
    List<Group> fetchGroups(@BindList("groupId") List<Integer> groupId);
}
