-- ����

SELECT ROW_NUMBER() OVER(ORDER BY HIREDATE) AS RN, E.*
FROM EMP E
;

SELECT RANK() OVER(ORDER BY HIREDATE) AS RN, E.*
FROM EMP E
;

SELECT DENSE_RANK() OVER(ORDER BY HIREDATE) AS RN, E.*
FROM EMP E
;

-- �׷� ������ ��ŷ
SELECT RANK() OVER(PARTITION BY DEPTNO ORDER BY HIREDATE) AS RN, E.*
FROM EMP E
;

SELECT ROWNUM, E.* --�����̻��ϰ� ����
FROM EMP E
ORDER BY HIREDATE
;

