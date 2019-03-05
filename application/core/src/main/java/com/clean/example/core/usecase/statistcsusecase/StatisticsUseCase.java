package com.clean.example.core.usecase.statistcsusecase;

import com.clean.example.core.entity.DNAEntity;
import com.clean.example.core.entity.DNAStatistics;
import com.clean.example.core.entity.DNAType;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticsUseCase {

    private ObtemDNAs obtemDNAs;

    public StatisticsUseCase(ObtemDNAs obtemDNAs) {
        this.obtemDNAs = obtemDNAs;
    }

    public DNAStatistics get() {

        List<DNAEntity> dnaEntities = obtemDNAs.listAll();

        if (dnaEntities.size() == 0) {
            return DNAStatistics.empty();
        }

        Map<DNAType, Long> collect = dnaEntities.stream().collect(
                Collectors.groupingBy(DNAEntity::getDnaType, Collectors.counting()));

        Long simian = collect.get(DNAType.SIMIAN);
        Long human = collect.get(DNAType.HUMAN);

        double ratio = ((double) simian / dnaEntities.size());

        return DNAStatistics.newBuilder()
                .human(human)
                .simian(simian)
                .ratio(ratio)
                .build();

    }
}
