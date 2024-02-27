# projeto-cs

## Objetivo
O objetivo deste trabalho é modelar e desenvolver um sistema de aluguel de carros para um estabelecimento.

## 1. Backlog do produto
1.1. [H001] Controle de disponibilidade dos carros - visão atendentes
Como atendente, preciso controlar os carros que foram alugados e os que ainda estão disponíveis para aluguel. Quero que seja possível alterar a situação do modelo do carro como disponível/alugado/indisponível. Também quero que seja possível registrar a quantidade de dias que esse carro foi alugado (caso seja necessário aplicar multa se ele não for devolvido), se ele optou por alugar o veículo com opção de seguro, e que dê para inserir outras informações adicionais.

1.2. [H002] Gerenciamento dos modelos de carros - visão gerente e atendente
Como funcionário da loja, quero que seja possível cadastrar, editar, pesquisar e excluir os modelos de carros que serão disponibilizados para aluguel no estabelecimento. 
O sistema deve possibilitar o cadastro de carros no sistema com suas informações como modelo, ano, marca, se é automático, entre outras informações cruciais, e ainda deve providenciar a pesquisa e a exclusão de modelos de carros, sendo exclusão para caso os mesmos não se encontrem mais em loja.

1.3. [H003] Gerenciamento dos funcionários - visão gerente
Como gerente da loja, quero que seja possível cadastrar, editar, pesquisar e excluir os funcionários da loja para que eles consigam utilizar o sistema. O requisito também é necessário para se ter ciência de qual atendente foi responsável pelo aluguel de um carro. A edição e exclusão são necessárias em caso de mudança de dados ou demissão de funcionários. 
É importante frisar que apenas pessoas como eu, que serão administradoras do sistema, poderão fazer o cadastro e alteração de dados dos funcionários por motivos de segurança.

1.4. [H004] Gerenciamento clientes - visão gerente e atendente
Como funcionário da loja, preciso que seja possível cadastrar, editar, pesquisar e excluir os clientes que realizarem aluguéis no estabelecimento.
Quero que nessa parte haja campos com informações dos clientes, tais como nome, sobrenome, documento, e-mail, telefone, endereço e o carro que foi alugado por ele. A edição/exclusão dessas informações coletadas são necessárias caso alguma delas tenha sido preenchida erroneamente.
Esse requisito possui extrema prioridade para que eu (funcionário) consiga visualizar as informações coletadas, caso ocorra algo não desejado com o empréstimo ou caso eu deseje apenas realizar uma consulta sobre o cliente para algum outro fim.

1.5. [H005] Login do funcionário - visão gerente e atendente
Como funcionário, preciso da opção de fazer login para que se tenha o registro de que realizei um aluguel para um cliente e para que não haja possíveis equívocos caso seja necessário consultar quem foi o atendente responsável por tal empréstimo.

## 2. Arquitetura do software
Por via de regra, a arquitetura de três camadas, que será a utilizada no projeto aplica a arquitetura de camadas separada em três partes: a camada de apresentação, que consiste na parte de interface aplicação-usuário do software; a camada de aplicativo (ou camada lógica),  que consiste no core do software - todo o processamento, a aplicação das regras de negócio e as solicitações de manipulação de dados são realizadas aqui; e a camada de dados, que consiste, basicamente, no sistema de gerenciamento de dados da aplicação (podendo ser um banco de dados relacional, como o PostgreSQL, ou um NoSQL, como o MongoDB).
Uma das características mais relevantes dessa arquitetura é que a camada de apresentação, que é a mais externalizada da aplicação, não pode, de forma alguma, se comunicar diretamente com a camada de dados. Toda a “comunicação” do usuário com o banco deve ser gerenciada pela camada lógica, respeitando assim a regra “a camada n utiliza serviços somente da camada n-1”.

### Modelo Entidade-Relacionamento
![image](https://github.com/kimkaris/projeto-cs/assets/48491039/990f4b27-6492-4bc7-baa8-55cafd8e630d)
