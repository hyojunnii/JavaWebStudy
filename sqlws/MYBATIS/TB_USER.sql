DROP TABLE TB_USER;
CREATE TABLE TB_USER(
    ID VARCHAR2(50) PRIMARY KEY
    , PWD VARCHAR2(100)
);

INSERT INTO TB_USER (ID, PWD) VALUES('USER0830', 1234);
ROLLBACK;

SELECT ID, PWD FROM TB_USER WHERE ID='user07' AND PWD='1234';