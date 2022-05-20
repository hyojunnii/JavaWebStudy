-- 정규표현식 (REGULAR EXPRESSION)

-- 전화번호로 테스트

-- 정규식 연습을 위한 테스트 테이블 생성
--DROP TABLE MEMBER;
CREATE TABLE MEMBER(
      NO NUMBER
    , ID VARCHAR2(100)
    , PWD VARCHAR2(100)
    , PHONE VARCHAR2(100)
);

--테이블에 칼럼 추가
ALTER TABLE MEMBER ADD EMAIL VARCHAR2(100);

-- 테이블 확인
SELECT * FROM MEMBER;
DESC MEMBER;

-- 데이터 넣기
INSERT INTO MEMBER VALUES(8, '케이에이치', '1234', '010-9876-5432', 'kh@naver.com');

--COMMIT;

-- 전화번호 제대로 넣은 사람 조회
SELECT * FROM MEMBER
--WHERE PHONE LIKE '%-%-%';
WHERE REGEXP_LIKE (PHONE, '^01[01679]-\d{4}-\d{4}$');

/*
    [] : 한 글자
        EX) [김이박최], [0123456789], [0-9]
    \d : 숫자(digit) 하나
        EX) \d\d\d\d : 숫자 4개
    {} : 반복되는 갯수
        EX) \d{10} : 숫자 10개
        EX) \d{3,4} : 숫자 3개 또는 4개
    ^ : 문자열의 시작
    $ : 문자열의 끝
*/

-- 이메일 잘 작성했는지 검사
SELECT * FROM MEMBER
WHERE REGEXP_LIKE (EMAIL, '\D\w*@\D\w*.(com|co.kr|net)');

/*
    \w : 문자 하나
    * : 0개 이상
    + : 1개 이상
    | : 또는
    \D : 숫자가 아닌 것
*/

-- REG EXP LIB 검색

