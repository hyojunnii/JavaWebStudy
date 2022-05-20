-- 서브쿼리
-- 중첩 원하는 만큼 가능

SELECT T.*
FROM 
(
    SELECT 
        ROWNUM RN
        , ENAME 이름
        , HIREDATE 입사일
        , SAL 급여
        , DEPTNO 부서번호
    FROM EMP E
    WHERE SAL > 2000
) T
WHERE 부서번호 = 10
OR 부서번호 = 20
ORDER BY RN --ROWNUM 정렬가능
;


SELECT ENAME 이름, SAL 월급, SAL*12 연봉
FROM EMP
ORDER BY 이름;


SELECT 
      ROWNUM RN
    , ENAME 이름
    , HIREDATE 입사일
    , SAL 급여
    , DEPTNO 부서번호
FROM EMP E
WHERE SAL > 2000
;