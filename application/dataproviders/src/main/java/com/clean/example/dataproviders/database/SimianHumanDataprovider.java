package com.clean.example.dataproviders.database;

import com.clean.example.core.entity.DNAEntity;
import com.clean.example.core.usecase.dnaexistsusecase.GetDNAIfExists;
import com.clean.example.core.usecase.statistcsusecase.ObtemDNAs;
import com.clean.example.core.usecase.storednausecase.StoreDNA;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class SimianHumanDataprovider implements StoreDNA, GetDNAIfExists, ObtemDNAs {

    private JdbcTemplate jdbcTemplate;


    public SimianHumanDataprovider(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void sotore(DNAEntity dna) {
        jdbcTemplate.update("INSERT INTO clean_architecture.dna (id, dna_sequence, dna_type, created_date) VALUES (DNA_ID_SEQ.NEXTVAL, ?, ?, SYSDATE)", String.join(",", dna.getDnaSequence()), dna.getDnaType().toString());
    }

    @Override
    public boolean exists(String[] dna) {
        try {
            return jdbcTemplate.queryForObject("SELECT TOP 1 1 FROM clean_architecture.dna WHERE dna_sequence = ?", Integer.class, String.join(",", dna)) == 1;
        } catch (IncorrectResultSizeDataAccessException e) {
            return false;
        }
    }

    @Override
    public List<DNAEntity> listAll() {
        return jdbcTemplate.query("SELECT * FROM clean_architecture.dna", new DNARowMapper());
    }
}
