# api-secia

API REST utilizando:<br/>

SPRING BOOT versão 2.2.3.RELEASE<br/>
SPRING SECURITY<br/>
SPRING DATA<br/>
SWAGGER2 versão 2.7.0<br/>
OAUTH2 2.2.6.RELEASE<br/>
POSTGRESQL<br/>
MAVEN<br/>
LOMBOK<br/><br/>

Para executar o projeto, navegue até a raiz e digite, após ter o maven e a JDK8 instalados no computador:<br/>
mvn clean install spring-boot:repackage<br/>

Para acessar o swagger: http://localhost:8080/swagger-ui.html<br/>

Os serviços serão acessados mediante autenticação.<br/>
Banco de dados é criado automaticamente ao subir servidor.<br/>

Altere o arquivo application.properties com a configuração do seu postgres.
