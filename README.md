<br />
<p align="center">
  <h3 align="center">BeerNote</h3>
</p>

<!-- TABLE OF CONTENTS -->

## Conteúdo

- [Conteúdo](#Conteúdo)
- [Sobre o projeto](#Sobre-o-Projeto)
  - [Arquitetura](#Arquitetura)
- [Iniciando](#Iniciando)
  - [Como usar](#Como-usar)
- [Contribuindo](#Contribuindo)
- [Licença](#Licença)
- [Contato](#Contato)

## Sobre o Projeto
O projeto BeerNote tem como objetivo ser um bloco de anotações para apreciadores de cervejas, além de poderem compartilhar as suas avaliações e ler as avaliações de outras pessoas geograficamente próximas.
### Arquitetura
<p align="center">
  <a href="https://github.com/SamuelModesto">
      <img alt="Java-Solid" src="https://github.com/SamuelModesto/Assets/blob/master/Imagens%20BeerNote/ArquiteturaBeerNote.jpeg" />
  </a>
</p>
## Iniciando


### Como usar
1. Os bancos de dados (MySql, Postgres, Mongo) devem ser instalados.
2. RabbitMq precisa ser instalado.
3. Baixar o projeto e abrir na IDE de sua preferência.
4. Acessar o arquivo `Application.yml` para obter informações de configuração do banco de dados.
5. Criar as filas no RabbitMQ. Para isso consultar o arquivo `Application.yml` para informações de nomes e routingKey das filas.
6. Iniciar os serviços na seguinte ordem:
  6.1 Eureka.
  6.2 Gateway.
  6.3 Pessoas.
  6.4 BeerNote.
  6.5 Evaluation.
7. Acessar os links abaixo do swagger de cada serviço para executar requisições.

- Swagger(Pessoas) - http://localhost:8080/pessoas/swagger-ui.html#/
- Swagger(Cervejas) - http://localhost:8080/beerNote/swagger-ui.html#/
- Swagger(Evaluation) - http://localhost:8080/evaluation/swagger-ui.html#/
- Eureka - http://localhost:8761
- Rabbitmq - http://localhost:15672/#


## Contribuindo

As contribuições são o que tornam a comunidade de código aberto um lugar incrível para aprender, inspirar e criar. Qualquer contribuição que você fizer será **muito apreciada**.

1. Faça um 'fork' do projeto
2. Cria uma branch para a sua feature(`git checkout -b feature/amazing-feature`)
3. Insira suas alterações (`git add .`)
4. Faça um commit com as suas alterações (`git commit -m 'feat(<project-filename>): Inserindo uma feature!`)
5. Faça um push da sua branch (`git push origin feature/amazing-feature`)
6. Abra um Pull Request

## Licença

Distribuído sob a licença do MIT. Consulte `LICENSE` para obter mais informações.

## Contato

Denner Ramiro
- [Github](https://github.com/DennerRR) 
- [LinkedIn](https://www.linkedin.com/in/denner-ramiro-ribeiro-795960200/)
- Email - **dennerramiror@gmail.com**

Samuel Modesto 
- [Github](https://github.com/SamuelModesto) 
- [LinkedIn](https://www.linkedin.com/in/samuelmodesto)
- Email - **samuelmodestoes@gmail.com**

Willian Clemente
- [Github](https://github.com/WillianGiovanni) 
- [LinkedIn](https://www.linkedin.com/in/willian-clemente-b873b41b2/)
- Email - **willianclemente10@gmail.com**
