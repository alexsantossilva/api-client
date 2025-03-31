package api.client.infra.config.usecase

import api.client.domain.ports.processor.ClienteProcessorProvider
import api.client.domain.usecase.ProcessClienteUseCase
import api.client.domain.usecase.impl.ProcessClienteUseCaseImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ProcessClienteUseCaseConfig {

    @Bean
    fun getClienteUseCase(clienteProcessorProvider: ClienteProcessorProvider): ProcessClienteUseCase {
        return ProcessClienteUseCaseImpl(clienteProcessorProvider)
    }

}