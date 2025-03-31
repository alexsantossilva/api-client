package api.client.infra.config.provider

import api.client.infra.provider.processor.ProcessorProvider
import api.client.infra.queue.RabbitMQProducer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ClientProcessorProviderConfig {

    @Bean
    fun provider(rabbitMQProducer: RabbitMQProducer): ProcessorProvider {
        return ProcessorProvider(rabbitMQProducer)
    }
}