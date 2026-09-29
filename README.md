# Gestão Financeira API

API REST para gerenciamento de pessoas e mensalidades.

## Tecnologias

- Java 21
- Spring Boot 4.1.1
- Spring Web MVC
- Spring Data JPA
- PostgreSQL
- MySQL Connector/J
- Lombok
- Dozer
- Jakarta Bean Validation
- SpringDoc OpenAPI
- Maven
- Docker

## Principais recursos

- Gerenciamento de pessoas
- Gerenciamento de mensalidades
- Controle de pagamentos
- Dashboard financeiro
- Histórico de pagamentos
- Busca por nome
- Filtro por status de pagamento
- Documentação da API com Swagger/OpenAPI

## Estrutura da API

### Pessoas

- `GET /person/id/{id}`
- `GET /person/all`
- `POST /person/create`
- `PUT /person/update/id/{id}`
- `DELETE /person/{id}`

### Pagamentos

- `POST /payment/generate`
- `GET /payment/current-month`
- `GET /payment/dashboard`
- `GET /payment/status/{paid}`
- `GET /payment/search?name={name}`
- `PATCH /payment/{id}/pay`
- `PATCH /payment/{id}/unpay`
- `GET /payment/history?year={year}`
- `GET /payment/month/{year}/{month}`

## Banco de dados

PostgreSQL executado através do Docker.

O projeto utiliza um volume Docker para manter os dados do banco persistentes. :contentReference[oaicite:2]{index=2}

## Documentação

A API possui documentação através do SpringDoc OpenAPI / Swagger UI.

## Execução

```bash
docker compose up
./mvnw spring-boot:run
