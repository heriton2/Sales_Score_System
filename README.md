# Sales Score Systema

<!---Esses são exemplos. Veja https://shields.io para outras pessoas ou para personalizar este conjunto de escudos. Você pode querer incluir dependências, status do projeto e informações de licença aqui--->


> Sistema de vendas com cadastros e alterações, possibilita também um ranking dos vendedores.

### Ajustes e melhorias

O projeto ainda está em desenvolvimento e as próximas atualizações serão voltadas nas seguintes tarefas:

- [x] Criar dockerfile
- [x] Incluir mais funcionalidades
- [x] Realizar testes unitários com mínimo de 80% de coverage
- [x] Incluir segurança

## 💻 Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:
* Ter o Java 11 instalado.
* Ter uma máquina `<Windows / Linux / Mac>`.
* Ter o Postman instalado.
* Ter o MySql instalado.

## 🚀 Instalando Sales Score System

Para instalar o Sales Score System, siga estas etapas:

Windows, Linux ou macOs:

Realizar o clone do projeto: ```git clone https://github.com/heriton2/Sales_Score_System.git```

Importar para sua IDE de preferência como projeto Micronault ou gradle.

Importar o Mysql Dump file presente no caminho `Sales/src/main/resources/mysql`, caso necessário siga as instruções no link:
https://dev.mysql.com/doc/workbench/en/wb-admin-export-import-management.html

Confirme no appliccation.yml se os dados do banco de dados estão corretos.

Para rodar a aplicação utilize o comando: ```gradle run```

## ☕ Usando Sales Score System

Para usar Sales Score System, siga estas etapas:

No seu postman, importe a collection presente na raíz do projeto `Sales/src/main/resources/postman`

Já no Postman utilize as requisições conforme estão montadas.