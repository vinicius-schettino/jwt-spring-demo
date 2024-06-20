# Spring + JWT + OAuth2 Demo

Código de exemplo para autenticação com Spring Security, JWT e OAuth2.

## Projeto RideR API + Autenticação

A terceira parte do projeto consiste em desenvolver um fluxo de autenticação similar ao [apresentado em sala de aula](https://github.com/vinicius-schettino/jwt-spring-demo) para os serviços da RideR API de vocês:

1. Criar os requests para gerar o token JWT com `grant_type=refresh_token` e `grant_type=password`
1. Criar ou atualizar endpoints para implementar a validação do JWT, como o exemplo em sala. Cada grupo deve 
   implementar pelo menos um endpoint público, um privado e um que é limitado ao papel (role) `admin`.
1. Criar os requests de exemplo para cada endpoint criado. Preparar uma demonstração a ser apresentada em sala até 
   dia 27/06.

### Instruções
1. Escolher a ferramenta que desejar para fazer as requisições HTTP; sugiro  ([Hopscotch](https://hoppscotch.io/), 
   [Postman](https://www.postman.com/) ou 
   [essa extensão para o vscode](https://marketplace.visualstudio.com/items?itemName=humao.rest-client).).
1. Acesso temporário às credenciais e endpoints necessários: https://share.1password.com/s#GhIZQee25bW6Refdfk2m35dKHQs3pQI4VsMmehmXy6Q
1. Quem commitar credencial vai perder ponto!


Queries de exemplo para gerar o token JWT:

```http
# Autenticando só com o client secret
POST ${IDP_SERVER}/realms/rider-api/protocol/openid-connect/token HTTP/1.1
Content-Type: application/x-www-form-urlencoded

client_id=demo
&client_secret=${CLIENT_SECRET}
&grant_type=client_credentials


# Autenticando com credenciais do usuário para adicionar os roles no JWT
POST ${IDP_SERVER}/realms/rider-api/protocol/openid-connect/token HTTP/1.1
Content-Type: application/x-www-form-urlencoded

client_id=demo
&client_secret=${CLIENT_SECRET}
&grant_type=password
&username=${DEMO_USER}
&password=${DEMO_PASSWORD}

# (re)Autenticando com refresh token
POST ${IDP_SERVER}/realms/rider-api/protocol/openid-connect/token HTTP/1.1
Content-Type: application/x-www-form-urlencoded

client_id=demo
&client_secret=${CLIENT_SECRET}
&refresh_token=${REFRESH_TOKEN}
&grant_type=refresh_token

```