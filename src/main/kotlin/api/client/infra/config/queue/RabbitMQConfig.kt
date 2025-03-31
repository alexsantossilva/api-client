package api.client.infra.config.queue

import com.rabbitmq.client.ConnectionFactory
import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.DirectExchange
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory
@Configuration
class RabbitMQConfig(
    @Value("\${rabbitmq.host}") private val host: String,
    @Value("\${rabbitmq.port}") private val port: Int,
    @Value("\${rabbitmq.username}") private val username: String,
    @Value("\${rabbitmq.password}") private val password: String,

    @Value("\${rabbitmq.config.queue}") private val queue: String,
    @Value("\${rabbitmq.config.exchange}") private val exchange: String,
    @Value("\${rabbitmq.config.routing-key}") private val routingKey: String,
) {

    @Bean
    fun connectionFactory(): ConnectionFactory {
        val factory = ConnectionFactory()
        factory.host = host
        factory.port = port
        factory.username = username
        factory.password = password
        return factory
    }
    @Bean
    fun rabbitTemplate(connectionFactory: CachingConnectionFactory): RabbitTemplate {
        return RabbitTemplate(connectionFactory)
    }

    @Bean
    fun queue(): Queue {
        return Queue(queue, true)
    }

    @Bean
    fun exchange(): DirectExchange {
        return DirectExchange(exchange)
    }

    @Bean
    fun binding(queue: Queue, exchange: DirectExchange): Binding {
        return BindingBuilder.bind(queue).to(exchange).with(routingKey)
    }

    fun getExchange(): String = exchange
    fun getRoutingKey(): String = routingKey
}
