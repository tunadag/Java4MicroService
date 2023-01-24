package com.tunadag.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    /**
     * Oluşturacağımız kuyruk sistemi için temel olan parametrelerin isimlendirmesini yapıyoruz.
     */

    private String exchangeAuth = "exchange-auth";
    private String keyAuth = "key-auth";
    private String queueAuth = "queue-auth-create-user";

    /**
     * Oluşturulacak kuyruk için gerekli olan 2 nesnemizin oluşması için metodları yazıyoruz.
     * 1- Exchange nesnesi -> Direct, Fanout, Topic
     * 2- Queue nesnesi -> kuyruk
     * DİKKAT!!! yazdığınız metodlardan Spring in nesne oluşturması için @Bean anotasyonu eklemelisiniz.
     * @return
     */
    @Bean
    DirectExchange exchangeAuth(){
        return new DirectExchange(exchangeAuth);
    }

    @Bean
    Queue queueCreateUser(){
        return new Queue(queueAuth);
    }

    /**
     * Oluşturduğunuz iki nesneyi(Exchange, Queue) birbirine belli bir key üzerinden
     * bağlamak için Binding nesnesi yaratıyoruz, bu işlem RabbitMQ üzerinde bir kuyruk oluşturacaktır
     * @return
     */
    @Bean
    public Binding bindingCreateUser(final Queue queueCreateUser, final DirectExchange exchangeAuth){
        return BindingBuilder.bind(queueCreateUser).to(exchangeAuth).with(keyAuth);
    }
}
