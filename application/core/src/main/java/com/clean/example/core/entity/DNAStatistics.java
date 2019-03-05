package com.clean.example.core.entity;

public class DNAStatistics {


    private Long human;

    private Long simian;

    private double ratio;

    private DNAStatistics(Builder builder) {
        setHuman(builder.human);
        setSimian(builder.simian);
        setRatio(builder.ratio);
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public Long getHuman() {
        return human;
    }

    public void setHuman(Long human) {
        this.human = human;
    }

    public Long getSimian() {
        return simian;
    }

    public void setSimian(Long simian) {
        this.simian = simian;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public static DNAStatistics empty() {
        return DNAStatistics.newBuilder().build();
    }


    public static final class Builder {
        private Long human;
        private Long simian;
        private double ratio;

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

        public Builder ratio(double val) {
            ratio = val;
            return this;
        }

        public DNAStatistics build() {
            return new DNAStatistics(this);
        }
    }
}
