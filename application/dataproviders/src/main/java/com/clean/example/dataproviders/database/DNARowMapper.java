package com.clean.example.dataproviders.database;

import com.clean.example.core.entity.DNAEntity;
import com.clean.example.core.entity.DNAType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DNARowMapper implements RowMapper {

    @Override
    public DNAEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return DNAEntity.newBuilder()
                .dna(rs.getString("DNA_SEQUENCE").split(","))
                .dnaType(DNAType.valueOf(rs.getString("DNA_TYPE")))
                .build();
    }
}
