create database if not exists restaurante;
grant all privileges on restaurante.* to restaurante identified by 'restaurante';

use restaurante;

-- tabela clientes
create table if not exists clientes (
   codigo bigint not null primary key auto_increment,
   nome varchar(50) not null,
   sexo enum('masculino','feminino'),
   data_nasc date not null,
   tipo_pessoa enum ('fisica','juridica') default 'fisica',
   cpf_cnpj varchar(14) not null,
   email varchar(60),
   site varchar(60),
   facebook varchar(60),
   celular varchar(15),
   fixo varchar(15),
   tel_recado varchar(15),   
   ativo bit(1) default true,
   observacao text(100)
);

create table if not exists enderecos_clientes (
   cliente_codigo bigint not null,
   cep char(8) not null,
   logradouro varchar(15),
   endereco varchar(100),
   numero varchar(10),
   lote varchar(10),
   quadra varchar(10),
   bairro varchar(100),
   cidade varchar(100),
   uf char(2),
   constraint fk_cli_end foreign key (cliente_codigo) references clientes(codigo)
);

-- drop table if exists comandas;
-- Tabela comandas.
create table if not exists comandas (
  codigo bigint not null primary key auto_increment,
  created_at datetime not null,
  updated_at timestamp,
  status enum('aberta','fechada')
  
);

-- drop table if exists itensconsumo;
-- Tabela itens de consumo
create table if not exists itensconsumo (
  comanda_codigo bigint not null, 
  produto_codigo bigint not null, 
  qtde double,
  valor_unitario double not null default 0.00,
  valor_total double not null default 0.0,
  created_at datetime, 
  updated_at datetime,
  constraint fk_itens_comanda_codigo foreign key ( comanda_codigo ) references comandas(codigo),
  constraint fk_itens_produto_codigo foreign key ( produto_codigo ) references produtos(codigo)

  );
  
/*
  Listar itens de consumo
*/  
select i.comanda_codigo comanda, p.descricao produto, i.qtde qtde, i.valor_unitario valor_unitario,i.valor_total valor_total, date_format(i.updated_at,'%d-%m-%Y  %T')  horario 
from comandas c, itensconsumo i, produtos p 
where c.codigo = i.comanda_codigo
and i.produto_codigo = p.codigo ;
