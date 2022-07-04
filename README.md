# Refound
Aplicação para conversão de dados.

### Detalhes

- Aplicação criada Java 11 e Maven
- Testes unitários com JUnit

### Processo

- Ao executar, a classe Process é chamada recebendo o caminho do arquivo
- A classe Convert faz a conversão e agrupamento das informações
- A classe Output gera o arquivo e salva no diretório de usuário ex: C:\Users\Admin\

### Como executar a aplicação
Certifique-se de ter o Maven instalado e adicionado ao PATH de seu sistema operacional, assim como o Git.

- `git clone git@github.com:cleitonlsousa/refound.git`
- `cd refound`
- `mvn clean verify`
- `cd target`
- `java -jar refound.jar 'caminho_do_arquivo'`

### Importando o projeto

O projeto pode ser importado no eclipse ou Intellij como um projeto maven. Não é necessária nenhuma configuração
adicional para executar o projeto apenas download das dependências.