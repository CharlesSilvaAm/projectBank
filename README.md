Desafio-api

Pré-requisitos

Ferramentas/Tecnologias:


Java JDK - Como tecnologia (linguagem de programação)
TestNG - Como TestRunner
Maven - Como gerenciador de dependências
IntelliJ IDEA - Como sugestão de IDE


Arquitetura do projeto

├── .github
│       ├── workflows
│               ├── github-ci.yml
├── src
│   ├── main
│   │   ├── java
│   │   │   ├──com.vemser.hackaton.dbcbank.rest
│   │   │   │   ├── client
│   │   │   │   │   └── AlternarSenhaClient.class
│   │   │   │   │   └── BaseClient.class
│   │   │   │   │   └── CadastroClient.class
│   │   │   │   │   └── ChavePixClient.class
│   │   │   │   │   └── HealthCheckClient.class
│   │   │   │   │   └── LimiteTransacaoClient.class
│   │   │   │   │   └── LoginClient.class
│   │   │   │   │   └── TransferenciaClient.class
│   │   │   │   │   └── UsuarioClient.class
│   │   │   │   │   
│   │   │   │   ├── data
│   │   │   │   │   │   └── factory
│   │   │   │   │   │   │   ├── AlterarSenhaDataFactory.class
│   │   │   │   │   │   │   ├── CadastroDataFactory.class
│   │   │   │   │   │   │   ├── ChavePixDataFactory.class
│   │   │   │   │   │   │   ├── ConversorDeSenhaDataFactory.class
│   │   │   │   │   │   │   ├── DadosDeUsuarioDataFactory.class
│   │   │   │   │   │   │   ├── EnderecoDataFactory.class
│   │   │   │   │   │   │   ├── LimiteTransacaoDataFactory.class
│   │   │   │   │   │   │   ├── LoginDataFactory.class
│   │   │   │   │   │   │   ├── TransactionMethodSelector.class
│   │   │   │   │   │   │   ├── TransferenciaDataFactory.class
│   │   │   │   │   │   │   ├── UsuarioDadosPessoaisDataFactory.class
│   │   │   │   │   │   │   ├── UsuarioDadosSociaisDataFactory.class
│   │   │   │   │   │   │   ├── UsuarioDataFactory.class
│   │   │   │   │   │   │   
│   │   │   │   │   │   └── provider
│   │   │   │   │   │   │   ├── AlterarSenhaProvider.class
│   │   │   │   │   │   │   ├── CadastroProvider.class
│   │   │   │   │   │   │   ├── ChavePixProvider.class
│   │   │   │   │   │   │   ├── LimiteTransacaoProvider.class
│   │   │   │   │   │   │   ├── LoginProvider.class
│   │   │   │   │   │   │   ├── TransferenciaProvider.class
│   │   │   │   │   │   │   ├── UsuarioDadosPessoaisProvider.class
│   │   │   │   │   │   │   ├── UsuarioDadosSociaisProvider.class
│   │   │   │   │   │   │
│   │   │   │   ├── model
│   │   │   │   │   │   └── enums
│   │   │   │   │   │   │   ├── EditarProvider.Class
│   │   │   │   │   │   │   │
│   │   │   │   │   │   ├── AlterarLimiteTransacaoRequest.class
│   │   │   │   │   │   ├── AlterarSenhaRequest.class
│   │   │   │   │   │   ├── CadastroRequest.class
│   │   │   │   │   │   ├── CartaoModel.class
│   │   │   │   │   │   ├── ChavePixRequest.class
│   │   │   │   │   │   ├── ContaBancoModel.class
│   │   │   │   │   │   ├── DadosDeUsuarioModel.class
│   │   │   │   │   │   ├── DepositoModel.class
│   │   │   │   │   │   ├── EnderecoModel.class
│   │   │   │   │   │   ├── LoginRequest.class
│   │   │   │   │   │   ├── LoginResponse.class
│   │   │   │   │   │   ├── SaqueRequest.class
│   │   │   │   │   │   ├── SenhaCartaoModel.class
│   │   │   │   │   │   ├── TransferRequest.class
│   │   │   │   │   │   ├── TransferTEDRequestModel.class
│   │   │   │   │   │   ├── UserModel.class
│   │   │   │   │   │   ├── UsuarioDadosPessoaisRequest.class
│   │   │   │   │   │   ├── UsuarioDadosSociaisRequest.class
│   │   │   │   │   │   ├── UsuarioResponse.class
│   │   │   │   │   │   
│   │   │   │   ├── utils
│   │   │   │   │   ├── AlterarSenhaConstants.class
│   │   │   │   │   ├── CadastroConstanstes.class
│   │   │   │   │   ├── Credenciais.class
│   │   │   │   │   ├── DataFakerGeneration.class
│   │   │   │   │   ├── LoginConstants.class
│   │   │   │   │   ├── UsurioConstants.class
│   │   │
│   │   ├── resources
│   │   │       ├── dados-teste.properties
│   ├── test
│   │   ├── java
│   │   │   ├── com.vemser.hackaton.dbcbank.rest.tests
│   │   │   │   ├── autenticacao
│   │   │   │   │       ├── AlterarSenhaTest.class
│   │   │   │   │       ├── CadastroTest.class
│   │   │   │   │       ├── LoginTest.class
│   │   │   │   │
│   │   │   │   ├── chavepix
│   │   │   │   │       ├── DeleteChavePixTest.class
│   │   │   │   │       ├── GetChavePixTest.class
│   │   │   │   │       ├── PostChavePixTest.class
│   │   │   │   │
│   │   │   │   ├── health
│   │   │   │   │       ├── HealthCheckTest.class
│   │   │   │   │
│   │   │   │   ├── limiteTransacaoTest
│   │   │   │   │       ├── GetLimiteTransacaoTest.class
│   │   │   │   │       ├── PostLimiteTransacaoTest.class
│   │   │   │   │
│   │   │   │   ├── transferencia
│   │   │   │   │       ├── GetDetalhesTransferenciaTest.class
│   │   │   │   │       ├── GetHistoricoTransferenciaTest.class
│   │   │   │   │       ├── PostDepositoTest.class
│   │   │   │   │       ├── PostSaqueTest.class
│   │   │   │   │       ├── PostTransferenciaTest.class

│   │   ├── resources
│   │   │   ├── json_schemas
│   │   │   │   ├── GET_LIST_USERS.json
│   │   │   │   ├── PATCH_UPDATE_USER.json
│   │   │   │   ├── POST_CREATED.json
│   │   │   │   ├── PUT_UPDATE_USER.json
├── .gitignore
├── .github-ci.yml
├── pom.xml
├── README.md


Execução do projeto
Clonar o projeto
git clone https://github.com/CharlesSilvaAm/java-restassured.git
Branch
develop-test
Executar os testes pelo CLI. O comando deve ser executando na raiz do projeto.
mvn test
Ao final do teste será gerado um relatório HTML contendo a execução dos testes no diretório:
target/report/test-report.html
