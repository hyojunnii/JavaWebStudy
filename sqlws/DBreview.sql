--SELECT

/*
    �������
    Į�� ��Ī ����
    ���̺� ��Ī ����
    �ߺ����� DISTINCT
    || �����ڷ� ���ڿ� ��ġ��
*/

/*
    WHERE
        �� �����ڷ� ��
        BETWEEN A AND B
        IS [NOT] NULL
        AND, OR
        ��ȣ �̿��ؼ� �켱���� ����
        LIKE % , _
        IN
*/

SELECT * FROM EMPLOYEE WHERE DEPT_CODE IN('D9','D1');

/*
    ORDER BY
        ASC, DESC
*/

/*
    --������ �Լ�
        LENGTH
        LENGTHB
        INSTR : ������ ��ġ���� ������ ���ڹ�°���� ��Ÿ���� ������ ���� ��ġ
        LPAD/RPAD : ������ ���ڸ� ���� �Ǵ� �����ʿ� ���ٿ���
        LTRIM/RTRIM/TRIM : ��������
        SUBSTR : ������ ��ġ����, ������ ������ŭ ���ڿ� ����
        LOWER/UPPER/INITCAP
        CONCAT : ���ڿ� ��ġ��
        REPLACE : �����Ϸ��� ���� ����
        
        ABS
        MOD
        ROUND
        FLOOR
        CEIL
        TRUNC
        
        MONTHS_BETWEEN
        ADD_MONTHS
        
        EXTRACT(YEAR|MONTH|DAY FROM DATE) : 
*/

SELECT INSTR('HELLO WORLD', 'L', 2) FROM DUAL;

SELECT EXTRACT(YEAR FROM SYSDATE) FROM DUAL;

/*
    ���ڿ� : TO_CHAR
    ���� : TO_NUMBER
    ��¥ : TO_DATE
    
    FORMAT ���� ����
*/

SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') FROM DUAL;

SELECT TO_DATE('021231') FROM DUAL;


/*
    NULL ó�� �Լ�
        NVL
        NVL2
        DECODE
        CASE ~ WHEN ~ THEN ~ ELSE ~ END
*/

SELECT EMP_NAME �����, SALARY �޿�, SALARY*BONUS ���ʽ�, SALARY+SALARY*NVL(BONUS,0) �ѱ޿� FROM EMPLOYEE;

-- ���ʽ� ���� // ����: 0.1, ������ 0
SELECT EMP_NAME �����, 
NVL(BONUS, 0) �������ʽ���, 
NVL2(BONUS, 0.1, 0) ����Ⱥ��ʽ���,
(SALARY+NVL2(BONUS,0.1,0))*12 ����
FROM EMPLOYEE;

--DECODE
SELECT EMP_ID ���, EMP_NAME �����, EMP_NO �ֹι�ȣ, 
DECODE(SUBSTR(EMP_NO,8,1),1,'��',2,'��') ����
FROM EMPLOYEE;

--CASE
SELECT EMP_ID ���, EMP_NAME �����, EMP_NO �ֹι�ȣ, 
CASE
    WHEN SUBSTR(EMP_NO,8,1) = 1 THEN '��' 
    WHEN SUBSTR(EMP_NO,8,1) = 2 THEN '��'
    ELSE '��'
END ����
FROM EMPLOYEE;


/*
    �׷��Լ�
        GROUP BY
        HAVING
*/

SELECT SUM(SALARY)
FROM EMPLOYEE;

SELECT DEPT_CODE, AVG(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING AVG(SALARY) > 3000000;

SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

SELECT COUNT(*)
FROM EMPLOYEE;

SELECT DEPT_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

SELECT DEPT_CODE, COUNT(BONUS)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

/*
�����Լ�
    CUBE
    ROLLUP
    GROUPING SETS
    
    GROUPING
*/

SELECT
    DEPT_CODE,
    GROUPING(DEPT_CODE),
    SUM(SALARY),
    AVG(SALARY)
FROM EMPLOYEE
GROUP BY CUBE(DEPT_CODE);

/*
���տ�����
    UNION
    UNION ALL
    INTERSECT
    MINUS
*/

/*
JOIN
    INNER
    OUTER - SELF, RIGHT, FULL
    SELF
    CROSS
    
    NON EQUAL JOIN
*/

SELECT E.EMP_NAME, E.DEPT_CODE, D.DEPT_TITLE
FROM EMPLOYEE E
FULL OUTER JOIN DEPARTMENT D
ON E.DEPT_CODE = D.DEPT_ID;

--NON EQUAL JOIN (�� ����)
SELECT E.EMP_NAME, E.SALARY, S.SAL_LEVEL, S.MIN_SAL, S.MAX_SAL
FROM EMPLOYEE E
JOIN SAL_GRADE S
ON (E.SALARY BETWEEN S.MIN_SAL AND S.MAX_SAL);

SELECT E.EMP_NAME, E.SALARY, S.SAL_LEVEL, S.MIN_SAL, S.MAX_SAL
FROM EMPLOYEE E
JOIN SAL_GRADE S
--ON (E.SALARY BETWEEN S.MIN_SAL AND S.MAX_SAL); 
ON (E.SALARY > S.MIN_SAL); 