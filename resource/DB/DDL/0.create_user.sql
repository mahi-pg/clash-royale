drop table IF EXISTS user;

CREATE TABLE user(
user_id varchar(128) not null COMMENT '���[�UID'
, password varchar(1024) not null COMMENT '�p�X���[�h'
, primary key(user_id)
)
COMMENT = '���[�U�e�[�u��';