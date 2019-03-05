package com.clean.example.core.entity;

import java.util.Arrays;

public class DNAEntity {

    private DNAType dnaType;
    private String[] dnaSequence;

    private DNAEntity(Builder builder) {
        setDnaType(builder.dnaType);
        setDnaSequence(builder.dna);
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public DNAType getDnaType() {
        return dnaType;
    }

    public String getDnaTypeValue() {
        return dnaType.toString();
    }

    public void setDnaType(DNAType dnaType) {
        this.dnaType = dnaType;
    }

    public String[] getDnaSequence() {
        return dnaSequence;
    }

    public void setDnaSequence(String[] dnaSequence) {
        this.dnaSequence = dnaSequence;
    }

    public static final class Builder {
        private DNAType dnaType;
        private String[] dna;

        private Builder() {
        }

        public Builder dnaType(DNAType val) {
            dnaType = val;
            return this;
        }

        public Builder dna(String[] val) {
            dna = val;
            return this;
        }

        public DNAEntity build() {
            return new DNAEntity(this);
        }
    }

    @Override
    public String toString() {
        return "DNAEntity{" +
                "dnaType=" + dnaType +
                ", dnaSequence=" + Arrays.toString(dnaSequence) +
                '}';
    }
}
