package api.client.infra.queue

import api.client.infra.config.queue.RabbitMQConfig
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Service

@Service
class RabbitMQProducer(
        private val rabbitTemplate: RabbitTemplate,
        private val rabbitMQConfig: RabbitMQConfig): Queue {

    override fun sendMessage(message: String) {
        println("Enviando mensagem: $message")
        rabbitTemplate.convertAndSend(
                rabbitMQConfig.getExchange(),
                rabbitMQConfig.getRoutingKey(),
                message
        )
    }
}