# ms-transactions-channels-capture-gateway

## Quickstart
No arquivo [pom.xml](pom.xml) altere a versão do parent (picpay-parent) para a desejada, conforme https://github.com/PicPay/picpay-starter-modules/tags

## Squad
squad_mundo_fisico_gateway

## Descrição
Capture transactions from network adapters

## Jira
https://picpay.atlassian.net/jira/software/c/projects/MFG/boards/6620

## Documentação
https://picpay.atlassian.net/wiki/spaces/MFG/overview

## Criando a API
Este projeto segue a especificação [Open API 3](https://swagger.io/specification/) e utiliza o padrão contract-first. 
Para gerar a camada de controller basta editar o arquivo `/src/main/resources/openapi/api.yaml`, utilizar o comando `mvn compile` e implementar a interface que foi gerada:

Confira o [Guia de Estilo de API](https://picpay.atlassian.net/wiki/spaces/CHPJ/pages/2545516904/Guia+de+estilo+de+APIs) 

```kotlin
@RestController
class HelloController(
    private val helloService: HelloService
): HelloApi {

    override fun hello(): ResponseEntity<HelloDTO> {
        val hello = helloService.hello()
        return ResponseEntity.ok(hello)
    }

}
```

## Arquitetura Hexagonal
Este template segue a Arquitetura Hexagonal e existem diversos [Adapters](https://picpay.atlassian.net/wiki/spaces/CHPJ/pages/2545516752/Estrutura+de+Projeto#Adapters) disponíveis para utilização.

![Image Caption](.readme/arquitetura_hexagonal.png)

Estrutura de packages:

![Image Caption](.readme/packages.png)

Em caso de dúvidas, consultar a [documentação](https://picpay.atlassian.net/wiki/spaces/CHPJ/pages/2545516752/Estrutura+de+Projeto)

## Checklist Microservice Chassis

| Funcionalidade                                                                                                                                             | [Requirement Level](https://datatracker.ietf.org/doc/html/rfc2119) | Status                     | Observações                                                                                                           |
| ---------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------ | -------------------------- | --------------------------------------------------------------------------------------------------------------------- |
| [Autenticação](https://github.com/PicPay/RFC/blob/main/RFCs/RFC-014%3A%20Microservice%20Chassis.md#autentica%C3%A7%C3%A3o)                                 | MUST                                                               | :eight_pointed_black_star: |                                                                                                                       |
| [Autorização](https://github.com/PicPay/RFC/blob/main/RFCs/RFC-014%3A%20Microservice%20Chassis.md#autorização)                                             | MUST                                                               | :eight_pointed_black_star: |                                                                                                                       |
| [Circuit Breaker](https://github.com/PicPay/RFC/blob/main/RFCs/RFC-014%3A%20Microservice%20Chassis.md#circuit-breaker)                                     | MAY                                                                | :eight_pointed_black_star: |                                                                                                                       |
| [Comunicação via HTTP](https://github.com/PicPay/RFC/blob/main/RFCs/RFC-014%3A%20Microservice%20Chassis.md#comunicação-via-http)                           | SHOULD                                                             | :white_check_mark:         | Seguir o [Padrão Rest](https://github.com/PicPay/RFC/blob/main/RFCs/RFC-024%3A%20Padr%C3%A3o%20de%20APIs%20Rest.md)   |
| [Retries/Timeouts/Backoffs](https://github.com/PicPay/RFC/blob/main/RFCs/RFC-014%3A%20Microservice%20Chassis.md#retriestimeoutsbackoffs)                   | MAY                                                                |                            |                                                                                                                       |
| [Comunicação via gRPC](https://github.com/PicPay/RFC/blob/main/RFCs/RFC-014%3A%20Microservice%20Chassis.md#comunicação-via-grpc)                           | MAY                                                                |                            |                                                                                                                       |
| [Idempotência](https://github.com/PicPay/RFC/blob/main/RFCs/RFC-014%3A%20Microservice%20Chassis.md#idempotencia)                                           | SHOULD                                                             |                            |                                                                                                                       |
| [Log centralizado](https://github.com/PicPay/RFC/blob/main/RFCs/RFC-014%3A%20Microservice%20Chassis.md#log-centralizado)                                   | MUST                                                               | :white_check_mark:         |                                                                                                                       |
| [Métricas](https://github.com/PicPay/RFC/blob/main/RFCs/RFC-014%3A%20Microservice%20Chassis.md#métricas)                                                   | MUST                                                               | :eight_pointed_black_star: |                                                                                                                       |
| [Distributed tracing](https://github.com/PicPay/RFC/blob/main/RFCs/RFC-014%3A%20Microservice%20Chassis.md#distributed-tracing)                             | MUST                                                               | :eight_pointed_black_star: |                                                                                                                       |
| [Rate Limit](https://github.com/PicPay/RFC/blob/main/RFCs/RFC-014%3A%20Microservice%20Chassis.md#rate-limit)                                               | SHOULD                                                             | :eight_pointed_black_star: |                                                                                                                       |
| [Graceful Shutdown](https://github.com/PicPay/RFC/blob/main/RFCs/RFC-014%3A%20Microservice%20Chassis.md#graceful-shutdown)                                 | MUST                                                               | :white_check_mark:         |                                                                                                                       |
| [Service Discovery](https://github.com/PicPay/RFC/blob/main/RFCs/RFC-014%3A%20Microservice%20Chassis.md#service-discovery)                                 | MAY                                                                |                            |                                                                                                                       |
| [Comunicação via Kafka](https://github.com/PicPay/RFC/blob/main/RFCs/RFC-014%3A%20Microservice%20Chassis.md#comunicação-via-kafka)                         | MAY                                                                |                            |                                                                                                                       |
| [Documentação](https://github.com/PicPay/RFC/blob/main/RFCs/RFC-014%3A%20Microservice%20Chassis.md#documentação)                                           | MUST                                                               | :white_check_mark:         | Documentar a API usando [Swagger](https://picpay.atlassian.net/wiki/spaces/MOON/pages/2589098504/Configurar+API+Docs) |
| [Deploy automatizado](https://github.com/PicPay/RFC/blob/main/RFCs/RFC-014%3A%20Microservice%20Chassis.md#deploy-automatizado)                             | MUST                                                               | :white_check_mark:         |                                                                                                                       |
| [Ambiente local de desenvolvimento](https://github.com/PicPay/RFC/blob/main/RFCs/RFC-014%3A%20Microservice%20Chassis.md#ambiente-local-de-desenvolvimento) | SHOULD                                                             | :eight_pointed_black_star: |                                                                                                                       |
| [Testes](https://github.com/PicPay/RFC/blob/main/RFCs/RFC-014%3A%20Microservice%20Chassis.md#testes)                                                       | MUST                                                               | :eight_pointed_black_star: |                                                                                                                       |
| [Conexão com banco de dados](https://github.com/PicPay/RFC/blob/main/RFCs/RFC-014%3A%20Microservice%20Chassis.md#conexão-com-banco-de-dados)               | MAY                                                                |                            |                                                                                                                       |
| [Variáveis de ambiente](https://github.com/PicPay/RFC/blob/main/RFCs/RFC-014%3A%20Microservice%20Chassis.md#variáveis-de-ambiente)                         | MUST                                                               | :eight_pointed_black_star: |                                                                                                                       |
| [Secrets](https://github.com/PicPay/RFC/blob/main/RFCs/RFC-014%3A%20Microservice%20Chassis.md#secrets)                                                     | MAY                                                                | :eight_pointed_black_star: |                                                                                                                       |
| [Health check](https://github.com/PicPay/RFC/blob/main/RFCs/RFC-014%3A%20Microservice%20Chassis.md#health-check)                                           | MUST                                                               | :white_check_mark:         |                                                                                                                       |
| [Feature Flags](https://github.com/PicPay/RFC/blob/main/RFCs/RFC-014%3A%20Microservice%20Chassis.md#feature-flags)                                         | MAY                                                                |                            |                                                                                                                       |

**Legenda**

- :white_check_mark: - Requisito cumprido
- :no_entry: - Não usado pelo projeto
- :eight_pointed_black_star: - Implementação recomendada

## Notas 

Alterar no arquivo .checkmarx/cx.config o texto para o nome da BU disponivel: OpenBanking, PJ, SuperApp, Plataforma, ADS, CoreAI, Social, Store, PF, FinancialServices, Esmeralda, TechCross, ElSalvador

### Sonar Config
Alterar no arquivo `.sonarcloud.properties` as classes que devem incluídas ou excluídas das analises de Quality Gate.

Em caso de dúvidas, acesse a [FAQ](https://picpay.atlassian.net/wiki/spaces/DUP/pages/2528051668/SonarCloud) ou entre em contato no slack #suporte-sonar
