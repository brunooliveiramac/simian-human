package com.clean.example.core.usecase.dnaexistsusecase;

public class DNAExistsUseCase {


    private GetDNAIfExists getDNA;


    public DNAExistsUseCase(GetDNAIfExists getDNA) {
        this.getDNA = getDNA;
    }

    public boolean execute(String[] dna){
        return getDNA.exists(dna);
    }

}
