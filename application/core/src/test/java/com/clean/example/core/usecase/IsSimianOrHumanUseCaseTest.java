package com.clean.example.core.usecase;


import com.clean.example.core.usecase.issiminaorhumanusecase.IsSimianOrHumanUseCase;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IsSimianOrHumanUseCaseTest {

    private String[] dna;
    private boolean isSimian;

    public IsSimianOrHumanUseCase isSimianOrHumanUseCase = new IsSimianOrHumanUseCase();

    @Test
    public void shouldBeASimianWhenHasFourEqualsLetters() {
        givenAnArrayOfDNA();
        whenITestThisDNA();
        thenShouldBeASimian();

    }

    private void thenShouldBeASimian() {
        assertTrue(isSimian);
    }

    private void whenITestThisDNA() {
        isSimian = isSimianOrHumanUseCase.isSimian(dna);
    }

    private void givenAnArrayOfDNA() {
        dna = new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
    }


    @Test
    public void shouldNotBeASimianWhenHasNotFourEqualsLetters() {
        givenAnArrayOfDNAWithNoFourConsecutiveLetter();
        whenITestThisDNA();
        thenShouldNotBeASimian();

    }

    private void thenShouldNotBeASimian() {
        assertFalse(isSimian);
    }

    private void givenAnArrayOfDNAWithNoFourConsecutiveLetter() {
       dna = new String[]{"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CACCTA", "TCACTG"};
    }



}
