package com.clean.example.configuration;

import com.clean.example.core.usecase.statistcsusecase.StatisticsUseCase;
import com.clean.example.core.usecase.storednausecase.StoreDNAUseCase;
import com.clean.example.entrypoints.rest.SimianHumanEntrypoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EndpointConfiguration {

    @Bean
    public SimianHumanEntrypoint getSimianHumanEntrypoint(StoreDNAUseCase storeDNAUseCase, StatisticsUseCase statisticsUseCase) {
        return new SimianHumanEntrypoint(storeDNAUseCase, statisticsUseCase);
    }

}
