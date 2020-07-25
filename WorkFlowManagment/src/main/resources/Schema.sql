DROP TABLE IF EXISTS VAWA_GROUP;

CREATE TABLE VAWA_GROUP (
GROUP_ID BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY ,
 NAME VARCHAR(8) NOT NULL);

 insert into VAWA_GROUP(GROUP_ID,NAME) values (1,'GROUP1');
 insert into VAWA_GROUP(GROUP_ID,NAME) values (2,'GROUP2');

DROP TABLE IF EXISTS MEMBER;

CREATE TABLE MEMBER(
MEMBER_ID BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY ,
NAME VARCHAR(8) NOT NULL);

insert into MEMBER(MEMBER_ID,NAME) values (1,'Ravi');
insert into MEMBER(MEMBER_ID,NAME) values (2,'Kumar');

CREATE TABLE GROUP_MEMBER(
GROUP_ID BIGINT NOT NULL,
MEMBER_ID BIGINT  NOT NULL
);

ALTER TABLE GROUP_MEMBER
    ADD FOREIGN KEY (GROUP_ID)
    REFERENCES VAWA_GROUP(GROUP_ID);

ALTER TABLE GROUP_MEMBER
    ADD FOREIGN KEY (MEMBER_ID)
    REFERENCES MEMBER(MEMBER_ID);

    insert into GROUP_MEMBER(GROUP_ID, MEMBER_ID) values (1,1);
    insert into GROUP_MEMBER(GROUP_ID,MEMBER_ID) values (2,2);
    insert into GROUP_MEMBER(GROUP_ID, MEMBER_ID) values (2,1);

DROP TABLE IF EXISTS SUBORDER;

CREATE TABLE SUBORDER( 
SUBORDER_ID INT NOT NULL PRIMARY KEY, 
ORDER_NUMBER INT NOT NULL , 
ORDER_DESCRIPTION VARCHAR(30) NOT NULL , 
QUANTITY INT NOT NULL , 
ITEM_ID INT NOT NULL , 
TOP1 VARCHAR(30) , 
TOP2 VARCHAR(30) ,
 TOP3 VARCHAR(30), 
 PRICE INT NOT NULL, 
 ORDER_STATUS VARCHAR(30), 
 MEMBER_ID BIGINT );

 ALTER TABLE SUBORDER
    ADD FOREIGN KEY (MEMBER_ID)
    REFERENCES MEMBER(MEMBER_ID);

DROP TABLE IF EXISTS ITEM;

CREATE TABLE ITEM (

ITEM_ID BIGINT NOT NULL PRIMARY KEY,
ITEM_NAME VARCHAR(30) ,
PRICE INT NOT NULL,
GROUP_ID BIGINT
);

ALTER TABLE ITEM
    ADD FOREIGN KEY (GROUP_ID)
    REFERENCES VAWA_GROUP(GROUP_ID);
