# API-REST-Consulta-de-cidades-Brasil

## Necessário
* Git
* Java 8
* Docker
* IntelliJ Community
* Heroku CLI
## DataBase
Para rodar um banco de dados conteinerizado basta rodar o comando abaixo no prompt de comando da sua máquina(Banco postgres)


* [Postgres Docker Hub](https://hub.docker.com/_/postgres)

```shell script
docker run --name cities-db -d -p 5432:5432 -e POSTGRES_USER=postgres_user_city -e POSTGRES_PASSWORD=super_password -e POSTGRES_DB=cities postgres
```
Para populizar o banco de dados você pode clonar esse repositório(antes da uma estrela lá)

* [data](https://github.com/chinnonsantos/sql-paises-estados-cidades/tree/master/PostgreSQL)

Depois de clonado, acesse o diretório sql-paises-estados-cidades/PostgreSQL
através do powershell e use esses comandos para popular o banco de dados.
```shell script
cd ~/workspace/sql-paises-estados-cidades/PostgreSQL

docker run -it --rm --net=host -v ${pwd}:/tmp postgres /bin/bash

psql -h localhost -U postgres_user_city cities -f /tmp/pais.sql
psql -h localhost -U postgres_user_city cities -f /tmp/estado.sql
psql -h localhost -U postgres_user_city cities -f /tmp/cidade.sql

psql -h localhost -U postgres_user_city cities

CREATE EXTENSION cube; 
CREATE EXTENSION earthdistance;
```
Apartir disso você ja pode desenvolver localmente.

## Endpoints da api em produção
A api ja está em ambiente de produção, você pode testar os endpoints dela pelo postman ou o próprio navegador se quiser:

**https://consulta-cidades-brasil.herokuapp.com/cities** Retorna todas as cidades páginados.<br>
**https://consulta-cidades-brasil.herokuapp.com/countries** Retorna todos os paises páginados.<br>
**https://consulta-cidades-brasil.herokuapp.com/countries{id}** Retorna um único pais pelo id passado<br>
**https://consulta-cidades-brasil.herokuapp.com/states** Retorna todos os estados páginados.<br>
**https://consulta-cidades-brasil.herokuapp.com/distances/by-points** Recebe o id de duas cidades retorna a distância entre elas em milhas.<br>
**https://consulta-cidades-brasil.herokuapp.com/distances/by-cube** Recebe o id de duas cidades retorna a distância entre elas em metros.<br>


