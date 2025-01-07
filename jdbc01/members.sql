drop table members;

create table members(
	num number(5) primary key,
	name varchar2(15) not null,
	phone varchar2(15),
	addr varchar2(20),
	regdate date
);

insert into members values(1,'홍길동','010-111-1234','종로',sysdate);
commit;

create table point(
	pnum number(5) primary key,  --포인트번호
	num number(5) references members(num),  --회원번호
	mpoint number(4)  --포인트
);

create sequence point_seq;
insert into point values(point_seq.nextval,1,1000);
commit;


--파라미터로 번호,이름,전화번호,주소를 전달받아 db에 저장(insert하는 프로시져- addmember를 만들고 호출해 보세요)
CREATE OR REPLACE PROCEDURE addmember(num number,name VARCHAR2,phone VARCHAR2,addr VARCHAR2)
IS
BEGIN
    INSERT INTO MEMBERS VALUES(num,name,phone,addr,sysdate);
    COMMIT;
END;
/

exec addmember(7,'김철수','010-7799-7841','구로');

select * from members;


CREATE OR REPLACE PROCEDURE delmember(dnum members.num%TYPE)
IS
BEGIN
    DELETE FROM point WHERE NUM=dnum;
    DELETE FROM members WHERE NUM=dnum;
    COMMIT;
END;
/

EXECUTE delmember(5);


--배치프로그램 테스트를 위한 테이블
create table batchtest(
	id number(15) primary key,
	name varchar2(1000),
	age number(5)
);










