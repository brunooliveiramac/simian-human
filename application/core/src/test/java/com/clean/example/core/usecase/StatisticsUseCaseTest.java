package com.clean.example.core.usecase;

import com.clean.example.core.entity.DNAEntity;
import com.clean.example.core.entity.DNAStatistics;
import com.clean.example.core.entity.DNAType;
import com.clean.example.core.usecase.statistcsusecase.ObtemDNAs;
import com.clean.example.core.usecase.statistcsusecase.StatisticsUseCase;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.when;

public class StatisticsUseCaseTest {


    private ObtemDNAs obtemDNAs = Mockito.mock(ObtemDNAs.class);

    private StatisticsUseCase statisticsUseCase = new StatisticsUseCase(obtemDNAs);

    private DNAStatistics dnaStatistics;

    @Test
    public void shouldReturnEmptyStatisticsWhenTheyDontExists() {
        givenAnEmptyStatisticsFromDatabase();
        whenISearch();
        thenShouldReturnEmpty();
    }

    private void whenISearch() {
        dnaStatistics = statisticsUseCase.get();
    }

    private void thenShouldReturnEmpty() {
        assertNotNull(dnaStatistics);
        assertNull(dnaStatistics.getHuman());
        assertNull(dnaStatistics.getSimian());
        assertEquals(0.0, dnaStatistics.getRatio());
    }

    private void givenAnEmptyStatisticsFromDatabase() {
        when(obtemDNAs.listAll()).thenReturn(Collections.emptyList());
    }


    @Test
    public void shouldReturnStatistics() {
        givenStatisticsFromDatabase();
        whenISearch();
        thenShouldReturn();
    }

    private void givenStatisticsFromDatabase() {
        when(obtemDNAs.listAll()).thenReturn(Arrays.asList(DNAEntity.newBuilder()
                .dnaType(DNAType.HUMAN)
                .build(), DNAEntity.newBuilder()
                .dnaType(DNAType.SIMIAN)
                .build()));

    }

    private void thenShouldReturn() {
        assertEquals(0.5, dnaStatistics.getRatio());
        assertTrue(1 == dnaStatistics.getHuman());
        assertTrue(1 == dnaStatistics.getSimian());
    }

}
