package com.lorance.ogel.dao.mapper;

import com.lorance.ogel.model.Production;
import com.lorance.ogel.model.Runtime;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RuntimeRowMapper implements RowMapper<Runtime>{

    public Runtime mapRow(ResultSet rs, int rowNum) throws SQLException {

        Runtime runtime = new Runtime();
        runtime.setId(rs.getLong("id"));
        runtime.setMachine_name(rs.getString("machine_name"));
//        runtime.setDatetime(rs.getObject("datetime", toLocalDateTime.class));
        runtime.setDatetime(rs.getTimestamp("datetime").toLocalDateTime());
        runtime.setIsRunning(rs.getBoolean("isrunning"));

        return runtime;
    }

}
