-- 트랜잭션
/*
    : 쪼갤 수 없는 업무 처리의 최소 단위
    EX) 계좌이체 : 내 통장의 돈을 다른 통장으로 옮기는 것
    1. 내 통장에서 돈을 빼감
    2. 상대방 통장에 돈을 넣음
*/

-- 커밋, 롤백
-- DDL구문에는 COMMIT 자동 포함

-- 트랜잭션 테스트를 위한 임시 테이블 생성 //삭제(DROP)할거임
CREATE TABLE MY_TB(
      NAME CHAR(9)
    , AGE NUMBER
);

INSERT INTO MY_TB(NAME, AGE)
VALUES ('ABC', 20);
COMMIT; -- 커밋해야지 실제 DB에 반영

INSERT INTO MY_TB
VALUES ('ZZZ', 22);
ROLLBACK;

SELECT * FROM MY_TB;

DROP TABLE MY_TB;