-- DML
---------------------------------------------------------
-- SELECT : READ : 데이터 읽기
---------------------------------------------------------

SELECT * FROM EMP; -- EMP 테이블의 모든 칼럼 조회
SELECT EMPNO, ENAME FROM EMP; -- EMP 테이블의 특정 칼럼 조회
-- 별칭 사용하기
SELECT EMPNO AS 사원번호, ENAME AS 사원이름 FROM EMP;
SELECT EMPNO 사원번호, ENAME 사원이름 FROM EMP;
SELECT EMPNO "사원 번호", ENAME "사원 이름" FROM EMP;

--SELECT * FROM DEPT;
--SELECT * FROM BONUS;
--SELECT * FROM SALGRADE;

---------------------------------------------------------
-- INSERT : CREATE : 데이터 삽입(생성)
---------------------------------------------------------
/*
 INSERT INTO
 테이블명(칼럼1, 칼럼2, ...)
 VALUES(값1, 값2, ...);
 
 - 칼럼 순서 마음대로
 - 모든 칼럼 쓸 필요 없음(NULL)
 - 모든 칼럼 다 쓸 경우, 생략가능
*/
INSERT INTO 
EMP(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) 
VALUES(1234, 'SWY', 'SALESMAN', 7902, SYSDATE, 777, 100, 30);

INSERT INTO 
EMP(ENAME, EMPNO, JOB, HIREDATE, SAL, COMM, DEPTNO) 
VALUES('SWY', 8888, 'SALESMAN', SYSDATE, 777, 100, 30);

INSERT INTO 
EMP
VALUES(5555, 'SWY', 'SALESMAN', 7902, SYSDATE, 777, 100, 30);

---------------------------------------------------------
-- UPDATE : UPDATE : 데이터 수정
---------------------------------------------------------
/*
 UPDATE 테이블명 SET 칼럼명 = 값 
 WHERE 칼럼1 연산자 비교값1 
 AND 칼럼2 연산자 비교값2
 OR 칼럼3 연산자 비교값3;
*/

INSERT INTO BONUS(ENAME, JOB, SAL, COMM)
VALUES('SWY', 'SALESMAN', 777, 100);

INSERT INTO BONUS(ENAME, JOB, SAL, COMM)
VALUES('SWY2', 'SALESMAN2', 777, 100);

SELECT * FROM BONUS;

UPDATE BONUS SET SAL = 111 WHERE ENAME = 'SWY';

UPDATE BONUS SET SAL = 111 WHERE COMM > 100;

---------------------------------------------------------
-- DELETE : DELETE : 데이터 삭제
---------------------------------------------------------

SELECT * FROM BONUS;
SELECT * FROM EMP;

DELETE FROM BONUS -- 모든 ROW 삭제
WHERE ENAME = 'SWY2';

DELETE FROM EMP
WHERE EMPNO = 1234
OR EMPNO = 8888
OR EMPNO = 5555;

