# Loja_Online
Padrão Singleton


🛒 Sistema de Lojinha Online (Simulação)
📌 Contexto

Este projeto foi desenvolvido a partir de um Diagrama N0 apresentado em aula, que descreve o funcionamento de uma lojinha online baseada em uma arquitetura cliente-servidor monolítica.

Nesse modelo, todas as responsabilidades do backend estão centralizadas em uma única aplicação, que se comunica com clientes e também com um sistema externo de pagamento.

O objetivo deste projeto é evoluir essa modelagem inicial e implementar uma simulação funcional do sistema.

🎯 Objetivo

Desenvolver os seguintes artefatos:

📊 Diagrama de Atividades (UML)
🧩 Diagrama Entidade-Relacionamento (DER)
💻 Implementação em Java (simulação do sistema)
📊 Diagrama de Atividades

O diagrama representa o fluxo principal do sistema, incluindo:

Navegação do cliente
Seleção de produtos
Criação de pedido
Processamento de pagamento
Comunicação com sistema externo
Confirmação ou falha da compra

📎 Arquivo disponível na pasta /docs

🧩 Diagrama Entidade-Relacionamento (DER)

O DER modela a estrutura de dados da aplicação, contendo entidades como:

Cliente
Produto
Pedido
Item do Pedido
Pagamento

Inclui:

Chaves primárias (PK)
Chaves estrangeiras (FK)
Relacionamentos e cardinalidades

📎 Arquivo disponível na pasta /docs

💻 Implementação em Java

A aplicação foi desenvolvida utilizando:

Linguagem: Java
Paradigma: Orientação a Objetos
Arquitetura: Cliente-servidor monolítica
Interface: Sem interface gráfica (simulação via código/API)
🔧 Funcionalidades simuladas
Identificação de cliente (dados estáticos)
Listagem de produtos
Criação de pedidos
Processamento de pagamento
🧱 Estrutura do Projeto
src/
├── model/        # Entidades (Cliente, Produto, Pedido, etc.)
├── service/      # Regras de negócio
├── repository/   # Simulação de persistência de dados
├── controller/   # Camada de controle (simulação de API)
└── main/         # Classe principal para execução
🧠 Decisões Arquiteturais
Uso de separação em camadas para organização do código
Simulação de persistência com dados em memória
Centralização da lógica de negócio na camada service
Arquitetura monolítica conforme proposto no enunciado
🔒 Padrão Singleton

A comunicação com o sistema externo de pagamento foi implementada utilizando o padrão de projeto Singleton.

📍 Onde foi aplicado

Classe responsável pela integração com o sistema de pagamento:

PaymentGateway
💡 Justificativa

O uso do Singleton garante que:

Apenas uma instância da conexão com o sistema de pagamento exista
Evita múltiplas conexões desnecessárias
Mantém consistência na comunicação com o serviço externo
Reduz consumo de recursos
