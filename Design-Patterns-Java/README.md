# Design Patterns Java

Projeto demonstrativo de implementação de padrões de projeto em Java, com foco em exemplos simples e didáticos de utilização no dia a dia.

## Objetivo

Este repositório reúne exemplos práticos dos principais padrões de projeto:

- Singleton
- Strategy
- Facade

Além disso, o projeto demonstra como subsistemas podem ser integrados de forma simples e organizada.

## Padrões implementados

### 1. Singleton

O padrão Singleton garante que uma classe tenha apenas uma instância e forneça um ponto global de acesso a ela.

Implementações existentes:

- `SingletonEager`: instancia criada na inicialização da classe
- `SingletonLazy`: instancia criada sob demanda
- `SingletonLazyHolder`: variante segura e eficiente usando holder class

### 2. Strategy

O padrão Strategy define uma família de algoritmos e permite trocar o comportamento em tempo de execução sem alterar a classe cliente.

Neste projeto:

- `Comportamento` é a interface do comportamento
- `ComportamentoNormal`, `ComportamentoDefensivo` e `ComportamentoAgressivo` implementam diferentes estratégias
- `Robo` usa a estratégia configurada para executar o movimento

### 3. Facade

O padrão Facade oferece uma interface simplificada para um conjunto de subsistemas mais complexos.

No exemplo:

- `CepApi` obtém cidade e estado a partir do CEP
- `CrmService` grava o cliente no sistema CRM
- `Facede` encapsula essa interação para que o cliente chame apenas um método simples: `migrarCliente()`

## Como executar

Pré-requisitos:

- JDK instalado
- Gradle wrapper disponível no projeto

No diretório do projeto, execute:

```bash
./gradlew build
```

Para executar a aplicação principal:

```bash
./gradlew classes
java -cp build/classes/java/main org.example.Main
```

## Exemplo de saída

Ao rodar a aplicação, é possível observar:

- múltiplas instâncias de singleton sendo tratadas corretamente
- trocas dinâmicas de comportamento do robô
- migração de cliente usando fachada para integrar CEP e CRM

## Observações

Este projeto é acadêmico e foi criado para fins de estudo e compreensão prática dos padrões de projeto em Java.
