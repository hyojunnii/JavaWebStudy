-- JOIN
-- ANSI 표준, ORACLE 전용 조인 쿼리

-- EQUI JOIN
-- NON-EQUI JOIN

--INNER JOIN
--OUTER JOIN (LEFT, RIGHT, FULL)
--CROSS JOIN
--SELF JOIN


SELECT *
FROM EMP;

SELECT *
FROM DEPT;

-- EMP랑 DEPT를 하나로 합치기 (DEPTNO를 이용해서)
-- INNER JOIN
SELECT *
FROM EMP E
JOIN DEPT D
ON E.DEPTNO = D.DEPTNO
;

-- 위의 쿼리를 ORACLE 전용 JOIN문으로 수정
SELECT *
FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO
;

-- OUTER JOIN 테스트를 위한 더미 데이터 입력
INSERT INTO EMP(EMPNO, ENAME, DEPTNO) VALUES (7777, 'SWY', 50);
INSERT INTO DEPT(DEPTNO, DNAME, LOC) VALUES(99, '부서', '역삼역');
--COMMIT;

-- OUTER JOIN (LEFT)
SELECT *
FROM EMP E
LEFT OUTER JOIN DEPT D
ON E.DEPTNO = D.DEPTNO
;

-- OUTER JOIN (RIGHT)
SELECT *
FROM EMP E
RIGHT OUTER JOIN DEPT D
ON E.DEPTNO = D.DEPTNO
;

-- OUTER JOIN (FULL)
SELECT *
FROM EMP E
FULL OUTER JOIN DEPT D
ON E.DEPTNO = D.DEPTNO
;

--CROSS JOIN
SELECT *
FROM EMP E
CROSS JOIN DEPT D
;

--SELF JOIN
SELECT *
FROM EMP E
JOIN EMP E2
ON E.MGR = E2.EMPNO
;

