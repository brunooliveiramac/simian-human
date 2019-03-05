package com.clean.example.configuration;

import com.clean.example.core.usecase.dnaexistsusecase.DNAExistsUseCase;
import com.clean.example.core.usecase.dnaexistsusecase.GetDNAIfExists;
import com.clean.example.core.usecase.issiminaorhumanusecase.IsSimianOrHumanUseCase;
import com.clean.example.core.usecase.statistcsusecase.ObtemDNAs;
import com.clean.example.core.usecase.statistcsusecase.StatisticsUseCase;
import com.clean.example.core.usecase.storednausecase.StoreDNA;
import com.clean.example.core.usecase.storednausecase.StoreDNAUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {


    @Bean
    public StatisticsUseCase statisticsUseCase(ObtemDNAs obtemDNAs) {
        return new StatisticsUseCase(obtemDNAs);
    }

    @Bean
    public DNAExistsUseCase getDnaExistsUseCase(GetDNAIfExists getDNA) {
        return new DNAExistsUseCase(getDNA);
    }

    @Bean
    public IsSimianOrHumanUseCase getSimianOrHumanUseCase() {
        return new IsSimianOrHumanUseCase();
    }

    @Bean
    public StoreDNAUseCase getStoreDNAUseCase(StoreDNA store,
                                              IsSimianOrHumanUseCase isSimianOrHumanUseCase,
                                              DNAExistsUseCase dnaExistsUseCase) {
        return new StoreDNAUseCase(store, isSimianOrHumanUseCase, dnaExistsUseCase);

    }

}
