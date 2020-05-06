# api-secia

API REST utilizando:

SPRING BOOT versão 2.2.3.RELEASE
SPRING SECURITY
SPRING DATA
SWAGGER2 versão 2.7.0
OAUTH2 2.2.6.RELEASE
POSTGRESQL
MAVEN
LOMBOK

Para executar o projeto, navegue até a raiz e digite, após ter o maven e a JDK8 instalados no computador:
mvn clean install spring-boot:repackage

Para acessar o swagger: http://localhost:8080/swagger-ui.html

Os serviços serão acessados mediante autenticação.
Banco de dados é criado automaticamente ao subir servidor.

Altere o arquivo application.properties com a configuração do seu postgres.
