# Sistema de Loja com Produtos Variados

Projeto desenvolvido usando a linguagem Java para praticar e demonstrar conceitos de **Programação Orientada a Objetos**.

Sistema que permite cadastrar, listar e aplicar descontos em diferentes tipos de produtos (Notebook, Bicicleta, Console, Livro e Televisor).

## Funcionalidades

- Cadastro de 5 tipos diferentes de produtos
- Listagem completa dos produtos cadastrados
- Aplicação de desconto à vista com percentuais distintos por categoria
- Visualização de descrições detalhadas
- Validações de dados de entrada (quantidade, preço, campos obrigatórios etc.)

## Tecnologias e Conceitos Aplicados

- **Java** (versão 11+)
- **Programação Orientada a Objetos**:
  - Herança (`Produto` como classe abstrata)
  - Polimorfismo
  - Interface (`Desconto`)
  - Enum (`StatusProduto`)
- `BigDecimal` para tratamento correto de valores monetários
- `ArrayList` para armazenamento dos produtos
- Tratamento de exceções e validações de entrada do usuário
- Separação de responsabilidades (classe `Service` + `Main`)

## Como executar

1. Clone o repositório
2. Abra o projeto no IntelliJ IDEA
3. Execute a classe `Main`


