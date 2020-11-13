package com.lorance.ogel.dao.mapper;

import com.lorance.ogel.model.Production;
//import com.lorance.ogel.model.Runtime;

import org.springframework.jdbc.core.RowMapper;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ProductionRowMapper implements RowMapper<Production>{

    public Production mapRow(ResultSet rs, int rowNum) throws SQLException {

        Production production = new Production();
        production.setId(rs.getLong("id"));
        production.setMachine_name(rs.getString("machine_name"));
        production.setVariable_name(rs.getString("variable_name"));
        production.setDatetime_from(rs.getTimestamp("datetime_from").toLocalDateTime());
        production.setDatetime_to(rs.getTimestamp("datetime_to").toLocalDateTime());
        production.setValue(rs.getInt("value"));

        return production;
    }
}
