-- 개요

-- <SQL>
-- DDL
/*
    DATA DEFINATION LANGUAGE 정의어
    EX ) 테이블 생성 구문 CREATE ADD ALTER DROP
*/
-- DML
/*
    DATA MANIPULATION LANGUAGE 조작어
    EX ) SELECT INSERT UPDATE DELETE
*/
-- DCL
/*
    DATA CONTROL LANGUAGE 제어어
    EX ) GRANT REVOKE
*/
-- TCL 트랜잭션 제어어 EX ) COMMIT ROLLBACK

-----------------------------------------------------------

-- <자료형>

-- 문자열 형식
/*
    CHAR(SIZE)
    EX ) CHAR(10) : 10바이트까지 담을 수 있는 문자열 칼럼 생성
    
    VARCHAR2(SIZE)
    EX ) VARCHAR2(10) : 최대 10바이트까지 담을 수 있는 문자열 칼럼 생성
    
    NCHAR(SIZE)
    EX ) NCHAR(10) : 10글자까지 담을 수 있는 문자열 칼럼 생성 (상황에 따라 2||3바이트로 처리)
*/

-- 대용량 형식
/*
    LONG : 사용X
    CLOB : 대용량 문자열 타입 (4GB)
    NCLOB : CLOB과 비슷 (유니코드로 처리)
*/

-- 숫자(NUMBERIC) 형식
/*
    NUMBER : 최대 38글자로 이루어진 숫자 == NUMBER(28)
    NUMBER(10) : 최대 10글자로 이루어진 숫자
    NUMBER(10, 5) : 소수점 5자리 포함하는 최대 10자리 숫자
    NUMBER(10, -5) : 소수점 -5자리에서 반올림하는 최대 10자리 숫자
*/

-- 날짜(DATE) 형식
/*
    DATE : 날짜 저장
    TIMESTAMP : 날짜 + 시간
    TIMESTAMP WITH TIME ZONE : 날짜 + 시간 + 위치
    TIMESTAMP WITH LOCAL TIME ZONE : 날짜 + 시간 + 위치
*/






