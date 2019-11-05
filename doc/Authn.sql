create table authn(
  user_id varchar(32) not null primary key ,
  passphrase varchar(100) not null,
  user_name varchar(32) not null ,
  user_role varchar(32) not null
);



insert into authn values ('t001','19b58543c85b97c5498edfd89c11c3aa8cb5fe51','Hikari Chitose','teacher');
insert into authn values ('s001','f1b699cc9af3eeb98e5de244ca7802ae38e77bae','Taro Naganuma','student');
