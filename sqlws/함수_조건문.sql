-- 함수

--DECODE
SELECT EMPNO, ENAME, DEPTNO, DECODE(DEPTNO, 10, '영업1팀', 20, '영업2팀', 30, '영업3팀') 소속
FROM EMP;

--CASE WHEN THEN END
SELECT 
      EMPNO
    , ENAME
    , DEPTNO
    , CASE 
        WHEN DEPTNO = 10 THEN '영업1팀' 
        WHEN DEPTNO = 20 THEN '영업2팀' 
        WHEN DEPTNO = 30 THEN '영업3팀'
        ELSE '부서없음'
      END 
FROM EMP
ORDER BY DEPTNO
;

-- 실습
SELECT 
      EMPNO
    , ENAME
    , DEPTNO
    , CASE
        WHEN SAL <= 1000 THEN '신입'
        WHEN SAL <= 2000 THEN '초급'
        WHEN SAL <= 3000 THEN '중급'
        WHEN SAL <= 4000 THEN '고급'
        ELSE '특급'
      END 직위
FROM EMP;

