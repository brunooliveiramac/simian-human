package com.clean.example.entrypoints.rest;

public class StatisticsModel {


    private Long count_human_dna;

    private Long count_mutant_dna;

    private Long ratio;

    private StatisticsModel(Builder builder) {
        setCount_human_dna(builder.human);
        setCount_mutant_dna(builder.simian);
        setRatio(builder.ratio);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Long getCount_human_dna() {
        return count_human_dna;
    }

    public void setCount_human_dna(Long count_human_dna) {
        this.count_human_dna = count_human_dna;
    }

    public Long getCount_mutant_dna() {
        return count_mutant_dna;
    }

    public void setCount_mutant_dna(Long count_mutant_dna) {
        this.count_mutant_dna = count_mutant_dna;
    }

    public Long getRatio() {
        return ratio;
    }

    public void setRatio(Long ratio) {
        this.ratio = ratio;
    }

    public static final class Builder {
        private Long human;
        private Long simian;
        private Long ratio;

        private Builder() {
        }

        public Builder human(Long val) {
            human = val;
            return this;
        }

        public Builder simian(Long val) {
            simian = val;
            return this;
        }

        public Builder ratio(Long val) {
            ratio = val;
            return this;
        }

        public StatisticsModel build() {
            return new StatisticsModel(this);
        }
    }
}
