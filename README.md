# Loja_Online
Padrão Singleton

🛒 Lojinha Online
📌 Descrição do Projeto

Este projeto consiste na simulação de uma lojinha online, desenvolvida em Java, com base nos conceitos de Engenharia de Software, UML e Modelagem de Dados.

O sistema simula o fluxo completo de uma compra online, desde a navegação do cliente até o processamento do pagamento.

🎯 Objetivos
Aplicar conceitos de Programação Orientada a Objetos (POO)
Modelar o sistema utilizando UML (Diagrama de Atividades)
Criar um Diagrama Entidade-Relacionamento (DER)
Implementar um sistema seguindo o padrão cliente-servidor monolítico
Utilizar o padrão de projeto Singleton
🧩 Funcionalidades
Identificação de cliente (dados fixos)
Listagem de produtos
Criação de pedidos
Adição de itens ao pedido
Cálculo do valor total
Processamento de pagamento
Retorno de pagamento aprovado ou recusado
🏗️ Arquitetura do Projeto

O sistema segue uma arquitetura monolítica, organizada em pacotes:

com.lojinha
 ├── model        → Entidades do sistema
 ├── service      → Regras de negócio
 └── main         → Classe principal (execução)
📊 Modelagem
🔹 Diagrama de Atividades

Representa o fluxo da aplicação:

Navegação do cliente
Seleção de produtos
Finalização do pedido
Integração com sistema de pagamento
Aprovação ou falha

📌 Arquivo disponível em: docs/diagrama-atividades.png

🔹 Diagrama Entidade-Relacionamento (DER)

Entidades modeladas:

Cliente
Produto
Pedido
Item do Pedido
Pagamento

Relacionamentos:

Cliente 1:N Pedido
Pedido 1:N ItemPedido
Produto 1:N ItemPedido
Pedido 1:1 Pagamento

📌 Arquivo disponível em: docs/der.png

💻 Tecnologias Utilizadas
Java
Paradigma Orientado a Objetos
UML
Modelagem de Dados
🔐 Padrão de Projeto Utilizado
Singleton – PagamentoService

O padrão Singleton foi aplicado na classe PagamentoService.

✔ Justificativa:

Foi utilizado para garantir que exista apenas uma instância do serviço de pagamento durante toda a execução do sistema, evitando múltiplas conexões com o sistema externo e garantindo consistência no processamento.

▶️ Como Executar o Projeto
1. Compilar

No terminal, dentro da pasta src:

javac com/lojinha/main/Main.java
2. Executar
java com.lojinha.main.Main
📁 Estrutura de Arquivos
lojinha-online/
 ├── src/
 │   └── com/lojinha/
 │       ├── model/
 │       ├── service/
 │       └── main/
 ├── docs/
 └── README.md

🚀 Melhorias Futuras
Implementar banco de dados real
Criar API REST
Adicionar interface gráfica
Implementar autenticação de usuários
Melhorar validações de pagamento


👨‍💻 Autor
Pedro Amaral

Projeto desenvolvido para fins acadêmicos.
