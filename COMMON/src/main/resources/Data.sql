--插入 伪静态表的DATA 以后需要做数据迁移的时候,作为初始化数据准备


--角色类型:Role
INSERT INTO ROLE(ROLE_ID, ROLE_NAME) VALUES (1,'Administrator');
INSERT INTO ROLE(ROLE_ID, ROLE_NAME) VALUES (2,'Business');
INSERT INTO ROLE(ROLE_ID, ROLE_NAME) VALUES (3,'Customer');

--状态表:Status
INSERT INTO STATUS(STATUS_ID, STATUS_NAME) VALUES (1,'APPROVING');                --审核中
INSERT INTO STATUS(STATUS_ID, STATUS_NAME) VALUES (2,'DELETED');                  --删除
INSERT INTO STATUS(STATUS_ID, STATUS_NAME) VALUES (3,'REJECTED');                 --被拒绝成为商家
INSERT INTO STATUS(STATUS_ID, STATUS_NAME) VALUES (4,'ACCEPTED');                 --接受成为商家
INSERT INTO STATUS(STATUS_ID, STATUS_NAME) VALUES (5,'HOT');                      --热门的~被审核通过的商家~


--商家工作状态表:WorkStatus






