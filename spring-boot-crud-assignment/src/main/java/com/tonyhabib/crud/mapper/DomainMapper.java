package com.tonyhabib.crud.mapper;

import com.tonyhabib.crud.entity.Domain;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DomainMapper implements RowMapper<Domain> {
    @Override
    public Domain mapRow(ResultSet resultSet, int i) throws SQLException {

        Domain domain = new Domain();

        domain.setDomain(resultSet.getString(1));
        domain.setCount(resultSet.getInt(2));

        return domain;
    }
}
