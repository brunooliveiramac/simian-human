package com.clean.example.core.usecase.storednausecase;

import com.clean.example.core.entity.DNAEntity;
import com.clean.example.core.entity.DNAType;
import com.clean.example.core.usecase.dnaexistsusecase.DNAExistsUseCase;
import com.clean.example.core.usecase.issiminaorhumanusecase.IsSimianOrHumanUseCase;

public class StoreDNAUseCase {

    private StoreDNA store;

    private IsSimianOrHumanUseCase isSimianOrHumanUseCase;

    private DNAExistsUseCase dnaExistsUseCase;

    public StoreDNAUseCase(StoreDNA store, IsSimianOrHumanUseCase isSimianOrHumanUseCase, DNAExistsUseCase dnaExistsUseCase) {
        this.store = store;
        this.isSimianOrHumanUseCase = isSimianOrHumanUseCase;
        this.dnaExistsUseCase = dnaExistsUseCase;
    }

    public DNAEntity save(DNAEntity dnaEntity) throws Exception {

        if (dnaExistsUseCase.execute(dnaEntity.getDnaSequence())) {
            throw new Exception("Already Exists");
        }

        boolean simian = isSimianOrHumanUseCase.isSimian(dnaEntity.getDnaSequence());

        dnaEntity.setDnaType(simian ? DNAType.SIMIAN : DNAType.HUMAN);

        store.sotore(dnaEntity);

        return dnaEntity;
    }
}
