drop table IF EXISTS user;

CREATE TABLE user(
user_id varchar(128) not null COMMENT 'ユーザID'
, password varchar(1024) not null COMMENT 'パスワード'
, primary key(user_id)
)
COMMENT = 'ユーザテーブル';