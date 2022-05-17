-- DDLF

-- 테이블 생성
-- 칼럼명에 공백이 있을 시, 쌍따옴표로 묶어주면 사용 가능
-- 예악어를 칼럼명으로 사용하고싶으면, 쌍따옴표로 처리 가능
CREATE TABLE KH_MEMBER(
      NAME VARCHAR2(10)
    , AGE NUMBER
);

-- 테이블에 칼럼 추가 (DDL)
ALTER TABLE KH_MEMBER ADD EMAIL VARCHAR2(100);

SELECT * FROM KH_MEMBER;

-- 테이블 칼럼 삭제
ALTER TABLE KH_MEMBER DROP COLUMN EMAIL;

-- 칼럼 수정하기
ALTER TABLE KH_MEMBER MODIFY NAME VARCHAR2(100);

-- 데이터 넣어보기
INSERT INTO KH_MEMBER
VALUES ('심원용', 20);
COMMIT;

-- 테이블 삭제하기
DROP TABLE KH_MEMBER;
