# Spring Cloud Stream Examples

## CloudAMQP

A `CloudAMQP` provê cluster de servidores de RabbitMQ gerenciados na nuvem, permitindo desaclopamento com infraestrutura própria. 

As credenciais utilizadas nos projetos desse repositório são do plano gratuito e serve apenas para fins de testes e desenvolvimento.

Para melhor aproveite da `CloudAMQP`, crie sua própria conta seguindo a documentação abaixo e gerencie seus clusters para projetos diversos que se deseje utilizar o RabbitMQ (em nuvem) como broker de mensageria.

Documentação: https://www.cloudamqp.com/docs/index.html

## Producer Service

Inicializando o serviço: `mvn spring-boot:run`

Para enviar dados de testes, pode-se utilizar um cliente chamado `Postman` ou executar diretamente o comando `curl` abaixo:
```shell

``` 

## Consumer Service

Antes de inicializar o serviço consumidor, necessário ser o passo `Percona MongoDB`.

Inicializando o serviço: `mvn spring-boot:run` 

#### Percona MongoDB

Acessar a pasta do projeto `consumer`, depois acessar a pasta `docker` e executar o comando abaixo:
```shell
docker-compose -f percona-mongodb.yml up -d
``` 

Para realizar o shutdown do banco de dados, executar:
```shell
docker-compose -f percona-mongodb.yml down
```

Para acessar os dados direto via cliente de interface com banco de dados, pode-se utilizar, nesse caso, o cliente https://www.mongodb.com/products/compass.

String de conexão (de acordo com dados presente no docker compose yml): `mongodb://consumer.user:consumer.pass@localhost:27017/signaldb?authSource=signaldb`

Para consultar informações de sinais recebidos via consume de mensagem, processada e armazenada em banco de dados, pode-se utilizar um cliente chamado `Postman` ou executar diretamente o comando `curl` abaixo:
```shell

``` 