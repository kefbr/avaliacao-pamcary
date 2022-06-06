# Avaliação

### Tarefas

- Crie uma API pública em que seja possível listar, cadastrar, deletar e atualizar pessoas (C.R.U.D)
- Crie um endpoint público de busca por CPF
- Crie uma interface web. Sugestão: Angular2+, JSF 1.2


### O que esperamos ?
- Encaminhar o link do seu repositório do Github
- Explicação de como rodar localmente e também como seria possível realizar o deploy.
- Testes (Pelo menos 60% de cobertura)
- Legibilidade
- Escalabilidade
- Commits pequenos
- Ver sua experiência codificando
- CLEAN CODE
- Keep it simple =] 

### Prazo de entrega
Após recebimento do e-mail o candidato terá 48hrs para entregar o projeto.


### Deploy
O deploy foi realizado na plataforma Heroku, o link para acesso é: https://pamcary.herokuapp.com.
No repositório há um arquivo chamado `avaliacao-pamcary.postman_collection.json` nele contem as informações necessárias para fazer as chamadas dos END-POINTS.

Para fins de informação, é também possivel fazer o deploy de outras formas:

— **Kubernetes**:
Há um arquivo criado de configuraçào docker para criar a imagem para o deploy `docker pull kefbr/pamcary:latest`. Para fins de escabilidade, usei o Minikube para criar um Cluster de modo a podermos ter controle sobre os PODs.
`kubectl create deployment pamcary --image=kefbr/pamcary`

— **AWS**:
Há algumas maneiras de se fazer um deploy na AWS, vou mostrar o mais comum e mais fácil também.
Usando o EC2 é o jeito mais rápido de se fazer um deploy, após ter criado um EC2 linux basta subir o arquivo `avaliacao-1.0.0.jar` e executar o jar dentro da EC2.
Outra maneira é a utilizar o AWS Elastic Beanstalk, que utiliza o Apache Tomcat como container.

— **Azure**:
No azure podemos usar o Azure Spring Cloud, não coloquei as configurações, mas é bem simples de realizar também.
Vou deixar o link para se tiver interesse em subir https://spring.io/guides/gs/spring-boot-for-azure/