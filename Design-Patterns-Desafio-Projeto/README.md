# Design Patterns - Desafio Projeto

Projeto demonstrativo de padrões de projeto em Java: Abstract Factory, Bridge e Chain of Responsibility.

## Padrões implementados

- Abstract Factory
  - Cria diferentes tipos de botões (AttackButton, JumpButton) via fábricas (AttackButtonFactory, JumpButtonFactory).
  - Classe de exemplo: org.example.AbstractFactory.app.Application

- Bridge (Ponte)
  - Separa a abstração de Notificação da implementação do canal (Email, SMS).
  - Abstrações: org.example.Bridge.Notificacoes.*
  - Implementações: org.example.Bridge.Canais.*

- Chain of Responsibility (Cadeia de Responsabilidade)
  - Pipeline de validação, autenticação e verificação de permissões.
  - Handlers: FieldValidationHandler -> AuthenticationHandler -> RoleCheckHandler

## Estrutura principal

src/main/java/org/example/
- Main.java (exemplo de uso dos padrões)
- AbstractFactory/
  - app/Application.java
  - factories/*
  - buttons/*
- Bridge/
  - Canais/*
  - Notificacoes/*
- ChainOfResponsability/
  - Handlers/*

## Como executar

Opções recomendadas:

1) Usar uma IDE (IntelliJ IDEA, Eclipse)
- Abra o diretório do projeto como projeto Java e execute a classe `org.example.Main`.

2) Usando PowerShell (compilar e executar manualmente)
- Abra o PowerShell na raiz do projeto e execute:

  $files = Get-ChildItem -Path .\src\main\java -Recurse -Filter *.java | ForEach-Object { $_.FullName }
  javac -d out $files
  java -cp out org.example.Main

Observação: caso prefira, crie um build system (Maven/Gradle) e importe o projeto na IDE.

## Saída de exemplo

Ao executar sem argumentos, a saída esperada (exemplos) é:

You have created AttackButton
You have created JumpButton

--- Bridge (Notificações) ---
[SMS] Enviando mensagem para +5511999999999: [ALERTA CRITICO] SERVIDOR CAIU!
[EMAIL] Enviando mensagem para admin@empresa.com: [ALERTA CRITICO] SERVIDOR CAIU!
[EMAIL] Enviando mensagem para cliente@gmail.com: Oferta especial: 50% de desconto no plano Pro.

--- Chain of Responsibility (tentativas) ---
--- Tentativa 1: Senha inválida ---
[ERRO] Senha muito curta.

--- Tentativa 2: Sem privilégio de admin ---
[OK] Campos validos
[OK] Usuario autenticado.
[ERRO] Acesso negado: Requer privilegios de Administrador.

--- Tentativa 3: Sucesso ---
[OK] Campos validos
[OK] Usuario autenticado.
[OK] Acesso de Administrador concedido.
Resultado do Acesso: AUTORIZADO

## Observações
- O projeto é intencionalmente simples para demonstrar os padrões; envie melhorias (ex.: integração com bibliotecas de envio de email/SMS, uso de frameworks de build) se desejar.

