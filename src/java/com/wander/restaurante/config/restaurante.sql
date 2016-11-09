use restaurante;

drop table if exists comandas;

create table comandas (

  codigo bigint not null primary key auto_increment,
  created_at datetime not null,
  updated_at timestamp,
  status enum('aberta','fechada')
  
);

drop table if exists itensconsumo;

create table itensconsumo (
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