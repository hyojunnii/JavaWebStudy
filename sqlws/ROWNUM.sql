-- ROWNUM

-- 테이블명, 칼럼명 (테이블명 생략 가능)
-- 테이블명 뒤에 해당 테이블의 별칭 지정 가능
SELECT E.EMPNO, E.ENAME
FROM EMP E
;

-- ROWNUM : 행 번호를 붙여줌
SELECT ROWNUM AS RNUM, E.*
FROM EMP E
WHERE ROWNUM >= 1
--WHERE ROWNUM >= 2 -- 실패(레코드 못 읽어옴, RESULT SET 1열부터 검사)
;

