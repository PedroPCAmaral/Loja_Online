# Loja_Online

Padrão Singleton

🛒 Loja Online – Simulação em Java

📌 Descrição do Projeto

Este projeto consiste na implementação de uma simulação de uma loja online, desenvolvida em Java utilizando os princípios de Programação Orientada a Objetos (POO).

O sistema segue uma arquitetura cliente-servidor monolítica, conforme proposto em sala de aula, onde todas as responsabilidades do backend estão concentradas em uma única aplicação.

🏗️ Arquitetura do Sistema

A aplicação foi estruturada em camadas organizadas por pacotes:

com.lojinha
├── main      → Ponto de entrada do sistema
├── model     → Entidades (dados do sistema)
└── service   → Regras de negócio

📌 Características:
Arquitetura monolítica
Separação de responsabilidades
Código modular e organizado
Fácil manutenção e expansão
⚙️ Funcionalidades Implementadas

✔ Identificação de cliente (dados fixos)
✔ Listagem de produtos
✔ Criação de pedido
✔ Adição de itens ao pedido
✔ Cálculo do valor total
✔ Processamento de pagamento
✔ Retorno de sucesso ou falha

🔄 Fluxo do Sistema
Cliente acessa o sistema
Navega pelos produtos
Seleciona produtos
Adiciona ao carrinho
Finaliza a compra
Sistema envia pagamento
Sistema externo processa
Retorna:
✅ Pagamento aprovado → Pedido confirmado
❌ Pagamento recusado → Erro exibido
🧠 Padrão de Projeto Utilizado
🔹 Singleton

O padrão Singleton foi aplicado na classe PagamentoService.

✔ Objetivo:

Garantir que exista apenas uma única instância responsável pela comunicação com o sistema de pagamento durante toda a execução da aplicação.

✔ Vantagens:
Evita múltiplas conexões desnecessárias
Garante consistência no processamento
Reduz uso de recursos
Centraliza a lógica de pagamento

🧩 Modelagem do Sistema

📊 Diagrama de Atividades

Representa o fluxo completo da aplicação, incluindo:

Navegação do cliente
Seleção de produtos
Processo de compra
Comunicação com pagamento
Decisão de aprovação
🗄️ Diagrama Entidade-Relacionamento (DER)

Entidades modeladas:

Cliente
Produto
Pedido
ItemPedido
Pagamento

📌 Relacionamentos:
Cliente (1) Pedido
Pedido (1) ItemPedido
Produto (1) ItemPedido
Pedido (1:1) Pagamento
📁 Estrutura do Projeto
lojinha-online/
├── src/
│   └── com/
│       └── lojinha/
│           ├── main/
│           ├── model/
│           └── service/
├── diagramas/
│   ├── diagrama_atividades.png
│   └── der.png
└── README.md

🚀 Como Executar o Projeto

📌 Pré-requisitos
Java JDK instalado
Terminal (PowerShell ou CMD)
Visual Studio Code (opcional)

▶️ Passo a passo
Acesse a pasta src:
cd src
Compile o projeto:
javac -d .. (Get-ChildItem -Recurse -Filter *.java).FullName
Volte uma pasta:
cd ..
Execute o sistema:
java com.lojinha.main.Main

📌 Saída Esperada
Processando pagamento de R$ 2050.0
Pagamento aprovado! Pedido confirmado.

🎯 Conclusão

O projeto demonstra de forma prática:

Aplicação de conceitos de POO
Organização em camadas
Uso de padrão de projeto (Singleton)
Modelagem com UML e DER
Simulação de sistema real


👨‍💻 Autor

Pedro Paulo Costa do Amaral
Luiz Felipe Ferraz de Carvalho

📎 Observações


Este projeto foi desenvolvido para fins acadêmicos, com foco na compreensão de arquitetura de software, modelagem e boas práticas de desenvolvimento.
