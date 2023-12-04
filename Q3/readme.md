**Sistema de Controle de Estoque de Eletrodomésticos**

### Requisitos do Sistema:

1. **Cadastro de Produtos:**
   - Nome do produto
   - Categoria (geladeira, fogão, máquina de lavar, etc.)
   - Marca
   - Fornecedor
   - Preço de compra
   - Preço de venda
   - Quantidade em estoque

2. **Controle de Estoque:**
   - Atualização automática do estoque após cada venda/compra
   - Registros de todas as transações (entrada/saída)
   - Alertas de estoque baixo

3. **Vendas:**
   - Registro de vendas
   - Atualização automática do estoque após a venda
   - Geração de nota fiscal

4. **Compras:**
   - Registro de compras
   - Atualização automática do estoque após a compra
   - Geração de pedido de compra

5. **Relatórios:**
   - Estoque atualizado
   - Histórico de transações
   - Produtos mais vendidos
   - Produtos com estoque baixo

### Tecnologias Recomendadas:

- **Linguagem de Programação:** Python, Java, C#
- **Banco de Dados:** MySQL, PostgreSQL, SQLite
- **Interface Gráfica:** Tkinter (Python), JavaFX (Java), Windows Forms (C#)
- **Desenvolvimento Web (opcional):** Flask ou Django (Python), Spring (Java), ASP.NET (C#)

### Estrutura Básica do Banco de Dados:

1. **Tabela `Produtos`:**
   - `ID` (Chave Primária)
   - `Nome`
   - `Categoria`
   - `Marca`
   - `Fornecedor`
   - `PrecoCompra`
   - `PrecoVenda`
   - `QuantidadeEstoque`

2. **Tabela `Transacoes`:**
   - `ID` (Chave Primária)
   - `Tipo` (Entrada ou Saída)
   - `IDProduto` (Chave Estrangeira referenciando a tabela `Produtos`)
   - `Quantidade`
   - `Data`
   
3. **Tabela `Vendas`:**
   - `ID` (Chave Primária)
   - `IDProduto` (Chave Estrangeira referenciando a tabela `Produtos`)
   - `Quantidade`
   - `ValorTotal`
   - `Data`

4. **Tabela `Compras`:**
   - `ID` (Chave Primária)
   - `IDProduto` (Chave Estrangeira referenciando a tabela `Produtos`)
   - `Quantidade`
   - `ValorTotal`
   - `Data`

### Funcionalidades do Sistema:

1. **Cadastro de Produto:**
   - Adicionar novos produtos ao estoque.

2. **Registro de Venda:**
   - Registrar vendas, atualizando automaticamente o estoque.

3. **Registro de Compra:**
   - Registrar compras, atualizando automaticamente o estoque.

4. **Consulta de Estoque:**
   - Verificar o estoque atualizado.

5. **Geração de Relatórios:**
   - Gerar relatórios sobre o estoque, vendas, compras, etc.

6. **Alertas de Estoque Baixo:**
   - Receber alertas quando o estoque de um produto estiver baixo.

7. **Interface Gráfica:**
   - Criar uma interface amigável para facilitar a interação.

### Observações Finais:
