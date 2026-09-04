# Design-Patterns-Spring

Projeto exemplo em Spring Boot que demonstra padrão de organização em camadas (Model / Service / Controller), integração com API externa via Feign (ViaCEP) e persistência com Spring Data JPA (H2).

## Tecnologias

- Java 21
- Spring Boot 4.1.1
- Spring Data JPA
- Spring Cloud OpenFeign
- H2 (em memória)
- springdoc-openapi (Swagger UI)

## Visão geral do código

Estrutura principal (pacote org.example.designpatternsspring):

- Model
  - Cliente.java — entidade JPA (id, nome, Endereco). Relação ManyToOne com Endereco.
  - Endereco.java — entidade JPA com `cep` como id e campos que refletem a resposta do ViaCEP.
  - ClienteRepository — CrudRepository<Cliente, Long>.
  - EnderecoRepository — CrudRepository<Endereco, String>.

- service
  - ClienteService — interface com operações CRUD: buscarTodos, buscarPorId, inserir, atualizar, deletar.
  - ViaCepService — Feign client para `https://viacep.com.br/ws/{cep}/json/` (método consultarCep).
  - impl/ClienteServiceImpl — implementação que encapsula a lógica de persistir cliente:
    - Ao inserir/atualizar, obtém o cep do cliente e tenta buscar Endereco no banco.
    - Se não existir, consulta ViaCepService, salva o Endereco e associa ao Cliente.
    - Persiste o Cliente com o Endereco associado.

- Controller
  - ClientRestController — exposição REST das operações de Cliente:
    - GET /clientes — lista todos
    - GET /clientes/{id} — busca por id
    - POST /clientes — cria cliente
    - PUT /clientes/{id} — atualiza cliente
    - DELETE /clientes/{id} — remove cliente

- DesignPatternsSpringApplication.java — classe main com @SpringBootApplication e @EnableFeignClients.

## Execução

Pré-requisitos: JDK 21 e Maven.

No diretório do projeto:

mvn spring-boot:run

Após subir, por padrão o app usa H2 em memória. UI do Swagger/OpenAPI (springdoc) geralmente disponível em:

http://localhost:8080/swagger-ui.html
ou
http://localhost:8080/swagger-ui/index.html

H2 console (se habilitado nas propriedades) costuma ficar em:

http://localhost:8080/h2-console

## Exemplo de requisição

POST /clientes
Content-Type: application/json

{
  "nome": "João Silva",
  "endereco": { "cep": "01001000" }
}

Resposta: objeto Cliente com Endereco preenchido (buscado do ViaCEP se necessário).

## Observações e melhorias sugeridas

- Tratamento de erros: hoje o método buscarPorId usa Optional.get() sem checagem, o que pode lançar NoSuchElementException. Recomenda-se lançar ResourceNotFoundException ou retornar 404.
- Validação (Bean Validation) para entrada (por exemplo, formato de CEP, nome obrigatório).
- DTOs para separar entidades JPA da API pública e evitar problemas de serialização/ciclo.
- Testes unitários e de integração para service e controller.
- Cache mais robusto para Endereco (ex.: Spring Cache) se for usado em produção.


