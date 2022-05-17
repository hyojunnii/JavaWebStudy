-- DDL (테이블 생성)

-- 테이블 생성
/*
    CREATE TABLE 테이블명(
         칼럼명 칼럽타입
        ,칼럼명 칼럼타입
    };
*/
CREATE TABLE MEMBER(
      NO          NUMBER
    , ID          VARCHAR2(30)
    , PWD         VARCHAR2(100)
    , PHONE       CHAR(13)
    , ENROLL_DATE TIMESTAMP
);

-- 데이터 조회
SELECT * FROM MEMBER;

-- 데이터 넣기
INSERT ALL
INTO MEMBER
VALUES(1,'SWY','1234','010-1234-5678',SYSDATE)
INTO MEMBER
VALUES(2, 'SWY2','1234','010-1234-5678',SYSDATE)
SELECT * FROM DUAL;

-- 데이터 수정
UPDATE MEMBER
  SET PWD = '4321'
  WHERE ID = 'SWY';

-- 데이터 삭제
DELETE FROM MEMBER;