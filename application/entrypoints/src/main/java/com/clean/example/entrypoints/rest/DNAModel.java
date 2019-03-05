package com.clean.example.entrypoints.rest;

import java.util.Arrays;

public class DNAModel {

    private String[] dna;


    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }

    @Override
    public String toString() {
        return "DNAModel{" +
                "dna=" + Arrays.toString(dna) +
                '}';
    }
}
