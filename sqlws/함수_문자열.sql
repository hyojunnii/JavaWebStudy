-- 함수 (문자열)

--SUBSTR(문자열, 시작위치, (갯수))
SELECT SUBSTR('ABCDEFGHIJK', 3, 5) 
FROM DUAL;

SELECT * 
FROM EMP
WHERE ENAME LIKE '%' || SUBSTR('ABCDEFG',5,1) || '%'; -- = %E%

--CONCAT : 문자열 합치기
SELECT CONCAT('ABC','심원용') CONCAT
FROM DUAL;

--TRIM : 공백 제거 / TRIM, LTRIM, RTRIM
SELECT TRIM('   ABC   ') TRIM
FROM DUAL;

--LOWER : 소문자로
--UPPER : 대문자로
SELECT LOWER('ABC') 
FROM DUAL;

--REPLACE : 대체
SELECT REPLACE('ABC','B','X')
FROM DUAL;

--PAD : 원하는 사이즈 만큼 빈칸 채워줌 (원하는 문자로)
--LPAD, RPAD
SELECT RPAD('ABC',5,'0') AS PAD
FROM DUAL;

--INITCAP : 첫글자를 대문자로 바꿔줌
SELECT INITCAP('abc') 
FROM DUAL;

--INSTR : 특정 문자열이 몇번째에 존재하는지 확인 (문자열, 찾을문자열, 몇번째부터 검색, N번째 나오는)
SELECT INSTR('ABCDEFGKH12345KH12345','KH', 5, 2) 
FROM DUAL;

--LENGTH : 문자열 길이
SELECT LENGTH('ABC') FROM DUAL;
