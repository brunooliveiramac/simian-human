package com.clean.example.entrypoints.rest;

import com.clean.example.core.entity.DNAEntity;
import com.clean.example.core.entity.DNAStatistics;
import com.clean.example.core.entity.DNAType;
import com.clean.example.core.usecase.statistcsusecase.StatisticsUseCase;
import com.clean.example.core.usecase.storednausecase.StoreDNAUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
public class SimianHumanEntrypoint {

    public static final String SAVE_PATH = "/simian";

    public static final String GET_PATH = "/stats";


    private static final Logger LOGGER = LoggerFactory.getLogger(SimianHumanEntrypoint.class);

    public StoreDNAUseCase storeDNAUseCase;
    public StatisticsUseCase statisticsUseCase;

    public SimianHumanEntrypoint(StoreDNAUseCase storeDNAUseCase, StatisticsUseCase statisticsUseCase) {
        this.storeDNAUseCase = storeDNAUseCase;
        this.statisticsUseCase = statisticsUseCase;
    }

    @RequestMapping(value = SAVE_PATH, method = POST)
    public ResponseEntity save(@RequestBody DNAModel model) {

        LOGGER.info("Retrieving details of dna: {}", model);

        DNAEntity dna = null;

        if (model.getDna().length == 0) {
            return new ResponseEntity<>("Please inform the DNA sequence", HttpStatus.BAD_REQUEST);
        }

        try {
            dna = storeDNAUseCase.save(toEntity(model));
        } catch (Exception e) {
            return new ResponseEntity<>("Already Exists", HttpStatus.BAD_REQUEST);
        }

        if (dna.getDnaType() == DNAType.SIMIAN) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = GET_PATH, method = GET)
    public StatisticsModel getStatistics() {
        return toModel(statisticsUseCase.get());
    }

    private StatisticsModel toModel(DNAStatistics dnaStatistics) {
        return StatisticsModel.newBuilder()
                .human(dnaStatistics.getHuman())
                .simian(dnaStatistics.getSimian())
                .ratio(dnaStatistics.getRatio())
                .build();
    }


    private DNAEntity toEntity(DNAModel dnaDto) {
        return DNAEntity.newBuilder()
                .dna(dnaDto.getDna())
                .build();
    }


}
