update regist set REG_PASS = 'Y';
commit;

update regist set reg_pass = 'N' where reg_no = 15;
commit;

update regist set reg_deny = '프로젝트 내용과 대표 사진이 연관되어있지 않음' where reg_no = 15;
commit;

UPDATE REGIST SET REG_CNT = 3 WHERE REG_NO = 5;
UPDATE REGIST SET REG_CNT = 2 WHERE REG_NO = 3;
UPDATE REGIST SET REG_CNT = 1 WHERE REG_NO = 8;
COMMIT;

update member set m_name = '권효정' where m_no=2;