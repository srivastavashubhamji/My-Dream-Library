create table if not exists tbl_book_info(
	b_acc_id int(5) not null auto_increment,
	b_name varchar(50) not null,
	b_qty int(2) not null,
	b_type varchar(30) not null,
	b_auth1 varchar(50) not null,
	b_auth2 varchar(50),
	b_pub varchar(50) not null,
	b_pages int(4) not null,
	b_rack int(5) not null,
	b_price  Decimal(6,2) not null,
	b_about text,
	primary key(b_acc_id)
);

create table if not exists tbl_books(	
	accid int(5) references tbl_book_info.b_acc_id,
	accno int(3),
	status varchar(1) default "A",
	primary key(accid,accno)
);

create table mems(

	-- +-------------+--------------+------+-----+---------+----------------+
	-- | Field       | Type         | Null | Key | Default | Extra          |
	-- +-------------+--------------+------+-----+---------+----------------+
	-- | m_Id        | int(6)       | NO   | PRI | NULL    | auto_increment |
	-- | mName       | varchar(25)  | NO   |     | NULL    |                |
	-- | mPh1        | varchar(12)  | NO   |     | NULL    |                |
	-- | mPh2        | varchar(12)  | YES  |     | NULL    |                |
	-- | mAddr       | varchar(40)  | NO   |     | NULL    |                |
	-- | mType       | varchar(1)   | NO   |     | NULL    |                |
	-- | mJoinFee    | decimal(6,2) | NO   |     | NULL    |                |
	-- | mProtectFee | decimal(6,2) | NO   |     | NULL    |                |
	-- | mStatus     | varchar(1)   | NO   |     | A       |                |
	-- | doj         | date         | NO   |     | NULL    |                |
	-- | doPFee      | date         | NO   |     | NULL    |                |
	-- | lostbooks   | int(2)       | NO   |     | NULL    |                |
	-- | Cls         | varchar(10)  | YES  |     | NULL    |                |
	-- | rno         | int(12)      | NO   |     | NULL    |                |
	-- +-------------+--------------+------+-----+---------+----------------+
	-- create field LOSTBOOKS with  :  ALTER TABLE MEMS MODIFY LOSTBOOKS INT(2) DEFAULT 0;
	-- create field Cls 			:  ALTER TABLE MEMS MODIFY CLS VARCHAR(10) NULL;
	-- create field Rno      	    :  ALTER TABLE MEMS MODIFY RNO INT(12) NULL;
	
);

Delimiter $$
create procedure insBooks(
	IN paramAccId int(5), IN paramAccNum int(3)
)
BEGIN
	insert into tbl_books (accid,accno) values( paramAccId,
	paramAccNum );
END$$

Delimiter ;


/*
This Query Used in Show Tab to get TotalBooks,TotalQty,Available,Issued,Repairing books of library ...
*/
Select (Select count(*) from tbl_book_info) TotalBooks,(Select count(*) from tbl_books) TotalQty,
	(Select count(*) from tbl_books where status='A') Available,(Select count(*) from tbl_books where status='I') Issued,
	(Select count(*) from tbl_books where status='R') Repair
from dual;
/*
Output...
+------------+----------+-----------+--------+--------+
| TotalBooks | TotalQty | Available | Issued | Repair |
+------------+----------+-----------+--------+--------+
|          5 |       23 |        23 |      0 |      0 |
+------------+----------+-----------+--------+--------+
]

*/
Select a.b_name, a.b_qty, a.b_acc_id , 
	 sum(case 
			when b.status='I' then 1
			else 0
		 end
		) as Issued,
	 sum(case 
			when b.status='A' then 1
			else 0
		 end
		) as Available
From tbl_book_info a left join tbl_books b on a.b_acc_id=b.accid
group by a.b_name, a.b_qty, a.b_acc_id order by a.b_acc_id ;

/*

+------------------+-------+----------+--------+-----------+
| b_name           | b_qty | b_acc_id | Issued | Available |
+------------------+-------+----------+--------+-----------+
| computer network |     5 |    10005 |      0 |         5 |
| Cpp              |     5 |    10002 |      3 |         2 |
| DBMS             |     5 |    10004 |      1 |         4 |
| Java             |     3 |    10001 |      2 |         1 |
| .........................................................|
+------------------+-------+----------+--------+-----------+

*/
Select a.b_name, a.b_qty, a.b_acc_id , 
	 sum(case 
		when b.status='I' then 1
		else 0
	 end) as Issued,
	 sum(case 
		when b.status='R' then 1
		else 0
	 end) as Repair,
	 sum(case 
		when b.status='A' then 1
		else 0
	 end) as Available
From tbl_book_info a left join tbl_books b on a.b_acc_id=b.accid
group by a.b_name, a.b_qty, a.b_acc_id order by a.b_acc_id ;
						OR
Select a.b_name BookName, a.b_qty BookQty, a.b_acc_id Code, sum(case  when b.status='I' then 1 else 0 end) as Issued, sum(case  when b.status='R' then 1 else 0 end) as Repair, sum(case  when b.status='A' then 1 else 0 end) as Available From tbl_book_info a left join tbl_books b on a.b_acc_id=b.accid group by a.b_name, a.b_qty, a.b_acc_id order by a.b_acc_id ;


-- --------------------------------------------------
-- This Query -.- is used when a Book was destroyed and -Book Clicked	
	
	Select a.b_acc_id Code,a.b_name BookName , a.b_type BookType , a.b_auth1 , a.b_qty BookQty ,
		sum(case when b.status='I' then 1 else 0 end) as Issued,
		sum(case  when b.status='R' then 1 else 0 end) as Repair, 
		sum(case  when b.status='D' then 1 else 0 end) as Destroyed, 
		sum(case  when b.status='A' then 1 else 0 end) as Available 
	From tbl_book_info a 
		left join tbl_books b on a.b_acc_id = b.accid 
	where a.b_acc_id = 10001
		group by a.b_name, a.b_qty, a.b_acc_id order by a.b_acc_id ;
		
	-- +-----------+-------------+---------+---------+-------+--------+--------+-----------+-----------+
	-- | BookName  | BookType    | b_auth1 | BookQty | Code  | Issued | Repair | Destroyed | Available |
	-- +-----------+-------------+---------+---------+-------+--------+--------+-----------+-----------+
	-- | Java book | Programming | lala    |       3 | 10001 |      2 |      0 |         0 |         1 |
	-- +-----------+-------------+---------+---------+-------+--------+--------+-----------+-----------+
	-- 1 row in set (0.08 sec)

mysql>		

-- --------------------------------------------------

-- To update the Table_s attribute through Concating ....

Update tbl_book_info  p cross join
       (select * from tbl_book_info where b_acc_id = 10003) arbitrary
    set p.b_about = concat(arbitrary.b_about, ' ,Member xxx lost a book')
    where p.b_acc_id = 10003;


-- Before : 	

-- +----------+-------------+-------+-------------+---------+---------+----------+---------+--------+---------+-----------+
-- | b_acc_id | b_name      | b_qty | b_type      | b_auth1 | b_auth2 | b_pub    | b_pages | b_rack | b_price | b_about   |
-- +----------+-------------+-------+-------------+---------+---------+----------+---------+--------+---------+-----------+
-- |    10003 | VB.net book |     5 | Programming | lalaji  | -       | amam co. |     479 |      3 |  100.00 | Good book |
-- +----------+-------------+-------+-------------+---------+---------+----------+---------+--------+---------+-----------+
-- 1 row in set (0.02 sec)


-- -- After :

-- +----------+-------------+-------+-------------+---------+---------+----------+---------+--------+---------+-----------------------------------+
-- | b_acc_id | b_name      | b_qty | b_type      | b_auth1 | b_auth2 | b_pub    | b_pages | b_rack | b_price | b_about                           |
-- +----------+-------------+-------+-------------+---------+---------+----------+---------+--------+---------+-----------------------------------+
-- |    10003 | VB.net book |     5 | Programming | lalaji  | -       | amam co. |     479 |      3 |  100.00 | Good book ,Member xxx lost a book |
-- +----------+-------------+-------+-------------+---------+---------+----------+---------+--------+---------+-----------------------------------+


-- CREATE TABLE tbl_mem (
	-- id int(5) auto_increment primary key,
	-- name varchar(10)
-- );
-- Alter table tbl_mem auto_increment=101;

-- insert into tbl_mem (name) values('Raja');

drop table mems ;CREATE TABLE mems (
	m_Id int(6) auto_increment primary key,
	mName varchar(25) not null,
	mPh1 varchar(12) not null,
	mPh2 varchar(12) ,
	cls varchar(10) ,
	rno int(12),
	mAddr varchar(40) not null,
	mType varchar(1) not null,
	mJoinFee decimal(6,2) not null,
	mProtectFee decimal(6,2) not null,
	mStatus varchar(1) default "A" not null,
	doj Date not null,
	doPFee Date not null	
	-- ,lostbooks int(2) not null default 0	   -- iski jarurat nhi hai Project me... table bkDel me memId Count karke bta sakte hain...
);alter table mems auto_increment 1001;

INSERT INTO mems (mName, mPh1, mPh2, mAddr, mType, mJoinFee, mProtectFee, doj) 
	VALUES( 'Shubh', '8601725056', '8601724446', 'Ram janki nagar', 'S', 100.00, 500.00,
			Date(sysdate()) );

INSERT INTO mems (mName, mPh1, mAddr, mType, mJoinFee, mProtectFee, doj) 
	VALUES( 'Kallo', '3101725056', 'Ram janki nagar', 'S', 100.00, 500.00,
			Date(sysdate()) );
			
INSERT INTO mems (mName, mPh1,  mAddr, mType, mJoinFee, mProtectFee, doj) 
	VALUES( 'Shubh', '1101725056', 'Ram janki nagar', 'S', 100.00, 500.00,
			Date(sysdate()) );

INSERT INTO mems (mName, mPh1, mPh2, mAddr, mType, mJoinFee, mProtectFee, doj) 
	VALUES( 'Shubh', '3331725056', '2221724446', 'Ram janki nagar', 'S', 100.00, 500.00,
			Date(sysdate()) );

			
Select count(*) from mems where  
(
	(INSERT into  select 'Nanu', '3331725056', '2221724446', 'Ram janki nagar', 'S', 100.00, 500.00, Date(sysdate()) )
	or 1=1
);
			
			
Select count(*) from mems where  
(
	(INSERT into mems select 'Nanu', '3331725056', '2221724446', 'Ram janki nagar', 'S', 100.00, 500.00, Date(sysdate()) )
	or 1=1
);


drop table bkTrans; create table bkTrans(
	t_id int auto_increment,									-- unique for Each Record,
	m_id int(6) not null references mems(m_id) ,				-- Member's Id
	b_acc_id int(5) not null references tbl_book_info(b_acc_id),-- Book's Accession Id
	accno int(3) not null references tbl_books(accno),			-- Book's Accession No.
	m_issDt Date not null,										-- Date of Issue
	m_propDt Date not null,										-- Proposed Date of Return
	m_actRetDt Date,											-- Actual Date of Return
	m_fine Decimal(5,2),										-- Fine Charged on Member for Delay in Returning Book
	m_delayCause varchar(40),									-- Reason - why Proposed Date is Changed
	m_nPropDt int(3),											-- Num of Days Incre. / Decre. in 'm_propDt' (e.g.: -2,1,3)
	primary key(t_id)
);

	Insert into bktrans 
	( 	
		m_id ,b_acc_id ,
		accno ,
		m_issDt ,m_propDt
	)values(
		1005, 10003,
		104,
		'2019-06-02','2019-07-03'
	);
	Insert into bktrans 
	( 	
		m_id ,b_acc_id ,
		accno ,
		m_issDt ,m_propDt
	)values(
		1002, 10004,
		102,
		'2019-3-21','2019-3-24'
	);
	Insert into bktrans 
	( 	
		m_id ,b_acc_id ,
		accno ,
		m_issDt ,m_propDt
	)values(
		1004, 10002,
		103,
		'2019-05-01','2019-06-02'
	);

	Insert into bktrans 
	( 	
		m_id ,b_acc_id ,
		accno ,
		m_issDt ,m_propDt
	)values(
		1007, 10003,
		105,
		'2019-06-26','2019-07-15'
	);
	
t_id   m_id   b_acc_id   accno   m_issDt    m_propDt    m_actRetDt    m_fine    m_delayCause    m_nPropDt

	Insert into bktrans 
	( 	
		m_id ,b_acc_id ,accno ,
		m_issDt ,m_propDt,m_actRetDt
	)values(
		1006, 10003,
		101,
		'2019-3-21','2019-3-24','2019-3-20'
	);
	
	Insert into bktrans 
	( 	
		m_id ,b_acc_id ,accno ,
		m_issDt ,m_propDt,m_actRetDt
	)values(
		1007, 10003,
		102,
		'2019-3-21','2019-3-24','2019-3-20'
	);
	
	UPDATE bktrans set m_actRetDt = '2019-7-1' where m_Id = 1003;
	
+---------------------+
| 2019-06-14 17:08:05 |
+---------------------+
1 row in set (0.00 sec)

mysql>


mysql>
insert into bktrans 
	( 	
		m_id ,
		b_acc_id ,
		accno ,
		m_issDt , 
		m_propDt ,
		m_actRetDt ,
		m_fine ,
		m_delayCause ,
		m_nPropDt 
	)
	
-- Which member had not returned How Many Books ,
Select * from mems where m_id = 1001

Select * from mems where m_id = 1001 and mStatus = 'A';

Select a.m_id , a.b_acc_id, a.accno , a.m_issDt , a.m_propDt ,
		sum(case
			when a.m_actRetDt is null then 1
			else 0
			end) as notReturned
from bktrans a GROUP BY a.M_ID;

+------+----------+-------+------------+------------+-------------+
| m_id | b_acc_id | accno | m_issDt    | m_propDt   | notReturned |
+------+----------+-------+------------+------------+-------------+
| 1002 |    10002 |   105 | 2019-07-01 | 2019-08-02 |           2 |
| 1003 |    10001 |   102 | 2019-06-02 | 2019-07-03 |           0 |
| 1004 |    10002 |   103 | 2019-05-01 | 2019-06-02 |           1 |
+------+----------+-------+------------+------------+-------------+
3 rows in set (0.00 sec)


-- ----------------------
Parts me Query karo :
-- ----------------------
-- You Know m_Id 

Maine m_id Diya > Is it Valid m_Id to Issue a book 
InValidity : 
	If m_type = 'S'tudent and notReturned > 0 Than Yes this m_Id is InValid.
	If m_type = 'T'eacher and notReturned > 1  Than Yes this m_Id is InValid.
	
Solution (


	 --If This 'm_id' is Active  than return a Record ( mid ,Name ,Type )
		Select mName,mType TypeOfMember from mems where m_id = 1001 and mStatus = 'A'; 

		*label-1
	 --Let ^ gives ( Shubhu,S )
	 --Than check How many books he Took that ... he DID NOT Returned  
		Select sum(case
					when c.m_actRetDt is null then 1
					else 0
			   end) as notReturned
		from bktrans c where m_id = 1002;
		
	 -- 		  |	notReturned |
	 --Let ^ gives|    1 		| and we know already Type Return Earlier at *label-1 is : 'S', 
	 --Than return Response if(type = 'S' and notReturned > 0 ) Than InValid M_ID
	 
	 
		Select tbla.TypeOfMember from ( Select mName,mType TypeOfMember from mems where m_id = 1001 and mStatus = 'A') tbla;

		Select a.m_id , a.b_acc_id, a.accno , a.m_issDt , a.m_propDt ,
			sum(case
				when a.m_actRetDt is null then 1
				else 0
			end) as notReturned
		from bktrans a GROUP BY a.M_ID;

		-- +--------------+
		-- | TypeOfMember |
		-- +--------------+
		-- | S            |
		-- +--------------+	 

		-- +------+----------+-------+------------+------------+-------------+
		-- | m_id | b_acc_id | accno | m_issDt    | m_propDt   | notReturned |
		-- +------+----------+-------+------------+------------+-------------+
		-- | 1001 |    10002 |   101 | 2019-06-29 | 2019-07-30 |           0 |
		-- | 1002 |    10002 |   102 | 2019-06-29 | 2019-07-30 |           0 |
		-- | 1003 |    10001 |   101 | 2019-07-01 | 2019-08-01 |           0 |
		-- +------+----------+-------+------------+------------+-------------+

	 --If This 'm_id' is Active  than return a Record ( mid ,Name ,Type )
		
);
	
	*label-1
 --Let ^ gives type ( 'S' )
 --Than check How many books he Took that ... he DID NOT Returned  
	Select sum(case
				when c.m_actRetDt is null then 1
				else 0
		   end) as notReturned
	from bktrans c where m_id = 1002;
	
 -- 		  |	notReturned |
 --Let ^ gives|    1 		| and we know already Type Return Earlier at *label-1 is : 'S', 
 --Than return Response if(type = 'S' and notReturned > 0 ) Than InValid M_ID
 
 
 
	^ Yeh mId,Type dega 'S' OR 'T'
	
	if(Type = 'S'){	-- Student Jitni bhi book RETURN NHI kiya h Return karega
	
		Select (Select a.mType from mems a 
		 where a.m_id = 1001 and a.mStatus = 'A') typeOfMem;
	
		select count(*) from bktrans 
		where m_id = given_m_id and m_actretdt is null ;
		
		^ Yeh Bataayega 'given_m_id'(Student) kitni book Jamaa nhi kiya h "AS issueButNotRet"
		
		If( issueButNotRet > 0 ) 
			ReqNotAcc	
	}	
	
..............................................................................................................

-- Jis member ne Books Return Nhi Kiya hai Uska 'M_Id,Member,TypeOfMember,BookId,Book,IssuedOn,LastDate' Return Karega
	
 Select B.m_id M_Id, C.mName Member, C.mType TypeOfMember, B.b_acc_id BookId, A.b_Name Book,
		B.m_issDt IssuedOn, B.m_propDt LastDate
 from tbl_book_info A, bktrans B, mems C where B.m_actRetDt is null and B.m_id = C.m_id
	  and B.b_acc_id = A.b_acc_id order by B.m_id;
 
+------+--------+--------------+--------+-------------+------------+------------+
| M_Id | Member | TypeOfMember | BookId | Book        | IssuedOn   | LastDate   |
+------+--------+--------------+--------+-------------+------------+------------+
| 1002 | Shubhu | T            |  10004 | DBMS        | 2019-03-21 | 2019-03-24 |
| 1002 | Shubhu | T            |  10003 | VB.net book | 2019-06-11 | 2019-07-12 |
| 1004 | Mataji | S            |  10002 | Cpp Book    | 2019-05-01 | 2019-06-02 |
+------+--------+--------------+--------+-------------+------------+------------+
3 rows in set (0.00 sec)

..............................................................................................................

-- 							Because : ALL who Didn't Return are

mysql> SELECT * from bktrans  where m_actRetDt is null order by m_id;
+------+------+----------+-------+------------+------------+------------+--------+--------------+-----------+
| t_id | m_id | b_acc_id | accno | m_issDt    | m_propDt   | m_actRetDt | m_fine | m_delayCause | m_nPropDt |
+------+------+----------+-------+------------+------------+------------+--------+--------------+-----------+
|    4 | 1002 |    10003 |   105 | 2019-06-11 | 2019-07-12 | NULL       |   NULL | NULL         |      NULL |
|    5 | 1002 |    10004 |   102 | 2019-03-21 | 2019-03-24 | NULL       |   NULL | NULL         |      NULL |
|    3 | 1004 |    10002 |   103 | 2019-05-01 | 2019-06-02 | NULL       |   NULL | NULL         |      NULL |
+------+------+----------+-------+------------+------------+------------+--------+--------------+-----------+
3 rows in set (0.00 sec)


	Select B.m_id M_Id, C.mName Member, C.mType TypeOfMember, B.b_acc_id BookId, A.b_Name Book,
	B.m_issDt IssuedOn, B.m_propDt LastDate
	from tbl_book_info A, bktrans B, mems C where B.m_id = 1001
		and B.m_actRetDt is null 
		and B.m_id = C.m_id and B.b_acc_id = A.b_acc_id order by B.m_id desc;
+------+--------+--------------+--------+-------------+------------+------------+
| M_Id | Member | TypeOfMember | BookId | Book        | IssuedOn   | LastDate   |
+------+--------+--------------+--------+-------------+------------+------------+
| 1002 | Shubhu | T            |  10003 | VB.net book | 2019-06-11 | 2019-07-12 |
| 1002 | Shubhu | T            |  10004 | DBMS        | 2019-03-21 | 2019-03-24 |
+------+--------+--------------+--------+-------------+------------+------------+

	Select  B.m_id M_Id, C.mName Member, C.mType M_Type, B.b_acc_id BookId, A.b_Name Book,
			B.m_issDt IssuedOn, B.m_propDt LastDate
	from tbl_book_info A,
		 bktrans B,
		 mems C 
	where B.m_id = 1001
		and B.m_actRetDt is null 
		and B.m_id = C.m_id and B.b_acc_id = A.b_acc_id order by B.m_id desc;
+------+--------+--------+--------+-------------+------------+------------+
| M_Id | Member | M_Type | BookId | Book        | IssuedOn   | LastDate   |
+------+--------+--------+--------+-------------+------------+------------+
| 1002 | Shubhu | T      |  10003 | VB.net book | 2019-06-11 | 2019-07-12 |
| 1002 | Shubhu | T      |  10004 | DBMS        | 2019-03-21 | 2019-03-24 |
+------+--------+--------+--------+-------------+------------+------------+


..............................................................................................................

-- Checking -.- No Books Available with this Book Id

Select * from bktrans where b_acc_id = 10003 order by m_propDt limit 1;
+------+------+----------+-------+------------+------------+------------+--------+--------------+-----------+
| t_id | m_id | b_acc_id | accno | m_issDt    | m_propDt   | m_actRetDt | m_fine | m_delayCause | m_nPropDt |
+------+------+----------+-------+------------+------------+------------+--------+--------------+-----------+
|    7 | 1003 |    10003 |   104 | 2019-06-02 | 2019-07-03 | NULL       |   NULL | NULL         |      NULL |
+------+------+----------+-------+------------+------------+------------+--------+--------------+-----------+

Select (select date_format( m_propDt ,'%b-%d,%Y')) LastDate from bktrans where b_acc_id = 10003 order by m_propDt limit 1;
+-------------+
| LastDate    |
+-------------+
| Jul-03,2019 |
+-------------+

..............................................................................................................



-- IssuePanel_D FinalSubmit --> What will Happen 

Affected Tables : 1) tbl_books
				  2) bktrans
Steps:
	1) tbl_books se Select karo 1 ACCNO whose Status = 'A' while tbl_books.accid given 
	2) tbl_books Me Update karo Status = 'I' whose  tbl_books.accid = given and tbl_books.accno = fetched Previously in step 1
	3) bktrans me Insert karo pnl_D_Labels ki 
		Attributes of Table 'bktrans': 
			t_id , m_id , b_acc_id , accno , m_issDt  
			,  m_propDt  ,  m_actRetDt , m_fine , m_delayCause , m_nPropDt 
		
		lblBk_I_D_mId , lblBk_I_D_bId , accno = fetched Prev , dbInsertableDate( lblBk_I_D_bIssDt ) 
			,  dbInsertableDate( lblBk_I_D_bRetDt ) , NULL , NULL , NULL , NULL
			
		lblBk_I_D_mNm
		lblBk_I_D_mAuth
		
		lblBk_I_D_bNm
		lblBk_I_D_bType

		lblBk_I_D_bNm2
		lblBk_I_D_mNm2
		lblBk_I_D_bIssDt
		lblBk_I_D_bRetDt

Solution:
	1) -.-
		Select accno from tbl_books where accid = 10001 and status = 'A' limit 1;
	2) -.-
		Update tbl_books set status = 'I' where accid = 10001 limit 1;
	3) -.-
		insert into bktrans ( m_id, b_acc_id, accno, m_issDt, m_propDt ) 
				value(1003,10001,101, '2019-06-23' ,'2019-07-25' );

Select accno from tbl_books where accid = 10002 limit 1;


......................................................................................................................................
														Return_Panel
														
-- Return_Panel- SubPnl_A_Next clicked : 
-- 		Take Member Id from TextBox   and   Fetch kaun kaun si book iss mem ne return nhi ki h

	Attributes of table bktrans : 
	
		t_id, m_id, b_acc_id, accno, m_issDt, m_propDt, m_actRetDt, m_fine, m_delayCause, m_nPropDt

	Attributes of table mems : 
	
		m_Id, mName, mPh1, mPh2, mAddr, mType, mJoinFee, mProtectFee, mStatus, doj, lostbooks

	Select b.m_Id m_Id, m.mName Member, m.mType MemberType , b.b_acc_id accid, b.accno accno, b.m_issDt issuedOn, 
		b.m_propDt lastDate, b.m_actRetDt ReturningDate 
	from bktrans b, mems m 
	where b.m_Id = 1002 and b.m_id = m.m_id and b.m_actRetDt is null;
									
									OR
									
	Select b.m_Id m_Id, m.mName Member, m.mType MemberType , b.b_acc_id accid, b.accno accno, b.m_issDt issuedOn, b.m_propDt lastDate, b.m_actRetDt ReturningDate from bktrans b, mems m  where b.m_Id = 1002 and b.m_id = m.m_id and b.m_actRetDt is null;
	
	o/p>
		+------+--------+------------+-------+-------+------------+------------+---------------+
		| m_Id | Member | MemberType | accid | accno | issuedOn   | lastDate   | ReturningDate |
		+------+--------+------------+-------+-------+------------+------------+---------------+
		| 1002 | Shubhu | T          | 10002 |   101 | 2019-06-21 | 2019-07-22 | NULL          |
		| 1002 | Shubhu | T          | 10002 |   102 | 2019-06-21 | 2019-07-22 | NULL          |
		+------+--------+------------+-------+-------+------------+------------+---------------+
		2 rows in set (0.00 sec)

		mysql> select * from bktrans where m_actRetDt is null order by m_id,b_acc_id,accno;
		+------+------+----------+-------+------------+------------+------------+--------+--------------+-----------+
		| t_id | m_id | b_acc_id | accno | m_issDt    | m_propDt   | m_actRetDt | m_fine | m_delayCause | m_nPropDt |
		+------+------+----------+-------+------------+------------+------------+--------+--------------+-----------+
		|   16 | 1001 |    10003 |   101 | 2019-06-21 | 2019-07-22 | NULL       |   NULL | NULL         |      NULL |
		|   20 | 1002 |    10002 |   101 | 2019-06-21 | 2019-07-22 | NULL       |   NULL | NULL         |      NULL |
		|   22 | 1002 |    10002 |   102 | 2019-06-21 | 2019-07-22 | NULL       |   NULL | NULL         |      NULL |
		|   11 | 1003 |    10001 |   102 | 2019-06-23 | 2019-07-25 | NULL       |   NULL | NULL         |      NULL |
		|    7 | 1003 |    10003 |   104 | 2019-06-02 | 2019-07-03 | NULL       |   NULL | NULL         |      NULL |
		|    3 | 1004 |    10002 |   103 | 2019-05-01 | 2019-06-02 | NULL       |   NULL | NULL         |      NULL |
		|   12 | 1007 |    10003 |   103 | 2019-06-20 | 2019-07-22 | NULL       |   NULL | NULL         |      NULL |
		|   24 | 1007 |    10003 |   105 | 2019-06-21 | 2019-07-22 | NULL       |   NULL | NULL         |      NULL |
		|   23 | 1009 |    10003 |   103 | 2019-06-21 | 2019-07-22 | NULL       |   NULL | NULL         |      NULL |
		+------+------+----------+-------+------------+------------+------------+--------+--------------+-----------+
		9 rows in set (0.07 sec)
		
		
......................................................................................................................................
Report : 
	*) To Get Details of Members who got Books with Issue Date , Last Date ,Return Date and daysLeft( or +ive Numbers of daysDelayed) : -
	
	Select b.m_Id m_Id, m.mName Member, m.mType MemberType , b.b_acc_id accid, b.accno accno, c.b_name Book,c.b_auth1 Author,
		date_format(b.m_issDt,'%b %d,%Y') issuedOn, date_format(b.m_propDt, '%b %d,%Y') lastDate, date_format(Date(sysdate()),'%b %d,%Y') 
		Today,(Case when true then ( datediff( b.m_propDt , sysdate() ) ) 
							  else 0 end ) as daysDelayed
	from bktrans b, mems m ,tbl_book_info c 
	where b.m_Id > 1000 and  b.m_Id < 1008 and b.m_id = m.m_id and b.b_acc_id = c.b_acc_id and b.m_actRetDt is null
		order by b.m_Id;

	
	+------+--------+------------+-------+-------+-----------+--------+-------------+-------------+-------------+-------------+
	| m_Id | Member | MemberType | accid | accno | Book      | Author | issuedOn    | lastDate    | Today       | daysDelayed |
	+------+--------+------------+-------+-------+-----------+--------+-------------+-------------+-------------+-------------+
	| 1001 | Lala   | S          | 10003 |   101 | Cpp 1.17  | lalaji | Jun 21,2019 | Jul 22,2019 | Jul 29,2019 |          -7 |
	| 1002 | Shubhu | T          | 10002 |   101 | Cpp Book  | Kallo  | Jun 21,2019 | Jul 22,2019 | Jul 29,2019 |          -7 |
	| 1002 | Shubhu | T          | 10002 |   102 | Cpp Book  | Kallo  | Jul 21,2019 | Aug 22,2019 | Jul 29,2019 |          24 |
	| 1003 | Mali   | T          | 10003 |   104 | Cpp 1.17  | lalaji | Jun 02,2019 | Jul 03,2019 | Jul 29,2019 |         -26 |
	| 1003 | Mali   | T          | 10001 |   102 | Java book | lala   | Jun 23,2019 | Jul 25,2019 | Jul 29,2019 |          -4 |
	| 1004 | Mataji | S          | 10002 |   103 | Cpp Book  | Kallo  | May 01,2019 | Jun 02,2019 | Jul 29,2019 |         -57 |
	| 1005 | Hitest | S          | 10003 |   103 | Cpp 1.17  | lalaji | Jul 21,2019 | Aug 22,2019 | Jul 29,2019 |          24 |
	| 1007 | Satya  | T          | 10003 |   103 | Cpp 1.17  | lalaji | Jun 20,2019 | Jul 22,2019 | Jul 29,2019 |          -7 |
	| 1007 | Satya  | T          | 10003 |   105 | Cpp 1.17  | lalaji | Jun 21,2019 | Jul 22,2019 | Jul 29,2019 |          -7 |
	+------+--------+------------+-------+-------+-----------+--------+-------------+-------------+-------------+-------------+

...........................................................................................................................

mysql> select * from tbl_book_info limit 1;
+----------+-----------+-------+-------------+---------+---------+-------+---------+--------+---------+------------------+
| b_acc_id | b_name    | b_qty | b_type      | b_auth1 | b_auth2 | b_pub | b_pages | b_rack | b_price | b_about          |
+----------+-----------+-------+-------------+---------+---------+-------+---------+--------+---------+------------------+
|    10001 | Java book |     3 | Programming | lala    | -       | kallo |     800 |      1 |  799.00 | good Coding book |
+----------+-----------+-------+-------------+---------+---------+-------+---------+--------+---------+------------------+
1 row in set (0.00 sec)

mysql> select * from tbl_books limit 1;
+-------+-------+--------+
| accid | accno | status |
+-------+-------+--------+
| 10001 |   101 | I      |
+-------+-------+--------+
1 row in set (0.00 sec)

mysql> select * from mems limit 1;
+------+-------+------------+------------+----------+-------+----------+-------------+---------+------------+-----------+
| m_Id | mName | mPh1       | mPh2       | mAddr    | mType | mJoinFee | mProtectFee | mStatus | doj        | lostbooks |
+------+-------+------------+------------+----------+-------+----------+-------------+---------+------------+-----------+
| 1001 | Lala  | 8282828282 | 9282828282 | up,India | S     |   100.00 |      500.00 | A       | 2019-06-14 |         0 |
+------+-------+------------+------------+----------+-------+----------+-------------+---------+------------+-----------+
1 row in set (0.00 sec)

mysql> select * from bktrans limit 1;
+------+------+----------+-------+------------+------------+------------+--------+--------------+-----------+
| t_id | m_id | b_acc_id | accno | m_issDt    | m_propDt   | m_actRetDt | m_fine | m_delayCause | m_nPropDt |
+------+------+----------+-------+------------+------------+------------+--------+--------------+-----------+
|    2 | 1002 |    10002 |   105 | 2019-07-01 | 2019-08-02 | 2019-07-10 |   NULL | NULL         |      NULL |
+------+------+----------+-------+------------+------------+------------+--------+--------------+-----------+
1 row in set (0.00 sec)



Select a.b_name Book ,t.b_acc_id BookId, t.accno , m.mName Member , distinct (m.m_Id M_id) ,t.m_propDt LastDate , Date_Format( '%d %b,%Y',sysdate()),
	datediff( t.m_propDt,Date(sysdate())) DiffLastToday

from tbl_book_info a, tbl_books b, mems m, bktrans t 

where t.m_id = m.m_id and t.b_acc_id = a.b_acc_id ;



------------------------------------------------ Query ------------------------------------------------

-- This query Selects MemId and cals DaysFromLastProtFee from Table mems:-

Select m_id,date(sysdate())Today,doPFee,(case
		when (datediff(Date(sysdate()),doPFee)) >= 180
		then ( abs(( 180 - datediff(Date(sysdate()),doPFee))))
		else (0)
		end)DaysFromLastProtFee
from mems order by DaysFromLastProtFee;

+------+------------+------------+---------------------+
| m_id | Today      | doPFee     | DaysFromLastProtFee |
+------+------------+------------+---------------------+
| 1004 | 2020-07-04 | 2019-08-06 |                 153 |
| 1006 | 2020-07-04 | 2019-07-15 |                 175 |
| 1005 | 2020-07-04 | 2019-07-05 |                 185 |
| 1003 | 2020-07-04 | 2019-07-01 |                 189 |
+------+------------+------------+---------------------+

-- This query Selects MemId from Upper_Selected_Tabular_Structure temp :-

select m_Id from (Select m_id,date(sysdate())Today,doPFee,(case
		when (datediff(Date(sysdate()),doPFee)) >= 180
		then ( abs(( 180 - datediff(Date(sysdate()),doPFee))))
		else (0)
		end)DaysFromLastProtFee
	from mems order by DaysFromLastProtFee) temp
where temp.DaysFromLastProtFee >=180;

+------+
| m_Id |
+------+
| 1005 |
| 1003 |
+------+

-- Updates the mStatus = 'I' of Members whose m_id is fetched...

update mems set mStatus = 'I' where m_id in (
	select m_Id from (Select m_id,date(sysdate())Today,doPFee,(case
		when (datediff(Date(sysdate()),doPFee)) >= 180
		then ( abs(( 180 - datediff(Date(sysdate()),doPFee))))
		else (0)
		end)DaysFromLastProtFee
	from mems order by DaysFromLastProtFee) temp
	where temp.DaysFromLastProtFee >=180
);



----------------------------------------------- Report -----------------------------------------------
 -- To check which Books are not Returned -
	select * from bktrans where m_actRetDt is null order by m_propDt;

+------+------+----------+-------+------------+------------+------------+--------+--------------+-----------+
| t_id | m_id | b_acc_id | accno | m_issDt    | m_propDt   | m_actRetDt | m_fine | m_delayCause | m_nPropDt |
+------+------+----------+-------+------------+------------+------------+--------+--------------+-----------+
|    6 | 1004 |    10001 |   101 | 2019-07-02 | 2019-08-02 | NULL       |   NULL | NULL         |      NULL |
|    7 | 1003 |    10001 |   102 | 2019-07-05 | 2019-08-05 | NULL       |   NULL | NULL         |      NULL |
|    5 | 1001 |    10003 |   101 | 2019-08-06 | 2019-09-06 | NULL       |   NULL | NULL         |      NULL |
+------+------+----------+-------+------------+------------+------------+--------+--------------+-----------+

 -- To check which Books are not Returned At a Date -
Query for 1-A)	At this Date = '2019-08-02'

	Select c.b_name Book, b.b_acc_id B_id, m.mName Member, b.m_Id M_Id,
			(CASE WHEN m.mType='S'
				 THEN (Select 'Stu.')
				 ELSE (Select 'Fac.')				 
				 END ) as 'Type',
			date_format(b.m_issDt,'%b %d,%y') IssuedOn, date_format(b.m_propDt, '%b %d,%y') LastDate,
			datediff(b.m_propDt,sysdate()) 'Left' ,m.mPh1 Phone
			
	from bktrans b,
		 mems m ,
		 tbl_book_info c 
	where b.m_propDt = '2019-08-02' and b.m_id = m.m_id and b.b_acc_id = c.b_acc_id and b.m_actRetDt is null
		order by b.m_Id;
		
				-- Or --
				
	Select c.b_name Book, b.b_acc_id B_id, m.mName Member, b.m_Id M_Id,(CASE WHEN m.mType='S' THEN (Select 'Stu.') ELSE (Select 'Fac.') END ) as 'Type', date_format(b.m_issDt,'%b %d,%y') IssuedOn, date_format(b.m_propDt, '%b %d,%y') LastDate, datediff(b.m_propDt,sysdate()) 'Left' ,m.mPh1 Phone  from bktrans b,mems m ,tbl_book_info c  where b.m_propDt = '2019-08-02' and b.m_id = m.m_id and b.b_acc_id = c.b_acc_id and b.m_actRetDt is null order by b.m_Id;

+-----------+-------+--------+------+------+-----------+-----------+------+------------+
| Book      | B_id  | Member | M_Id | Type | IssuedOn  | LastDate  | Left | Phone      |
+-----------+-------+--------+------+------+-----------+-----------+------+------------+
| Java book | 10001 | Jitu   | 1004 | Stu. | Jul 02,19 | Aug 02,19 |   -3 | 9879879878 |
+-----------+-------+--------+------+------+-----------+-----------+------+------------+


Query for 1-B)	After this Date = '2019-08-04'

	Select c.b_name Book, b.b_acc_id B_id, m.mName Member, b.m_Id M_Id,
			(CASE WHEN m.mType='S'
				 THEN (Select 'Stu.')
				 ELSE (Select 'Fac.')				 
				 END ) as 'Type',
			date_format(b.m_issDt,'%b %d,%y') IssuedOn, date_format(b.m_propDt, '%b %d,%y') LastDate,
			datediff(b.m_propDt,sysdate()) 'Left' ,m.mPh1 Phone 
	from bktrans b,
		 mems m ,
		 tbl_book_info c 
	where b.m_propDt > '2019-08-04' and b.m_id = m.m_id and b.b_acc_id = c.b_acc_id and b.m_actRetDt is null
		order by b.m_Id;
	
	-------------------------- OR --------------------------
	
	Select c.b_name Book, b.b_acc_id B_id, m.mName Member, b.m_Id M_Id,(CASE WHEN m.mType='S' THEN (Select 'Stu.') ELSE (Select 'Fac.') END ) as 'Type', date_format(b.m_issDt,'%b %d,%y') IssuedOn, date_format(b.m_propDt, '%b %d,%y') LastDate, datediff(b.m_propDt,sysdate()) 'Left' ,m.mPh1 Phone  from bktrans b,mems m ,tbl_book_info c  where b.m_propDt > '2019-08-04' and b.m_id = m.m_id and b.b_acc_id = c.b_acc_id and b.m_actRetDt is null order by b.m_Id;

+-----------+-------+---------+------+------+-----------+-----------+------+------------+
| Book      | B_id  | Member  | M_Id | Type | IssuedOn  | LastDate  | Left | Phone      |
+-----------+-------+---------+------+------+-----------+-----------+------+------------+
| Cpp 1.17  | 10003 | Shubham | 1001 | Stu. | Aug 06,19 | Sep 06,19 |   32 | 8601725056 |
| Java book | 10001 | Satya   | 1002 | Fac. | Jul 08,19 | Aug 08,19 |    3 | 8787878787 |
| Java book | 10001 | Hitest  | 1003 | Stu. | Jul 05,19 | Aug 05,19 |    0 | 8787878777 |
| Cpp Book  | 10002 | Sonal   | 1005 | Stu. | Jul 05,19 | Aug 05,19 |    0 | 2342342342 |
| Cpp 1.17  | 10003 | Mina    | 1006 | Stu. | Jul 15,19 | Aug 15,19 |   10 | 9898989898 |
+-----------+-------+---------+------+------+-----------+-----------+------+------------+




----------------- List of Members whose membership expires...[6 month max.(180 days)] ------------------
Query for 2-A)	At this Date = '2019-12-28'

-- Iss Date par, Jitne bhi Members ke MemShip Expire ho Rhe hai , Show Karo ...
Test Cases: 1) Given Date  >  DateOf_LastPaid

Select m_id 'M.Id',mname 'Member', mPh1 'Contact No',(CASE WHEN mType='S' THEN (Select 'Stu.') ELSE (Select 'Fac.') END ) as 'Type',date_format(doPFee, '%b %d,%y') 'Last Paid',date_format(( Date_Add(doPFee, Interval 180 day)), '%b %d,%y') 'Expire On' ,datediff( Date_Add(doPFee, Interval 180 day),Date(sysdate())) 'Left' from mems  where  m_id in (select m_id  from (SELECT m_id, (case when (date_add( Inn.doPFee ,interval 180 day) = '2019-12-26') then 1 else 0 end ) isExpire from mems Inn ) temp where temp.isExpire = 1 );

---------------------- OR ----------------------

Select m_id 'M.Id',mname 'Member', mPh1 'Contact No',(CASE WHEN mType='S' THEN (Select 'Stu.') ELSE (Select 'Fac.') END ) as 'Type',date_format(doPFee, '%b %d,%y') 'Last Paid',date_format(( Date_Add(doPFee, Interval 180 day)), '%b %d,%y') 'Expire On'
	,datediff( Date_Add(doPFee, Interval 180 day),Date(sysdate())) 'Left'
from mems 
where 
m_id in (select m_id 
		 from (SELECT m_id,
					(case when (date_add( Inn.doPFee ,interval 180 day) = '2019-12-26')	-- Iss Date ko 2019-12-26
					  then 1
					  else 0
					  end
					) isExpire
			   from mems Inn
			   ) temp
		where temp.isExpire = 1
		); -- _____ Checking whose MemShip Expires on '2019-12-26'
+------+---------+------------+------+-----------+-----------+------+
| M.Id | Member  | Contact No | Type | Last Paid | Expire On | Left |
+------+---------+------------+------+-----------+-----------+------+
| 1001 | Shubham | 8601725056 | Stu. | Jun 29,19 | Dec 26,19 |   24 |
| 1002 | Satya   | 8787878787 | Fac. | Jun 29,19 | Dec 26,19 |   24 |
+------+---------+------------+------+-----------+-----------+------+

Query for 2-B)	Before this Date = '2019-12-28';

Select m_id 'M.Id',mname 'Member', mPh1 'Contact No',(CASE WHEN mType='S' THEN (Select 'Stu.') ELSE (Select 'Fac.') END ) as 'Type',date_format(doPFee, '%b %d,%y') 'Last Paid',
	date_format(( Date_Add(doPFee, Interval 180 day)), '%b %d,%y') 'Expire On' ,
	datediff( Date_Add(doPFee, Interval 180 day),Date(sysdate())) 'Left'
from mems m
where 
m_id in (select m_id 
		 from (SELECT m_id,
					(case when (date_add( Inn.doPFee ,interval 180 day) < '2019-12-31')	-- Iss Date ke Before 2019-12-31
					  then 1
					  else 0
					  end
					) isExpire
			   from mems Inn
			   ) temp
		where temp.isExpire = 1
		); -- _____ Checking whose MemShip Expires before '2019-12-31'

+------+---------+------------+------+-----------+-----------+------+
| M.Id | Member  | Contact No | Type | Last Paid | Expire On | Left |
+------+---------+------------+------+-----------+-----------+------+
| 1001 | Shubham | 8601725056 | Stu. | Jun 29,19 | Dec 26,19 |   24 |
| 1002 | Satya   | 8787878787 | Fac. | Jun 29,19 | Dec 26,19 |   24 |
| 1003 | Hitest  | 8787878777 | Stu. | Jul 01,19 | Dec 28,19 |   26 |
+------+---------+------------+------+-----------+-----------+------+


2-A)

	Select m_id 'M.Id',mname 'Member', mPh1 'Contact No',(CASE WHEN mType='S' THEN (Select 'Stu.') ELSE (Select 'Fac.') END ) as 'Type',date_format(doPFee, '%b %d,%y') 'Last Paid',date_format(( Date_Add(doPFee, Interval 180 day)), '%b %d,%y') 'Expire On' ,datediff( Date_Add(doPFee, Interval 180 day),Date(sysdate())) 'Left' from mems  where  m_id in (select m_id  from (SELECT m_id, (case when (date_add( Inn.doPFee ,interval 180 day) = '2019-12-26') then 1 else 0 end ) isExpire from mems Inn ) temp where temp.isExpire = 1) order by mname;


2-B) ORDER BY PE KAAM KARO
if(Combo_B4_A_date.isSelected() && Sort_By_Name.isSelected())	

	Select m_id 'M.Id',mname 'Member', mPh1 'Contact No',(CASE WHEN mType='S' THEN (Select 'Stu.') ELSE (Select 'Fac.') END ) as 'Type',date_format(doPFee, '%b %d,%y') 'Last Paid', date_format(( Date_Add(doPFee, Interval 180 day)), '%b %d,%y') 'Expire On' , datediff( Date_Add(doPFee, Interval 180 day),Date(sysdate())) DaysLeft from mems where m_id in (select m_id from (SELECT m_id, (case when (date_add( Inn.doPFee ,interval 180 day) < '2019-12-31') then 1 else 0 end ) isExpire from mems Inn ) temp where temp.isExpire = 1 ) order by mname;

else if(Combo_B4_A_date.isSelected() && Sort_By_DaysLeft ){

	Select m_id 'M.Id',mname 'Member', mPh1 'Contact No',(CASE WHEN mType='S' THEN (Select 'Stu.') ELSE (Select 'Fac.') END ) as 'Type',date_format(doPFee, '%b %d,%y') 'Last Paid', date_format(( Date_Add(doPFee, Interval 180 day)), '%b %d,%y') 'Expire On' , datediff( Date_Add(doPFee, Interval 180 day),Date(sysdate())) DaysLeft from mems where m_id in (select m_id from (SELECT m_id, (case when (date_add( Inn.doPFee ,interval 180 day) < '2019-12-31') then 1 else 0 end ) isExpire from mems Inn ) temp where temp.isExpire = 1 ) order by DaysLeft;
}



================================================ Report 3 ==================================================

Report : 3)

	Select Criteria  -  0
	Active Students  -  1
	Active Teachers  -  2
	Active Members   -  3
	Inactive Student -  4
	Inactive Teacher -  5
	Inactive Member  -  6
	All Members      -  7

-- (*) All Data in Mems table : 
 select  m_Id,mName,mPh1,mAddr,mType ,mJoinFee ,mProtectFee ,mStatus ,doj,doPFee,Cls,rno from mems ;
+------+---------+------------+------------+-------+----------+-------------+---------+------------+------------+--------+------+
| m_Id | mName   | mPh1       | mAddr      | mType | mJoinFee | mProtectFee | mStatus | doj        | doPFee     | Cls    | rno  |
+------+---------+------------+------------+-------+----------+-------------+---------+------------+------------+--------+------+
| 1001 | Shubham | 8601725056 | Ramjanki   | S     |   100.00 |      500.00 | I       | 2019-06-29 | 2019-06-29 | BCA    |    1 |
| 1002 | Satya   | 8787878787 | Rail bihar | T     |   100.00 |      500.00 | A       | 2019-06-29 | 2019-06-29 | NULL   |    0 |
| 1003 | Hitest  | 8787878777 | Madras     | S     |   100.00 |      500.00 | I       | 2019-07-01 | 2019-07-01 | BA     |    3 |
| 1004 | Jitu    | 9879879878 | Boharapur  | S     |   100.00 |      500.00 | A       | 2019-08-06 | 2019-08-06 | BCA    |    4 |
| 1005 | Sonal   | 2342342342 | Banguluru  | S     |   100.00 |      500.00 | I       | 2019-07-05 | 2019-07-05 | B.Tech |    3 |
| 1006 | Mina    | 9898989898 | Hinsaran   | S     |   100.00 |      500.00 | A       | 2019-07-15 | 2019-07-15 | BCA    |    8 |
| 1007 | Rohit   | 9879879878 | Padri      | S     |   100.00 |      500.00 | A       | 2019-07-15 | 2019-07-15 | MBA    |    1 |
+------+---------+------------+------------+-------+----------+-------------+---------+------------+------------+--------+------+
7 rows in set (0.00 sec)

mysql>
	
	
-- 3: Active Members : Name vise


Select  M_id, Mname, 
	   (case when cls is null then "-" else cls end) cls,
	   (case when rno = 0 then "-" else rno end) rno,
 	    mPh1, mAddr, doj 
from mems
where mstatus = 'A' order by mtype, Mname;

+------+-------+------+------+------------+------------+------------+
| M_id | Mname | cls  | rno  | mPh1       | mAddr      | doj        |
+------+-------+------+------+------------+------------+------------+
| 1004 | Jitu  | BCA  | 4    | 9879879878 | Boharapur  | 2019-08-06 |
| 1006 | Mina  | BCA  | 8    | 9898989898 | Hinsaran   | 2019-07-15 |
| 1007 | Rohit | MBA  | 1    | 9879879878 | Padri      | 2019-07-15 |
| 1002 | Satya | -    | -    | 8787878787 | Rail bihar | 2019-06-29 |
+------+-------+------+------+------------+------------+------------+


-- Active Members : Class vise

Select  M_id, Mname, 
	   (case when cls is null then "-" else cls end) cls,
	   (case when rno = 0 then "-" else rno end) rno,
 	    mPh1, mAddr, doj 
from mems
where mstatus = 'A' order by mtype, cls, rno;

+------+-------+------+------+------------+------------+------------+
| M_id | Mname | cls  | rno  | mPh1       | mAddr      | doj        |
+------+-------+------+------+------------+------------+------------+
| 1004 | Jitu  | BCA  | 4    | 9879879878 | Boharapur  | 2019-08-06 |
| 1006 | Mina  | BCA  | 8    | 9898989898 | Hinsaran   | 2019-07-15 |
| 1007 | Rohit | MBA  | 1    | 9879879878 | Padri      | 2019-07-15 |
| 1002 | Satya | -    | -    | 8787878787 | Rail bihar | 2019-06-29 |
+------+-------+------+------+------------+------------+------------+



-- 4: Inactive Students :-

-- Final :  

Select m.M_id, m.Mname, m.cls, m.rno, m.mPh1, m.doj,
  (case when ((Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1) is null )
	then  (Select b.m_issDt from bktrans b where b.m_id = m.m_Id )	-- Tries to get Last book Returned date (but if it is null) 
	else  (Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1) -- it will fetch the Issue date
  end) 'LastSeen'
from mems m
where mType='S' and mStatus='I' 
order by cls;

+------+---------+--------+------+------------+------------+------------+
| M_id | Mname   | cls    | rno  | mPh1       | doj        | LastSeen   |
+------+---------+--------+------+------------+------------+------------+
| 1005 | Sonal   | B.Tech |    3 | 2342342342 | 2019-07-05 | 2019-07-05 |
| 1003 | Hitest  | BA     |    3 | 8787878777 | 2019-07-01 | 2019-08-05 |
| 1001 | Shubham | BCA    |    1 | 8601725056 | 2019-06-29 | 2019-07-31 |
+------+---------+--------+------+------------+------------+------------+

--														Steps 

-- Select M_id, Mname, cls,rno, mPh1, doj ,('2019-06-29') 'Last Seen' from mems where mType='S' and mStatus='I' order by cls;
-- +------+---------+--------+------+------------+------------+------------+
-- | M_id | Mname   | cls    | rno  | mPh1       | doj        | Last Seen  |
-- +------+---------+--------+------+------------+------------+------------+
-- | 1005 | Sonal   | B.Tech |    3 | 2342342342 | 2019-07-05 | 2019-06-29 |
-- | 1003 | Hitest  | BA     |    3 | 8787878777 | 2019-07-01 | 2019-06-29 |
-- | 1001 | Shubham | BCA    |    1 | 8601725056 | 2019-06-29 | 2019-06-29 |
-- +------+---------+--------+------+------------+------------+------------+

	------------ OR ----------------

-- Select m.M_id, m.Mname, m.cls, m.rno, m.mPh1, m.doj,
		-- (Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1) 'LastSeen'
-- from mems m
-- where mType='S' and mStatus='I' 
-- order by cls; 

-- +------+---------+--------+------+------------+------------+------------+
-- | M_id | Mname   | cls    | rno  | mPh1       | doj        | LastSeen   |
-- +------+---------+--------+------+------------+------------+------------+
-- | 1005 | Sonal   | B.Tech |    3 | 2342342342 | 2019-07-05 | 2019-07-05 |
-- | 1003 | Hitest  | BA     |    3 | 8787878777 | 2019-07-01 | 2019-07-01 |
-- | 1001 | Shubham | BCA    |    1 | 8601725056 | 2019-06-29 | 2019-06-29 |
-- +------+---------+--------+------+------------+------------+------------+

	------------ OR ----------------

-- Select m.M_id, m.Mname, m.cls, m.rno, m.mPh1, m.doj,
	-- (Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1) 'LastSeen'
-- from mems m
-- where mType='S' and mStatus='I' 
-- order by cls; 

-- +------+---------+--------+------+------------+------------+------------+
-- | M_id | Mname   | cls    | rno  | mPh1       | doj        | LastSeen   |
-- +------+---------+--------+------+------------+------------+------------+
-- | 1005 | Sonal   | B.Tech |    3 | 2342342342 | 2019-07-05 | NULL       |
-- | 1003 | Hitest  | BA     |    3 | 8787878777 | 2019-07-01 | 2019-08-05 |
-- | 1001 | Shubham | BCA    |    1 | 8601725056 | 2019-06-29 | 2019-07-31 |
-- +------+---------+--------+------+------------+------------+------------+

Final : --------- OR ----------------

Select m.M_id, m.Mname, m.cls, m.rno, m.mPh1, m.doj,
  (case when ((Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1) is null )
	then  (Select b.m_issDt from bktrans b where b.m_id = m.m_Id )	-- Tries to get Last book Returned date (but if it is null) 
	else  (Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1) -- it will fetch the Issue date
  end) 'LastSeen'
from mems m
where mType='S' and mStatus='I' 
order by cls;

+------+---------+--------+------+------------+------------+------------+
| M_id | Mname   | cls    | rno  | mPh1       | doj        | LastSeen   |
+------+---------+--------+------+------------+------------+------------+
| 1005 | Sonal   | B.Tech |    3 | 2342342342 | 2019-07-05 | 2019-07-05 |
| 1003 | Hitest  | BA     |    3 | 8787878777 | 2019-07-01 | 2019-08-05 |
| 1001 | Shubham | BCA    |    1 | 8601725056 | 2019-06-29 | 2019-07-31 |
+------+---------+--------+------+------------+------------+------------+

=================================================== Debugging Student ============================================

-- Inactive Students :-

-- SELECT m_Id,mName,mPh1,mAddr,mType ,mStatus ,doj,doPFee,Cls,rno from mems where mStatus='I' order by mStatus;
											Members
-- +------+---------+------------+------------+-------+---------+------------+------------+--------+------+
-- | m_Id | mName   | mPh1       | mAddr      | mType | mStatus | doj        | doPFee     | Cls    | rno  |
-- +------+---------+------------+------------+-------+---------+------------+------------+--------+------+
-- | 1001 | Shubham | 8601725056 | Ramjanki   | S     | I       | 2019-06-29 | 2019-06-29 | BCA    |    1 |
-- | 1003 | Hitest  | 8787878777 | Madras     | S     | I       | 2019-07-01 | 2019-07-01 | BA     |    3 |
-- | 1005 | Sonal   | 2342342342 | Banguluru  | S     | I       | 2019-07-05 | 2019-07-05 | B.Tech |    3 |
-- +------+---------+------------+------------+-------+---------+------------+------------+--------+------+
										    bktrans
-- SELECT m_Id, m_issDt, m_propDt, m_actRetDt from bktrans where m_id in (1005,1003,1001);
-- +------+------------+------------+------------+
-- | m_Id | m_issDt    | m_propDt   | m_actRetDt |
-- +------+------------+------------+------------+
-- | 1001 | 2019-06-29 | 2019-07-30 | 2019-07-31 |
-- | 1003 | 2019-07-01 | 2019-08-01 | 2019-08-05 |
-- | 1001 | 2019-08-06 | 2019-09-06 | NULL       |
-- | 1003 | 2019-07-05 | 2019-08-05 | 2019-07-19 |
-- | 1005 | 2019-07-05 | 2019-08-05 | NULL       |
-- +------+------------+------------+------------+

-- +------+---------+--------+------+------------+------------+------------+
-- | M_id | Mname   | cls    | rno  | mPh1       | doj        | LastSeen   |
-- +------+---------+--------+------+------------+------------+------------+
-- | 1005 | Sonal   | B.Tech |    3 | 2342342342 | 2019-07-05 | 2019-07-05 |
-- | 1003 | Hitest  | BA     |    3 | 8787878777 | 2019-07-01 | 2019-08-05 |
-- | 1001 | Shubham | BCA    |    1 | 8601725056 | 2019-06-29 | 2019-07-31 |
-- +------+---------+--------+------+------------+------------+------------+

-- demo : 

-- +------+---------+--------+------+------------+------------+------------+
-- | M_id | Mname   | cls    | rno  | mPh1       | doj        | LastSeen   |
-- +------+---------+--------+------+------------+------------+------------+
-- | 1005 | Sonal   | B.Tech |    3 | 2342342342 | 2019-07-05 | NULL       |
-- | 1003 | Hitest  | BA     |    3 | 8787878777 | 2019-07-01 | 2019-08-05 |
-- | 1001 | Shubham | BCA    |    1 | 8601725056 | 2019-06-29 | 2019-07-31 |
-- +------+---------+--------+------+------------+------------+------------+

-- 5) Inactive Teachers : -

Select m.M_id, m.Mname, m.mPh1, m.doj,
  (case when ((Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1) is null )
	then  (Select b.m_issDt from bktrans b where b.m_id = m.m_Id )			 -- it will fetch the ISSUE DATE
	else  (Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1) -- Tries to get Last BOOK RETURNED DATE (but if it is null)
  end) 'LastSeen'
from mems m
where mType='T' and mStatus='I' 
order by mname;




-- ===================== Debug 5) Inactive Teachers ========================= --

 -- SELECT * FROM bktrans WHERE m_id in (1002,1008) order by m_actRetDt;	-- as of now only 1002,1008 are teacher in all mems;
-- +------+------+----------+-------+------------+------------+------------+--------+--------------+-----------+
-- | t_id | m_id | b_acc_id | accno | m_issDt    | m_propDt   | m_actRetDt | m_fine | m_delayCause | m_nPropDt |
-- +------+------+----------+-------+------------+------------+------------+--------+--------------+-----------+
-- |   11 | 1008 |    10002 |   102 | 2019-07-19 | 2019-08-19 | NULL       |   NULL | NULL         |      NULL |
-- |    9 | 1002 |    10001 |   103 | 2019-07-08 | 2019-08-08 | 2019-07-19 |   NULL | NULL         |      NULL |
-- |    2 | 1002 |    10002 |   102 | 2019-06-29 | 2019-07-30 | 2019-07-31 |   NULL | NULL         |      NULL |
-- |    3 | 1002 |    10001 |   101 | 2019-06-29 | 2019-07-30 | 2019-07-31 |   NULL | NULL         |      NULL |
-- +------+------+----------+-------+------------+------------+------------+--------+--------------+-----------+
-- 4 rows in set (0.00 sec)

 -- select * from mems where m_id in (1002,1008);
-- +------+-------+------------+------+-------------+-------+----------+-------------+---------+------------+------------+-----------+------+------+
-- | m_Id | mName | mPh1       | mPh2 | mAddr       | mType | mJoinFee | mProtectFee | mStatus | doj        | doPFee     | lostbooks | Cls  | rno  |
-- +------+-------+------------+------+-------------+-------+----------+-------------+---------+------------+------------+-----------+------+------+
-- | 1002 | Satya | 8787878787 |      | Rail bihar  | T     |   100.00 |      500.00 | I       | 2019-06-29 | 2019-06-29 |         0 | NULL |    0 |
-- | 1008 | shubh | 9898989898 |      | bihar,patna | T     |   100.00 |      500.00 | I       | 2019-07-19 | 2019-07-19 |         0 | NULL |    0 |
-- +------+-------+------------+------+-------------+-------+----------+-------------+---------+------------+------------+-----------+------+------+

-- yaa toh TEACHER kaa LATEST BOOK_RETURN_DATE return kare yaa  LATEST BOOK_ISSUE_DATE ...

-- Select m.M_id, m.Mname, m.mPh1, m.doj,
  -- (case when ((Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1) is null )
	-- then  (Select b.m_issDt from bktrans b where b.m_id = m.m_Id )			 -- it will fetch the ISSUE DATE
	-- else  (Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1) -- Tries to get Last BOOK RETURNED DATE (but if it is null)
  -- end) 'LastSeen'
-- from mems m
-- where mType='T' and mStatus='I' 
-- order by mname;

-- +------+-------+------------+------------+------------+
-- | M_id | Mname | mPh1       | doj        | LastSeen   |
-- +------+-------+------------+------------+------------+
-- | 1002 | Satya | 8787878787 | 2019-06-29 | 2019-07-31 |
-- | 1008 | shubh | 9898989898 | 2019-07-19 | 2019-07-19 |
-- +------+-------+------------+------------+------------+

=========================================================== End Debugging ===========================================================

-- 6) Inactive Members :-

Select m.M_id, m.Mname, 
  (case when cls is null then "-" else cls end) cls,
  (case when rno = 0 then "-" else rno end) rno,
  (CASE WHEN mType='S' THEN (Select 'Stu.') ELSE (Select 'Fac.') END ) as 'Type',
   m.mPh1, m.doj,  
  (case when ((Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1) is null )
	then  (Select b.m_issDt from bktrans b where b.m_id = m.m_Id )			 -- it will fetch the ISSUE DATE
	else  (Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1) -- Tries to get Last BOOK RETURNED DATE (but if it is null)
  end) 'LastSeen'
from mems m
where mStatus='I' 
order by mtype , mname;

+------+---------+--------+------+------+------------+------------+------------+
| M_id | Mname   | cls    | rno  | Type | mPh1       | doj        | LastSeen   |
+------+---------+--------+------+------+------------+------------+------------+
| 1003 | Hitest  | BA     | 3    | Stu. | 8787878777 | 2019-07-01 | 2019-08-05 |
| 1001 | Shubham | BCA    | 1    | Stu. | 8601725056 | 2019-06-29 | 2019-07-31 |
| 1005 | Sonal   | B.Tech | 3    | Stu. | 2342342342 | 2019-07-05 | 2019-07-05 |
| 1002 | Satya   | -      | -    | Fac. | 8787878787 | 2019-06-29 | 2019-07-31 |
| 1008 | shubh   | -      | -    | Fac. | 9898989898 | 2019-07-19 | 2019-07-19 |
+------+---------+--------+------+------+------------+------------+------------+



-- 7) All Members :-

Select m.M_id, m.Mname, 
  (CASE when cls is null then "-" else cls end) cls,
  (CASE when rno = 0 then "-" else rno end) rno,
  (CASE WHEN mType='S' THEN (Select 'Stu.') ELSE (Select 'Fac.') END ) as 'Type',
   m.mPh1 Ph1,  
   m.doj,  
  DATE_FORMAT(	-- Multiple cases :
  (CASE When ((Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1) is not null ) 
			THEN( Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1 ) -- Tries to get Last BOOK RETURNED DATE in TBL_Bktrans (but if it is null)
		WHEN ((Select b.m_issDt from bktrans b where b.m_id = m.m_Id ) IS not NULL )
			THEN ( Select b.m_issDt from bktrans b where b.m_id = m.m_Id ) -- Tries to get Last BOOK Issued DATE in TBL_Bktrans( but if not took any book)
		ELSE (Select m2.doj from mems m2 where m2.m_id = m.m_Id )		-- Tries to get Date of Joining of member in TBL_mems
  END),'%d %b,%y') 'LastSeen'
FROM mems m
ORDER BY mtype , m_id;

+------+---------+--------+------+------+------------+------------+-----------+
| M_id | Mname   | cls    | rno  | Type | Ph1        | doj        | LastSeen  |
+------+---------+--------+------+------+------------+------------+-----------+
| 1001 | Shubham | BCA    | 1    | Stu. | 8601725056 | 2019-06-29 | 31 Jul,19 |
| 1007 | Rohit   | MBA    | 1    | Stu. | 9879879878 | 2019-07-15 | 15 Jul,19 |
| 1002 | Satya   | -      | -    | Fac. | 8787878787 | 2019-06-29 | 31 Jul,19 |
| 1008 | shubh   | -      | -    | Fac. | 9898989898 | 2019-07-19 | 19 Jul,19 |
+------+---------+--------+------+------+------------+------------+-----------+


=================================================================================================================================
====================================================== Summary of Report 3 ======================================================
=================================================================================================================================

select  m_Id,mName,mPh1,mAddr,mType ,mJoinFee ,mProtectFee ,mStatus ,doj,doPFee,Cls,rno from mems ;
+------+---------+------------+-------------+-------+----------+-------------+---------+------------+------------+--------+------+
| m_Id | mName   | mPh1       | mAddr       | mType | mJoinFee | mProtectFee | mStatus | doj        | doPFee     | Cls    | rno  |
+------+---------+------------+-------------+-------+----------+-------------+---------+------------+------------+--------+------+
| 1001 | Shubham | 8601725056 | Ramjanki    | S     |   100.00 |      500.00 | I       | 2019-06-29 | 2019-06-29 | BCA    |    1 |
| 1002 | Satya   | 8787878787 | Rail bihar  | T     |   100.00 |      500.00 | I       | 2019-06-29 | 2019-06-29 | NULL   |    0 |
| 1003 | Hitest  | 8787878777 | Madras      | S     |   100.00 |      500.00 | I       | 2019-07-01 | 2019-07-01 | BA     |    3 |
| 1004 | Jitu    | 9879879878 | Boharapur   | S     |   100.00 |      500.00 | A       | 2019-08-06 | 2019-08-06 | BCA    |    4 |
| 1005 | Sonal   | 2342342342 | Banguluru   | S     |   100.00 |      500.00 | I       | 2019-07-05 | 2019-07-05 | B.Tech |    3 |
| 1006 | Mina    | 9898989898 | Hinsaran    | S     |   100.00 |      500.00 | A       | 2019-07-15 | 2019-07-15 | BCA    |    8 |
| 1007 | Rohit   | 9879879878 | Padri       | S     |   100.00 |      500.00 | A       | 2019-07-15 | 2019-07-15 | MBA    |    1 |
| 1008 | shubh   | 9898989898 | bihar,patna | T     |   100.00 |      500.00 | I       | 2019-07-19 | 2019-07-19 | NULL   |    0 |
+------+---------+------------+-------------+-------+----------+-------------+---------+------------+------------+--------+------+

			
mysql> -- 1: Active Student 
	Select  M_id, Mname, 
		(case when cls is null then "-" else cls end) cls, 
		(case when rno = 0 then "-" else rno end) rno, 
		 mPh1, mAddr, 
		(CASE 
			When ((Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1) is not null ) 
			THEN( Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1 ) -- Tries to get Latest BOOK RETURNED DATE in TBL_Bktrans (but if it is null)
			WHEN ((Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1) IS not NULL ) 
			THEN ( Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1 ) -- Tries to get Latest BOOK ISSUED DATE in TBL_Bktrans( but if not took any book)
			ELSE (Select m2.doj from mems m2 where m2.m_id = m.m_Id limit 1) -- Tries to get Date of Joining of member in TBL_mems
		END) LastSeen from mems m 
	where mstatus = 'A' and mtype='S' 
	
	order by mtype,LastSeen desc ;

+------+-------+------+------+------------+-----------+-----------+
| M_id | Mname | cls  | rno  | mPh1       | mAddr     | LastSeen  |
+------+-------+------+------+------------+-----------+-----------+
| 1004 | Jitu  | BCA  | 4    | 9879879878 | Boharapur | 2019-01-01|
| 1006 | Mina  | BCA  | 8    | 9898989898 | Hinsaran  | 2019-03-01|
| 1007 | Rohit | MBA  | 1    | 9879879878 | Padri     | 2019-04-21|
+------+-------+------+------+------------+-----------+-----------+

mysql> -- 2: Active Teacher : Name vise
	Select  M_id, Mname,
		mPh1,
		(case when mPh2 is null then "  -" 
			  else mPh2
 		 end) Ph2, 
		mAddr, 
		(CASE 
			When ((Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1) is not null )
			THEN( Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1 ) -- Tries to get Latest BOOK RETURNED DATE in TBL_Bktrans (but if it is null)
			WHEN ((Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1) IS not NULL )
			THEN ( Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1) -- Tries to get Latest BOOK ISSUED DATE in TBL_Bktrans( but if not took any book)
			ELSE (Select m2.doj from mems m2 where m2.m_id = m.m_Id limit 1)-- Tries to get Date of Joining of member in TBL_mems
		END) LastSeen 
	from mems m
	where mtype='T' and mstatus = 'A' 
	
	order by mtype,LastSeen desc ;

+------+-----------+------------+------------+-------------+-----------+
| M_id | Mname     | mPh1       | Ph2        | mAddr       | LastSeen  |
+------+-----------+------------+------------+-------------+-----------+
| 1010 | Bhatt     | 9879879878 |   -        | basharatpur | 09 Jul,19 |
| 1009 | Priyanshi | 8787878787 | 7676767676 | Bazaar      | 25 Jun,19 |
+------+-----------+------------+------------+-------------+-----------+


mysql> -- 3: Active Members : Class vise

	Select  M_id, Mname,
		(case when cls is null then "-" else cls end) cls,
		(case when rno = 0 then "-" else rno end) rno,
		(CASE WHEN mType='S' THEN (Select 'Stu.') ELSE (Select 'Fac.') END ) as 'Type',
		 mPh1, mAddr, 		
		(CASE 
			When ((Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1) is not null )
			THEN( Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1 ) -- Tries to get Latest BOOK RETURNED DATE in TBL_Bktrans (but if it is null)
			WHEN ((Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1) IS not NULL)
			THEN ( Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1) -- Tries to get Latest BOOK ISSUED DATE in TBL_Bktrans( but if not took any book)
			ELSE (Select m2.doj from mems m2 where m2.m_id = m.m_Id limit 1)-- Tries to get Date of Joining of member in TBL_mems
		END) LastSeen 
	from mems m
	where mstatus = 'A' 
	
	order by mType,LastSeen desc;

+------+-----------+------+------+------+------------+-------------+-----------+
| M_id | Mname     | cls  | rno  | Type | mPh1       | mAddr       | LastSeen  |
+------+-----------+------+------+------+------------+-------------+-----------+
| 1004 | Jitu      | BCA  | 4    | Stu. | 9879879878 | Boharapur   | 02 Jul,19 |
| 1007 | Rohit     | MBA  | 1    | Stu. | 9879879878 | Padri       | 15 Jul,19 |
| 1008 | shubh     | -    | -    | Fac. | 9898989898 | bihar,patna | 19 Jul,19 |
| 1009 | Priyanshi | -    | -    | Fac. | 8787878787 | Bazaar      | 25 Jun,19 |
+------+-----------+------+------+------+------------+-------------+-----------+


mysql> -- 4: Inactive Students :-


	Select m.M_id, m.Mname, m.cls, m.rno, m.mPh1, m.doj, m.mProtectFee 'P.F.' ,
		(CASE When ((Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1) is not null )
			THEN( Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1 ) -- Tries to get Latest BOOK RETURNED DATE in TBL_Bktrans (but if it is null)
			WHEN ((Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1) IS not NULL)
			THEN ( Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1) -- Tries to get Latest BOOK ISSUED DATE in TBL_Bktrans( but if not took any book)
			ELSE (Select m2.doj from mems m2 where m2.m_id = m.m_Id limit 1)-- Tries to get Date of Joining of member in TBL_mems
		END) LastSeen
	from mems m
	where mType='S' and mStatus='I' 
	
	order by LastSeen desc;
	-- ____________4: Inactive Students____________
	
+------+---------+--------+------+------------+------------+--------+------------+
| M_id | Mname   | cls    | rno  | mPh1       | doj        | P.F.   | LastSeen   |
+------+---------+--------+------+------------+------------+--------+------------+
| 1005 | Sonal   | B.Tech |    3 | 2342342342 | 2019-07-05 | 500.00 | 2019-07-05 |
| 1003 | Hitest  | BA     |    3 | 8787878777 | 2019-07-01 | 500.00 | 2019-08-05 |
| 1001 | Shubham | BCA    |    1 | 8601725056 | 2019-06-29 | 500.00 | 2019-07-31 |
+------+---------+--------+------+------------+------------+--------+------------+


		-- 5) Inactive Teachers : -
	
	Select m.M_id, m.Mname, m.mPh1, m.doj,	m.mProtectFee 'P.F.' ,
		(CASE When ((Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1) is not null )
			THEN( Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1 ) -- Tries to get Latest BOOK RETURNED DATE in TBL_Bktrans (but if it is null)
			WHEN ((Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1) IS not NULL)
			THEN ( Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1) -- Tries to get Latest BOOK ISSUED DATE in TBL_Bktrans( but if not took any book)
			ELSE (Select m2.doj from mems m2 where m2.m_id = m.m_Id limit 1)-- Tries to get Date of Joining of member in TBL_mems
		END) LastSeen
	from mems m
	where mType='T' and mStatus='I'
	
	order by LastSeen desc;
	-- ____________5: Inactive Teachers ____________


+------+-------+------------+------------+------+------------+
| M_id | Mname | mPh1       | doj        | P.F. | LastSeen   |
+------+-------+------------+------------+------+------------+
| 1002 | Satya | 8787878787 | 2019-06-29 | 0.00 | 2019-07-31 |
+------+-------+------------+------------+------+------------+
1 row in set (0.00 sec)


mysql> -- 6) Inactive Members :-

	Select m.M_id, m.Mname,
		(case when cls is null then "-" else cls end) cls,
		(case when rno = 0 then "-" else rno end) rno,
		(CASE WHEN mType='S' THEN (Select 'Stu.') ELSE (Select 'Fac.') END ) as 'Type',
		m.mPh1, m.doj,
		(CASE When ((Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1) is not null )
			THEN( Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1 ) -- Tries to get Latest BOOK RETURNED DATE in TBL_Bktrans (but if it is null)
			WHEN ((Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1) IS not NULL)
			THEN ( Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1) -- Tries to get Latest BOOK ISSUED DATE in TBL_Bktrans( but if not took any book)
			ELSE (Select m2.doj from mems m2 where m2.m_id = m.m_Id limit 1)-- Tries to get Date of Joining of member in TBL_mems
		END) LastSeen
	from mems m
	where mStatus='I'
	
	order by mtype,LastSeen desc;	
		+------+---------+--------+------+------+------------+------------+-----------+
		| M_id | Mname   | cls    | rno  | Type | mPh1       | doj        | LastSeen  |
		+------+---------+--------+------+------+------------+------------+-----------+
		| 1002 | Satya   | -      | -    | Fac. | 8787878787 | 2019-06-29 | Jul 31,19 |
		| 1001 | Shubham | BCA    | 1    | Stu. | 8601725056 | 2019-06-29 | Jul 31,19 |
		| 1005 | Sonal   | B.Tech | 3    | Stu. | 2342342342 | 2019-07-05 | Jul 05,19 |
		| 1003 | Hitest  | BA     | 3    | Stu. | 8787878777 | 2019-07-01 | Aug 05,19 |
		+------+---------+--------+------+------+------------+------------+-----------+
	
	-- ____________6: Inactive Members____________
	
+------+---------+--------+------+------+------------+------------+------------+
| M_id | Mname   | cls    | rno  | Type | mPh1       | doj        | LastSeen   |
+------+---------+--------+------+------+------------+------------+------------+
| 1003 | Hitest  | BA     | 3    | Stu. | 8787878777 | 2019-07-01 | 2019-08-05 |
| 1001 | Shubham | BCA    | 1    | Stu. | 8601725056 | 2019-06-29 | 2019-07-31 |
| 1005 | Sonal   | B.Tech | 3    | Stu. | 2342342342 | 2019-07-05 | 2019-07-05 |
| 1002 | Satya   | -      | -    | Fac. | 8787878787 | 2019-06-29 | 2019-07-31 |
| 1008 | shubh   | -      | -    | Fac. | 9898989898 | 2019-07-19 | 2019-07-19 |
+------+---------+--------+------+------+------------+------------+------------+


		-- 7) All Members :-

	Select m.M_id, m.Mname,
	(CASE when cls is null then "-" else cls end) cls,
	(CASE when rno = 0 then "-" else rno end) rno,
	(CASE WHEN mType='S' THEN (Select 'Stu.') ELSE (Select 'Fac.') END ) as 'Type',
	m.mPh1 Ph1,
	m.doj,	
	(CASE When ((Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1) is not null )
			THEN( Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1 ) -- Tries to get Latest BOOK RETURNED DATE in TBL_Bktrans (but if it is null)
			WHEN ((Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1) IS not NULL)
			THEN ( Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1) -- Tries to get Latest BOOK ISSUED DATE in TBL_Bktrans( but if not took any book)
			ELSE (Select m2.doj from mems m2 where m2.m_id = m.m_Id limit 1)-- Tries to get Date of Joining of member in TBL_mems
		END) LastSeen
	FROM mems m
	
	ORDER BY mtype , LastSeen desc;
	
	
+------+-----------+--------+------+------+------------+------------+------------+
| M_id | Mname     | cls    | rno  | Type | Ph1        | doj        | LastSeen   |
+------+-----------+--------+------+------+------------+------------+------------+
| 1003 | Hitest    | BA     | 3    | Stu. | 8787878777 | 2019-07-01 | 2019-08-05 |
| 1001 | Shubham   | BCA    | 1    | Stu. | 8601725056 | 2019-06-29 | 2019-07-31 |
| 1006 | Mina      | BCA    | 8    | Stu. | 9898989898 | 2019-07-15 | 2019-07-15 |
| 1007 | Rohit     | MBA    | 1    | Stu. | 9879879878 | 2019-07-15 | 2019-07-15 |
| 1005 | Sonal     | B.Tech | 3    | Stu. | 2342342342 | 2019-07-05 | 2019-07-05 |
| 1004 | Jitu      | BCA    | 4    | Stu. | 9879879878 | 2019-08-06 | 2019-07-02 |
| 1002 | Satya     | -      | -    | Fac. | 8787878787 | 2019-06-29 | 2019-07-31 |
| 1008 | shubh     | -      | -    | Fac. | 9898989898 | 2019-07-19 | 2019-07-19 |
| 1010 | Bhatt     | -      | -    | Fac. | 9879879878 | 2019-07-09 | 2019-07-09 |
| 1009 | Priyanshi | -      | -    | Fac. | 8787878787 | 2019-06-25 | 2019-06-25 |
| 1011 | Durgesh   | -      | -    | Fac. | 7676766666 | 2019-05-11 | 2019-05-11 |
+------+-----------+--------+------+------+------------+------------+------------+

=============================================================================================================================
====================================================== Table Desc : Report 3 ================================================
=============================================================================================================================
Select Criteria - x and Sort By 'Name' || 'Class' ||'Id' 


-- __________________________ Report 3 ( Queries in 1 line and Desc )________________________________
mysql> -- _______________Combo1: (1) Active Students :-
mysql>
mysql> Select  M_id, Mname, (case when cls is null then '-' else cls end) cls, (case when rno = 0 then '-' else rno end) rno, mPh1, mAddr, (CASE When ((Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1) is not null ) THEN( Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1 ) WHEN ((Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1) IS not NULL ) THEN ( Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1 )ELSE (Select m2.doj from mems m2 where m2.m_id = m.m_Id limit 1) END) LastSeen from mems m Where mStatus = 'A' and mtype='S'  order by Mname;
+------+-------+------+------+------------+-----------+------------+
| M_id | Mname | cls  | rno  | mPh1       | mAddr     | LastSeen   |
+------+-------+------+------+------------+-----------+------------+
| 1004 | Jitu  | BCA  | 4    | 9879879878 | Boharapur | 2019-07-02 |
| 1006 | Mina  | BCA  | 8    | 9898989898 | Hinsaran  | 2019-07-15 |
| 1007 | Rohit | MBA  | 1    | 9879879878 | Padri     | 2019-07-15 |
+------+-------+------+------+------------+-----------+------------+
3 rows in set (0.09 sec)




mysql> -- ______________Combo1: (2) Active Teachers :-

mysql> Select  M_id, Mname,mPh1,  (case when mPh2 is null then '  -'  else mPh2  end) Ph2,  mAddr,  (CASE  When ((Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1) is not null )  THEN( Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1 )  WHEN ((Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1) IS not NULL )  THEN ( Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1)  ELSE (Select m2.doj from mems m2 where m2.m_id = m.m_Id limit 1)  END) LastSeen  from mems m where mtype='T' and mstatus = 'A'  order by Mname,LastSeen desc
    -> ;
+------+-----------+------------+------------+-------------+------------+
| M_id | Mname     | mPh1       | Ph2        | mAddr       | LastSeen   |
+------+-----------+------------+------------+-------------+------------+
| 1010 | Bhatt     | 9879879878 |   -        | basharatpur | 2019-07-09 |
| 1011 | Durgesh   | 7676766666 | 6767676767 | Nimsaran    | 2019-05-11 |
| 1009 | Priyanshi | 8787878787 | 7676767676 | Bazaar      | 2019-06-25 |
| 1008 | shubh     | 9898989898 |   -        | bihar,patna | 2019-07-19 |
+------+-----------+------------+------------+-------------+------------+
4 rows in set (0.04 sec)




mysql> -- ______________Combo1: (3) Active Members :-

mysql> Select  M_id, Mname, (case when cls is null then '-' else cls end) cls, (case when rno = 0 then '-' else rno end) rno, (CASE WHEN mType='S' THEN (Select 'Stu.') ELSE (Select 'Fac.') END ) as 'Type', mPh1, mAddr, (CASE When ((Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1) is not null )THEN( Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1 ) WHEN ((Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1) IS not NULL) THEN ( Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1) ELSE (Select m2.doj from mems m2 where m2.m_id = m.m_Id limit 1) END) LastSeen from mems m where mstatus = 'A'  order by mType, mName, cls;
+------+-----------+------+------+------+------------+-------------+------------+
| M_id | Mname     | cls  | rno  | Type | mPh1       | mAddr       | LastSeen   |
+------+-----------+------+------+------+------------+-------------+------------+
| 1004 | Jitu      | BCA  | 4    | Stu. | 9879879878 | Boharapur   | 2019-07-02 |
| 1006 | Mina      | BCA  | 8    | Stu. | 9898989898 | Hinsaran    | 2019-07-15 |
| 1007 | Rohit     | MBA  | 1    | Stu. | 9879879878 | Padri       | 2019-07-15 |
| 1010 | Bhatt     | -    | -    | Fac. | 9879879878 | basharatpur | 2019-07-09 |
| 1011 | Durgesh   | -    | -    | Fac. | 7676766666 | Nimsaran    | 2019-05-11 |
| 1009 | Priyanshi | -    | -    | Fac. | 8787878787 | Bazaar      | 2019-06-25 |
| 1008 | shubh     | -    | -    | Fac. | 9898989898 | bihar,patna | 2019-07-19 |
+------+-----------+------+------+------+------------+-------------+------------+
7 rows in set (0.00 sec)



mysql> -- ______________Combo1: (4) Inactive Students :=

mysql> Select m.M_id, m.Mname, m.cls, m.rno, m.mPh1, m.doj, m.mProtectFee 'P.F.' , (CASE When ((Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1) is not null ) THEN( Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1 ) WHEN ((Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1) IS not NULL) THEN ( Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1) ELSE (Select m2.doj from mems m2 where m2.m_id = m.m_Id limit 1) END) LastSeen from mems m where mType='S' and mStatus='I'  order by Mname;
+------+---------+--------+------+------------+------------+--------+------------+
| M_id | Mname   | cls    | rno  | mPh1       | doj        | P.F.   | LastSeen   |
+------+---------+--------+------+------------+------------+--------+------------+
| 1003 | Hitest  | BA     |    3 | 8787878777 | 2019-07-01 | 500.00 | 2019-08-05 |
| 1001 | Shubham | BCA    |    1 | 8601725056 | 2019-06-29 | 500.00 | 2019-07-31 |
| 1005 | Sonal   | B.Tech |    3 | 2342342342 | 2019-07-05 | 500.00 | 2019-07-05 |
+------+---------+--------+------+------------+------------+--------+------------+
3 rows in set (0.00 sec)



mysql> -- ______________Combo1: Inactive Teachers :=

mysql> Select m.M_id, m.Mname, m.mPh1, m.doj, m.mProtectFee 'P.F.' , (CASE When ((Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1) is not null ) THEN( Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1 ) WHEN ((Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1) IS not NULL) THEN ( Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1) ELSE (Select m2.doj from mems m2 where m2.m_id = m.m_Id limit 1) END) LastSeen from mems m where mType='T' and mStatus='I' order by Mname;
+------+-------+------------+------------+------+------------+
| M_id | Mname | mPh1       | doj        | P.F. | LastSeen   |
+------+-------+------------+------------+------+------------+
| 1002 | Satya | 8787878787 | 2019-06-29 | 0.00 | 2019-07-31 |
+------+-------+------------+------------+------+------------+
1 row in set (0.00 sec)




mysql> -- ______________Combo1: Inactive Members :=

mysql> Select m.M_id, m.Mname, (case when cls is null then '-' else cls end) cls, (case when rno = 0 then '-' else rno end) rno, (CASE WHEN mType='S' THEN (Select 'Stu.') ELSE (Select 'Fac.') END ) as 'Type', m.mPh1, m.doj, (CASE When ((Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1) is not null ) THEN( Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1 ) WHEN ((Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1) IS not NULL) THEN ( Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1)  ELSE (Select m2.doj from mems m2 where m2.m_id = m.m_Id limit 1) END) LastSeen from mems m where mStatus='I' order by mType,Mname;
+------+---------+--------+------+------+------------+------------+------------+
| M_id | Mname   | cls    | rno  | Type | mPh1       | doj        | LastSeen   |
+------+---------+--------+------+------+------------+------------+------------+
| 1003 | Hitest  | BA     | 3    | Stu. | 8787878777 | 2019-07-01 | 2019-08-05 |
| 1001 | Shubham | BCA    | 1    | Stu. | 8601725056 | 2019-06-29 | 2019-07-31 |
| 1005 | Sonal   | B.Tech | 3    | Stu. | 2342342342 | 2019-07-05 | 2019-07-05 |
| 1002 | Satya   | -      | -    | Fac. | 8787878787 | 2019-06-29 | 2019-07-31 |
+------+---------+--------+------+------+------------+------------+------------+
4 rows in set (0.00 sec)




mysql> -- ______________Combo1: All the Members :=


mysql> Select m.M_id, m.Mname, (CASE when cls is null then '-' else cls end) cls, (CASE when rno = 0 then '-' else rno end) rno, (CASE WHEN mType='S' THEN (Select 'Stu.') ELSE (Select 'Fac.') END ) as 'Type', m.mPh1 Ph1, m.doj, (CASE When ((Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1) is not null )     THEN( Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1 )      WHEN ((Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1) IS not NULL)     THEN ( Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1)      ELSE (Select m2.doj from mems m2 where m2.m_id = m.m_Id limit 1) END) LastSeen FROM mems m order by mType,Mname,cls,rno;
+------+-----------+--------+------+------+------------+------------+------------+
| M_id | Mname     | cls    | rno  | Type | Ph1        | doj        | LastSeen   |
+------+-----------+--------+------+------+------------+------------+------------+
| 1003 | Hitest    | BA     | 3    | Stu. | 8787878777 | 2019-07-01 | 2019-08-05 |
| 1004 | Jitu      | BCA    | 4    | Stu. | 9879879878 | 2019-08-06 | 2019-07-02 |
| 1006 | Mina      | BCA    | 8    | Stu. | 9898989898 | 2019-07-15 | 2019-07-15 |
| 1007 | Rohit     | MBA    | 1    | Stu. | 9879879878 | 2019-07-15 | 2019-07-15 |
| 1001 | Shubham   | BCA    | 1    | Stu. | 8601725056 | 2019-06-29 | 2019-07-31 |
| 1005 | Sonal     | B.Tech | 3    | Stu. | 2342342342 | 2019-07-05 | 2019-07-05 |
| 1010 | Bhatt     | -      | -    | Fac. | 9879879878 | 2019-07-09 | 2019-07-09 |
| 1011 | Durgesh   | -      | -    | Fac. | 7676766666 | 2019-05-11 | 2019-05-11 |
| 1009 | Priyanshi | -      | -    | Fac. | 8787878787 | 2019-06-25 | 2019-06-25 |
| 1002 | Satya     | -      | -    | Fac. | 8787878787 | 2019-06-29 | 2019-07-31 |
| 1008 | shubh     | -      | -    | Fac. | 9898989898 | 2019-07-19 | 2019-07-19 |
+------+-----------+--------+------+------+------------+------------+------------+
11 rows in set (0.00 sec)

mysql>





Select  M_id, Mname,mPh1,
	(case when mPh2 is null then '  -'
		  else mPh2 end
	) Ph2, 
	  mAddr,
	(CASE When ((Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1) is not null )  
		THEN( Select b.m_actRetDt from bktrans b where b.m_id = m.m_Id limit 1 )  
		WHEN ((Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1) IS not NULL )  
		THEN ( Select b.m_issDt from bktrans b where b.m_id = m.m_Id limit 1)  
		ELSE (Select m2.doj from mems m2 where m2.m_id = m.m_Id limit 1)  
		END
	)LastSeen 
From mems m 
Where mtype='T' and mstatus = 'A' ;
		  

=============================================================================================================================
====================================================== Creating Table Bk_Del ================================================
=============================================================================================================================		  



Query Used when pnlBkDelNow Submitted...with OtherReasonSelected:
-----------------------------------------------------------------
Select b.Accno Accno from tbl_books b where b.accid = 10001 and b.status = 'A' limit 1;
+-------+ 
| Accno |
+-------+
|   102 |
+-------+

Query Used when pnlBkDelNow Submitted...with MemberLostBookSelected:
--------------------------------------------------------------------

Select b.Accno Accno from tbl_books b where b.accid = 10001 and b.status = 'I' limit 1;
+-------+
| Accno |
+-------+
|   101 |
+-------+

-------------------------- Master Query to Debug above Query --------------------------
-- select * from tbl_books where accid = 10001;
	-- +-------+-------+--------+
	-- | accid | accno | status |
	-- +-------+-------+--------+
	-- | 10001 |   101 | I      |
	-- | 10001 |   102 | A      |
	-- | 10001 |   103 | A      |
	-- +-------+-------+--------+
-- 3 rows in set (0.03 sec)



drop table bkDel;Create table bkDel( --  or  create table bkdel
	id int(5) auto_increment,
	m_id int(6) references librarydb.mems(m_id),
	accid int(5) not null references librarydb.tbl_book_info( accid ),
	accno int(3) not null references librarydb.tbl_books( accno ),
	reason varchar(100),
	deldate date not null,
	primary key(id)
);

-- Following Queries / the Procedure will be in Action when Book Deletion Panel E 'pnlBkDel_E' is Submitted...

----------------------------- use these Queries -----------------------------
{
	For Tabble Tbl_books : 
	______________________
		Update Tbl_books set status = 'D' where accid = 10001 and accno = 102;


	For Tabble bkDel : 
	__________________
	Insert Into bkDel( m_Id, accid, accno, deldate ) 			-- when Member Lost the Book...
				Values( 1004, 10001, 102, date(sysdate()) );
			  
	Insert Into bkDel( accid, accno, reason, deldate ) 			-- when for Other Reason, Book Deletion is required...
				Values( 10001, 102, 'Rat ruined this.', date(sysdate()) );
}


-- When Member(1008) Lost the book issued to him :
==================================================

Select c.b_name Book, b.b_acc_id Accid, b.accno Accno, c.b_qty Qty, m.mName Member, b.m_Id M_Id, 
		(CASE WHEN m.mType='S' 
			 THEN (Select 'Stu.') 
			 ELSE (Select 'Fac.') 
			 END ) as 'Type', 
		date_format(b.m_issDt,'%b %d,%y') IssuedOn, c.b_price Price,
		b.t_id TransId,
		c.b_auth1 Author 
from bktrans b, 
	 mems m , 
	 tbl_book_info c 
where b.m_id = 1008 and b.m_id = m.m_id and b.b_acc_id = c.b_acc_id and b.m_actRetDt is null;
	-- order by Price;
	
	-------------------------- OR --------------------------
+---------- +-------+-------+-----+--------+------+------+-----------+--------+---------+--------+
| Book      | Accid | Accno | Qty | Member | M_Id | Type | IssuedOn  | Price  | TransId | Author |
+---------- +-------+-------+-----+--------+------+------+-----------+--------+---------+--------+
| Cpp Book  | 10002 |   102 |   5 | shubh  | 1008 | Fac. | Jul 16,19 | 300.00 |       2 | Kallo  |
| Java book | 10001 |   103 |   3 | shubh  | 1008 | Fac. | Jul 19,19 | 799.00 |       5 | Lalaji |
+---------- +-------+-------+-----+--------+------+------+-----------+--------+---------+--------+



+-----------+-------+-------+-----+--------+------+------+-----------+--------+---------+

	-------------------------- OR --------------------------

+---------- +-------+-------+-----+--------+------+------+-----------+--------+---------+--------+
| Book      | Accid | Accno | Qty | Member | M_Id | Type | IssuedOn  | Price  | TransId | Author |
+---------- +-------+-------+-----+--------+------+------+-----------+--------+---------+--------+
| Cpp Book  | 10002 |   102 |   5 | shubh  | 1008 | Fac. | Jul 16,19 | 300.00 |       2 | Kallo  |
+-----------+-------+-------+-----+--------+------+------+-----------+--------+---------+--------+

	-------------------------- OR --------------------------

	Empty Set Returned : when No book is issued to This MemberId( 1008 ).
	


=============================================================================================================================
====================================================== Table Desc : Report 4 ================================================
=============================================================================================================================		  
		  
SELECT * FROM tbl_book_info;
+----------+-----------+-------+-------------+---------+---------+-------------+---------+--------+---------+------------------+
| b_acc_id | b_name    | b_qty | b_type      | b_auth1 | b_auth2 | b_pub       | b_pages | b_rack | b_price | b_about          |
+----------+-----------+-------+-------------+---------+---------+-------------+---------+--------+---------+------------------+
|    10001 | Java book |     3 | Programming | lala    | -       | kallo       |     800 |      1 |  799.00 | good Coding book |
|    10002 | Cpp Book  |     5 | Programming | Kallo   | Mangal  | Mehta group |     400 |      2 |  300.00 | a Coding book    |
|    10003 | Cpp 1.17  |     5 | Programming | lalaji  | -       | amam co.    |     479 |      3 |  100.00 | -                |
+----------+-----------+-------+-------------+---------+---------+-------------+---------+--------+---------+------------------+
SELECT * FROM tbl_books where status = 'A';
+-------+-------+--------+
| accid | accno | status |
+-------+-------+--------+
| 10001 |   103 | A      |
| 10002 |   103 | A      |
| 10002 |   105 | A      |
| 10003 |   103 | A      |
| 10003 |   105 | A      |
+-------+-------+--------+

R4 := 1 Selected Index  -: All Available Books...
__________________________________________________

Part : 1-
Select bkinfo.b_Name Name, bkinfo.b_acc_id Code, bkinfo.b_qty Qty, bkinfo.b_auth1 'Author 1', bkinfo.b_auth2 'Author 2', b_price Price,
		bkinfo.b_rack Rack, 
		(Select count(bksts.status) Abls from tbl_books bksts where bksts.accid = Code and bksts.status = 'A') Abls
From tbl_book_info bkinfo, tbl_books bksts 
where Abls > 0
group by Code;														-- ...Need to Re-fine

-----------------------------------------------------	OR 	 -----------------------------------------------------

Part : 2 - Final: 
	Select a.b_Name Name, a.b_acc_id Code, a.b_qty Qty, a.b_auth1 'Author 1', a.b_auth2 'Author 2', a.b_price Price, a.b_rack Rack, 
		 SUM(case 
				when b.status='A' then 1
				else 0
			 end
			) as Available
	From tbl_book_info a left join tbl_books b on a.b_acc_id=b.accid
	where b.status = 'A'
	group by a.b_name, a.b_qty, a.b_acc_id order by a.b_acc_id ;		-- ...Final Query

	+-----------+-------+-----+----------+----------+--------+------+-----------+
	| Name      | Code  | Qty | Author 1 | Author 2 | Price  | Rack | Available |
	+-----------+-------+-----+----------+----------+--------+------+-----------+
	| Java book | 10001 |   3 | lala     | -        | 799.00 |    1 |         1 |
	| Cpp Book  | 10002 |   5 | Kallo    | Mangal   | 300.00 |    2 |         3 |
	| Cpp 1.17  | 10003 |   5 | lalaji   | -        | 100.00 |    3 |         3 |
	+-----------+-------+-----+----------+----------+--------+------+-----------+
====================================================================================================================

R4 := 2 Selected Index -: All Issued Books   ...

	Select c.b_Name Name, b.b_acc_id BookCode, m.mName Member, 
		(CASE WHEN m.mType='S'
					 THEN (Select 'Stu.')
					 ELSE (Select 'Fac.')				 
					 END ) as 'Type',
		b.m_id M_Id, date_format(b.m_issDt,'%b %d,%Y') issuedOn,
		date_format( b.m_propDt,'%b %d,%Y' ) LastDate,
		datediff( b.m_propDt , Date(Sysdate()) ) DaysLeft
	From bktrans b, mems m ,tbl_book_info c 
	where b.m_actRetDt is null and b.m_id = m.m_id and b.b_acc_id = c.b_acc_id order by b.m_Id;

	+-----------+----------+---------+------+------+-------------+-------------+----------+
	| Name      | BookCode | Member  | Type | M_Id | issuedOn    | LastDate    | DaysLeft |
	+-----------+----------+---------+------+------+-------------+-------------+----------+
	| Cpp 1.17  |    10003 | Shubham | Stu. | 1001 | Aug 06,2019 | Sep 06,2019 |       53 |
	| Java book |    10001 | Jitu    | Stu. | 1004 | Jul 02,2019 | Aug 02,2019 |       18 |
	| Cpp Book  |    10002 | Sonal   | Stu. | 1005 | Jul 05,2019 | Aug 05,2019 |       21 |
	| Cpp 1.17  |    10003 | Mina    | Stu. | 1006 | Jul 15,2019 | Aug 15,2019 |       31 |
	| Cpp Book  |    10002 | shubh   | Fac. | 1008 | Jul 19,2019 | Aug 19,2019 |       35 |
	| Java book |    10001 | Bhatt   | Fac. | 1010 | Jul 09,2019 | Aug 09,2019 |       25 |
	+-----------+----------+---------+------+------+-------------+-------------+----------+


	/*	__________ Debug Report4 : 2_List of Issued Books Selected __________

	SQL: Select c.b_Name Name, b.b_acc_id BookCode, m.mName Member, m.mType 'Type', b.m_id M_Id, date_format(b.m_issDt,'%b %d,%Y') issuedOn,
			date_format( b.m_propDt,'%b %d,%Y' ) LastDate,
			datediff( b.m_propDt , Date(Sysdate()) ) DaysLeft
		 From bktrans b, mems m ,tbl_book_info c
		 where b.m_actRetDt is null and b.m_id = m.m_id and b.b_acc_id = c.b_acc_id order by b.m_Id;
					+-----------+----------+---------+------+------+-------------+-------------+----------+
					| Name      | BookCode | Member  | Type | M_Id | issuedOn    | LastDate    | DaysLeft |
					+-----------+----------+---------+------+------+-------------+-------------+----------+
					| Cpp 1.17  |    10003 | Shubham | Stu. | 1001 | Aug 06,2019 | Sep 06,2019 |       53 |
					| Java book |    10001 | Jitu    | Stu. | 1004 | Jul 02,2019 | Aug 02,2019 |       18 |
					| Cpp Book  |    10002 | Sonal   | Stu. | 1005 | Jul 05,2019 | Aug 05,2019 |       21 |
					| Cpp 1.17  |    10003 | Mina    | Stu. | 1006 | Jul 15,2019 | Aug 15,2019 |       31 |
					| Cpp Book  |    10002 | shubh   | Fac. | 1008 | Jul 19,2019 | Aug 19,2019 |       35 |
					| Java book |    10001 | Bhatt   | Fac. | 1010 | Jul 09,2019 | Aug 09,2019 |       25 |
					+-----------+----------+---------+------+------+-------------+-------------+----------+

				Master Data 	: 		Select * from bktrans where m_actRetDt is null;	-- All Issued Books in Database...
		+------+------+----------+-------+------------+------------+------------+--------+--------------+-----------+
		| t_id | m_id | b_acc_id | accno | m_issDt    | m_propDt   | m_actRetDt | m_fine | m_delayCause | m_nPropDt |
		+------+------+----------+-------+------------+------------+------------+--------+--------------+-----------+
		|    5 | 1001 |    10003 |   101 | 2019-08-06 | 2019-09-06 | NULL       |   NULL | NULL         |      NULL |
		|    6 | 1004 |    10001 |   101 | 2019-07-02 | 2019-08-02 | NULL       |   NULL | NULL         |      NULL |
		|    8 | 1005 |    10002 |   101 | 2019-07-05 | 2019-08-05 | NULL       |   NULL | NULL         |      NULL |
		|   10 | 1006 |    10003 |   102 | 2019-07-15 | 2019-08-15 | NULL       |   NULL | NULL         |      NULL |
		|   11 | 1008 |    10002 |   102 | 2019-07-19 | 2019-08-19 | NULL       |   NULL | NULL         |      NULL |
		|   12 | 1010 |    10001 |   102 | 2019-07-09 | 2019-08-09 | NULL       |   NULL | NULL         |      NULL |
		+------+------+----------+-------+------------+------------+------------+--------+--------------+-----------+
	*/
====================================================================================================================
__________________________________________________

R4 := 3 Selected Index  -: All Books On Repair...

	-- +-------+-------+--------+
	-- | 10001 |   101 | R      |
	-- | 10001 |   102 | I      |
	-- | 10001 |   103 | A      |
	-- | 10002 |   101 | I      |
	-- | 10002 |   102 | I      |
	-- | 10002 |   103 | A      |
	-- | 10002 |   104 | A      |
	-- | 10002 |   105 | A      |
	-- | 10003 |   101 | R      |
	-- | 10003 |   102 | R      |
	-- | 10003 |   103 | A      |
	-- | 10003 |   104 | A      |
	-- | 10003 |   105 | A      |
	-- +-------+-------+--------+

	Select a.b_Name Name, a.b_acc_id Code, a.b_qty Qty, a.b_auth1 'Author 1', a.b_auth2 'Author 2', a.b_price Price, a.b_rack Rack, 
		 SUM(case 
				when b.status='R' then 1
				else 0
			 end
			) as 'On Repair' 
	From tbl_book_info a left join tbl_books b on a.b_acc_id=b.accid
	where b.status = 'R'
	group by a.b_name, a.b_qty, a.b_acc_id order by a.b_acc_id ;

	+-----------+-------+-----+----------+----------+--------+------+-----------+
	| Name      | Code  | Qty | Author 1 | Author 2 | Price  | Rack | On Repair |
	+-----------+-------+-----+----------+----------+--------+------+-----------+
	| Java book | 10001 |   3 | lala     | -        | 799.00 |    1 |         1 |
	| Cpp 1.17  | 10003 |   5 | lalaji   | -        | 100.00 |    3 |         2 |
	+-----------+-------+-----+----------+----------+--------+------+-----------+


====================================================================================================================
__________________________________________________

R4 := 4 Selected Index : -: All Destroyed Books...

	Select a.b_Name 'Name',
		a.b_acc_id 'Code',
		a.b_qty 'Qty',
		a.b_price 'Price',	
		a.b_rack 'Rack',
		( CASE  WHEN (d.m_id is Null ) THEN "  -" ELSE ( d.m_id ) END ) 'M_Id',
		d.delDate 'Date',
		( CASE  WHEN (d.reason is Null ) THEN "  -" ELSE ( d.reason ) END ) 'Reason'
	From tbl_book_info a,
		tbl_books b,
		mems m,
		bkdel d
	Where d.accid = a.b_acc_id and d.accid = b.accid and d.accno = b.accno and (d.m_id = m.m_Id or (d.m_id is null))
	Group by b.accid,b.accno 
	Order by Code, d.reason, d.delDate desc;

	+-----------+-------+-----+--------+------+------+------------+----------------------------+
	| Name      | Code  | Qty | Price  | Rack | M_Id | Date       | Reason                     |
	+-----------+-------+-----+--------+------+------+------------+----------------------------+
	| Java book | 10001 |   3 | 799.00 |    1 | 1004 | 2019-07-25 |   -                        |
	| Java book | 10001 |   3 | 799.00 |    1 | 1011 | 2019-07-25 |   -                        |
	| Cpp Book  | 10002 |   5 | 300.00 |    2 |   -  | 2019-07-25 | Gandhi ji ko de diye       |
	| Cpp 1.17  | 10003 |   5 | 100.00 |    3 |   -  | 2019-07-25 | Reason is very funny ...:) |
	+-----------+-------+-----+--------+------+------+------------+----------------------------+

====================================================================================================================
__________________________________________________

R4 := 5 Selected Index -: All Books Information...
	
	Query 1:
	Select a.b_name BookName, a.b_qty BookQty, a.b_acc_id Code, 
		SUM(case  when b.status='A' then 1 else 0 end) as Available,
		SUM(case  when b.status='I' then 1 else 0 end) as Issued, 
		SUM(case  when b.status='R' then 1 else 0 end) as Repair, 
		SUM(case  when b.status='D' then 1 else 0 end) as Destroyed 	 
	From tbl_book_info a left join tbl_books b on a.b_acc_id = b.accid 
	GROUP BY a.b_name, a.b_qty, a.b_acc_id order by a.b_acc_id ; 

	+--------------+---------+-------+-----------+--------+--------+-----------+
	| BookName     | BookQty | Code  | Available | Issued | Repair | Destroyed |
	+--------------+---------+-------+-----------+--------+--------+-----------+
	| Java book    |       3 | 10001 |         1 |      0 |      0 |         2 |
	| Cpp Book     |       5 | 10002 |         3 |      1 |      0 |         1 |
	| Cpp 1.17     |       5 | 10003 |         3 |      1 |      0 |         1 |
	| Visual Basic |       4 | 10004 |         4 |      0 |      0 |         0 |
	+--------------+---------+-------+-----------+--------+--------+-----------+
	
	Query 2:
	SELECT (Select count(*) from tbl_book_info) TotalBooks,
		   (Select count(*) from tbl_books) TotalQty,
		   (Select count(*) from tbl_books where status='A') Available,
		   (Select count(*) from tbl_books where status='I') Issued,
		   (Select count(*) from tbl_books where status='R') Repair;

	+------------+----------+-----------+--------+--------+
	| TotalBooks | TotalQty | Available | Issued | Repair |
	+------------+----------+-----------+--------+--------+
	|          4 |       17 |        11 |      2 |      0 |
	+------------+----------+-----------+--------+--------+

	SELECT TotalBooks,TotalQty,Available,Issued,Repair  
	From ((Select count(*) from tbl_book_info) TotalBooks,
		  (Select count(*) from tbl_books) TotalQty,
		  (Select count(*) from tbl_books where status='A') Available,
		  (Select count(*) from tbl_books where status='I') Issued,
		  (Select count(*) from tbl_books where status='R') Repair
		 ) a;
	
								OR 
								
	Query 3: For Replacing Query 1 AND Query 2
	
	Set @counter := 0, @counterQty := 0, @counterAvb := 0, @counterIss := 0, @counterRep := 0 ,@counterDes := 0;
	Select *
	From (SELECT 
		   (Select (@counter := (@counter + 1) ) ) 'Sr.No.',
		   testt.BookName,
		   testt.BookQty,
		   testt.Code, 
		   testt.Available, 
		   testt.Issued, 
		   testt.Repair, 
		   testt.Destroyed,
		   (@counterQty := @counterQty + testt.BookQty ) TotalQty,		-- 3) Than This Sub Query'll Execute...
		   (@counterAvb := @counterAvb + testt.Available ) TotalAvb,	-- 4) Than This Sub Query'll Execute...
		   (@counterIss := @counterIss + testt.Issued ) TotalIss,		-- 5) Than This Sub Query'll Execute...
		   (@counterRep := @counterRep + testt.Repair ) TotalRep,		-- 6) Than This Sub Query'll Execute...
		   (@counterDes := @counterDes + testt.Destroyed ) TotalDest	-- 7) Than This Sub Query'll Execute...	
		 From (Select a.b_name BookName, a.b_qty BookQty, a.b_acc_id Code, 										-- 1) Starts From Here...
				SUM(case  when b.status='A' then 1 else 0 end) as Available,
				SUM(case  when b.status='I' then 1 else 0 end) as Issued, 
				SUM(case  when b.status='R' then 1 else 0 end) as Repair, 
				SUM(case  when b.status='D' then 1 else 0 end) as Destroyed 	 
			  From tbl_book_info a left join tbl_books b on a.b_acc_id = b.accid 
			  GROUP BY a.b_name, a.b_qty, a.b_acc_id order by a.b_acc_id
		 )testt
	)Main;

	
+--------+--------------+---------+-------+-----------+--------+--------+-----------+----------+----------+----------+----------+-----------+
| Sr.No. | BookName     | BookQty | Code  | Available | Issued | Repair | Destroyed | TotalQty | TotalAvb | TotalIss | TotalRep | TotalDest |
+--------+--------------+---------+-------+-----------+--------+--------+-----------+----------+----------+----------+----------+-----------+
|      1 | Java book    |       3 | 10001 |         1 |      0 |      0 |         2 |        3 |        1 |        0 |        0 |         2 |
|      2 | Cpp Book     |       5 | 10002 |         3 |      1 |      0 |         1 |        8 |        4 |        1 |        0 |         3 |
|      3 | Cpp 1.17     |       5 | 10003 |         3 |      1 |      0 |         1 |       13 |        7 |        2 |        0 |         4 |
|      4 | Visual Basic |       4 | 10004 |         4 |      0 |      0 |         0 |       17 |       11 |        2 |        0 |         4 |
+--------+--------------+---------+-------+-----------+--------+--------+-----------+----------+----------+----------+----------+-----------+




====================================================================================================================
									Table Summary of 4th Report
====================================================================================================================
R1 : -
+-----------+-------+-----+----------+----------+--------+------+-----------+
| Name      | Code  | Qty | Author 1 | Author 2 | Price  | Rack | Available |
+-----------+-------+-----+----------+----------+--------+------+-----------+
| Java book | 10001 |   3 | lala     | -        | 799.00 |    1 |         1 |
| Cpp Book  | 10002 |   5 | Kallo    | Mangal   | 300.00 |    2 |         3 |
| Cpp 1.17  | 10003 |   5 | lalaji   | -        | 100.00 |    3 |         3 |
+-----------+-------+-----+----------+----------+--------+------+-----------+

R2: -
+-----------+----------+---------+------+------+-------------+-------------+----------+
| Name      | BookCode | Member  | Type | M_Id | issuedOn    | LastDate    | DaysLeft |
+-----------+----------+---------+------+------+-------------+-------------+----------+
| Cpp 1.17  |    10003 | Shubham | Stu. | 1001 | Aug 06,2019 | Sep 06,2019 |       53 |
| Java book |    10001 | Jitu    | Stu. | 1004 | Jul 02,2019 | Aug 02,2019 |       18 |
| Cpp Book  |    10002 | Sonal   | Stu. | 1005 | Jul 05,2019 | Aug 05,2019 |       21 |
| Cpp 1.17  |    10003 | Mina    | Stu. | 1006 | Jul 15,2019 | Aug 15,2019 |       31 |
| Cpp Book  |    10002 | shubh   | Fac. | 1008 | Jul 19,2019 | Aug 19,2019 |       35 |
| Java book |    10001 | Bhatt   | Fac. | 1010 | Jul 09,2019 | Aug 09,2019 |       25 |
+-----------+----------+---------+------+------+-------------+-------------+----------+

R3 : -
+-----------+-------+-----+----------+----------+--------+------+-----------+
| Name      | Code  | Qty | Author 1 | Author 2 | Price  | Rack | On Repair |
+-----------+-------+-----+----------+----------+--------+------+-----------+
| Java book | 10001 |   3 | lala     | -        | 799.00 |    1 |         1 |
| Cpp 1.17  | 10003 |   5 | lalaji   | -        | 100.00 |    3 |         2 |
+-----------+-------+-----+----------+----------+--------+------+-----------+

R4 : -
+-----------+-------+-----+----------+--------+------------------+------+-----------+
| Name      | Code  | Qty | Author 1 | Price  | Desc             | Rack | On Repair |
+-----------+-------+-----+----------+--------+------------------+------+-----------+
| Java book | 10001 |   3 | lala     | 799.00 | good Coding book |    1 |         1 |
| Cpp Book  | 10002 |   5 | Kallo    | 300.00 | a Coding book    |    2 |         0 |
| Cpp 1.17  | 10003 |   5 | lalaji   | 100.00 | -                |    3 |         2 |
+-----------+-------+-----+----------+--------+------------------+------+-----------+

R5 :-
+--------+--------------+---------+-------+-----------+--------+--------+-----------+----------+----------+----------+----------+-----------+
| Sr.No. | BookName     | BookQty | Code  | Available | Issued | Repair | Destroyed | TotalQty | TotalAvb | TotalIss | TotalRep | TotalDest |
+--------+--------------+---------+-------+-----------+--------+--------+-----------+----------+----------+----------+----------+-----------+
|      1 | Java book    |       3 | 10001 |         1 |      0 |      0 |         2 |        3 |        1 |        0 |        0 |         2 |





------------------------------------------------------ Book Delete Queries ------------------------------------------------------


Select a.b_acc_id Code , a.b_name Name, a.b_qty Qty , a.b_type 'Type' , a.b_auth1 Author , a.b_price Price ,
	(select count(*) from tbl_books b where b.accid = a.b_acc_id and b.status = 'I' ) Issued,
	(select count(*) from tbl_books b where b.accid = a.b_acc_id and b.status = 'R' ) Repairing,
	(select count(*) from tbl_books b where b.accid = a.b_acc_id and b.status = 'D' ) Destroyed,
	(select count(*) from tbl_books b where b.accid = a.b_acc_id  and b.status = 'A') Available 
From tbl_book_info a left join tbl_books b on a.b_acc_id = b.accid 
WHERE a.b_acc_id =10001 Group by a.b_acc_id;
+-------+-----------+-----+-------------+--------+--------+--------+-----------+-----------+-----------+
| Code  | Name      | Qty | Type        | Author | Price  | Issued | Repairing | Destroyed | Available |
+-------+-----------+-----+-------------+--------+--------+--------+-----------+-----------+-----------+
| 10001 | Java book |   3 | Programming | lala   | 799.00 |      1 |         0 |         0 |         2 |
+-------+-----------+-----+-------------+--------+--------+--------+-----------+-----------+-----------+


Select a.b_acc_id Code , a.b_name Name, a.b_qty Qty , a.b_type 'Type' , a.b_auth1 Author , a.b_price Price ,
	(select count(*) from tbl_books b where b.status = 'I' and b.accid = a.b_acc_id ) Issued,
	(select count(*) from tbl_books b where b.status = 'R' and b.accid = a.b_acc_id ) Repairing,
	(select count(*) from tbl_books b where b.status = 'D' and b.accid = a.b_acc_id ) Destroyed,
	(select count(*) from tbl_books b where b.status = 'A' and b.accid = a.b_acc_id ) Available 
From tbl_book_info a left join tbl_books b on a.b_acc_id = b.accid 
WHERE a.b_name like 'c%' and a.b_acc_id = b.accid Group by a.b_acc_id;

+-------+----------+-----+-------------+--------+--------+--------+-----------+-----------+-----------+
| Code  | Name     | Qty | Type        | Author | Price  | Issued | Repairing | Destroyed | Available |
+-------+----------+-----+-------------+--------+--------+--------+-----------+-----------+-----------+
| 10003 | Cpp 1.17 |   5 | Programming | lalaji | 100.00 |      0 |         0 |         0 |         5 |
| 10002 | Cpp Book |   5 | Programming | Kallo  | 300.00 |      2 |         0 |         0 |         3 |
+-------+----------+-----+-------------+--------+--------+--------+-----------+-----------+-----------+

-------------------------------------------------- Master Query to Debug above --------------------------------------------------

-- mysql>  select * from tbl_books;
-- +-------+-------+--------+
-- | accid | accno | status |
-- +-------+-------+--------+
-- | 10001 |   101 | I      |
-- | 10001 |   102 | A      |
-- | 10001 |   103 | A      |
-- | 10002 |   101 | I      |
-- | 10002 |   102 | I      |
-- | 10002 |   103 | A      |
-- | 10002 |   104 | A      |
-- | 10002 |   105 | A      |
-- | 10003 |   101 | A      |
-- | 10003 |   102 | A      |
-- | 10003 |   103 | A      |
-- | 10003 |   104 | A      |
-- | 10003 |   105 | A      |
-- +-------+-------+--------+
-- 13 rows in set (0.00 sec)


-- When Member(1008) Lost the book issued to him :
==================================================

Select c.b_name Book, b.b_acc_id Accid, b.accno Accno, c.b_qty Qty, m.mName Member, b.m_Id M_Id, 
		(CASE WHEN m.mType='S' 
			 THEN (Select 'Stu.') 
			 ELSE (Select 'Fac.') 
			 END ) as 'Type', 
		date_format(b.m_issDt,'%b %d,%y') IssuedOn, c.b_price Price	,
		b.t_id T_Id, 
		c.b_auth1 Author
from bktrans b, 
	 mems m , 
	 tbl_book_info c 
where b.m_id = 1008 and b.m_id = m.m_id and b.b_acc_id = c.b_acc_id and b.m_actRetDt is null;
	-- order by Price;
	
	-------------------------- OR --------------------------
+-----------+-------+-------+--------+------+------+-----------+--------+------+--------+
| Book      | Accid | Accno | Member | M_Id | Type | IssuedOn  | Price  | T_Id | Author	|
+-----------+-------+-------+--------+------+------+-----------+--------+------+--------+
| Cpp Book  | 10002 |   102 | shubh  | 1008 | Fac. | Jul 16,19 | 300.00 |	1  | KalloG |
+-----------+-------+-------+--------+------+------+-----------+--------+------+--------+
| Java book | 10001 |   103 | shubh  | 1008 | Fac. | Jul 19,19 | 799.00 |	4  | Kaal   |
+-----------+-------+-------+--------+------+------+-----------+--------+------+--------+

	-------------------------- OR --------------------------

+-----------+-------+-------+--------+------+------+-----------+--------+------+--------+
| Book      | Accid | Accno | Member | M_Id | Type | IssuedOn  | Price  | t_id | Author |
+-----------+-------+-------+--------+------+------+-----------+--------+------+--------+
| Java book | 10001 |   103 | shubh  | 1008 | Fac. | Jul 19,19 | 799.00 |	2  | Lala	|
+-----------+-------+-------+--------+------+------+-----------+--------+------+--------+

	-------------------------- OR --------------------------

	Empty Set Returned : when No book is issued to This MemberId( 1008 ).
	
	
	
+-----------+-------+-----+--------+------+------+------+------------+----------------------------+
| Name      | Code  | Qty | Price  | Gone | Rack | M_Id | Date       | Reason                     |
+-----------+-------+-----+--------+------+------+------+------------+----------------------------+
| Java book | 10001 |   3 | 799.00 |    1 |    1 | 1004 | 2019-07-25 | NULL                       |
| Java book | 10001 |   3 | 799.00 |    1 |    1 | 1011 | 2019-07-25 | NULL                       |
| Cpp Book  | 10002 |   5 | 300.00 |   11 |    2 | 1001 | 2019-07-25 | Gandhi ji ko de diye       |
| Cpp 1.17  | 10003 |   5 | 100.00 |   11 |    3 | 1001 | 2019-07-25 | Reason is very funny ...:) |
+-----------+-------+-----+--------+------+------+------+------------+----------------------------+
4 rows in set (0.00 sec)

mysql> select * from bkdel;
+----+------+-------+-------+----------------------------+------------+
| id | m_id | accid | accno | reason                     | deldate    |
+----+------+-------+-------+----------------------------+------------+
|  1 | 1011 | 10001 |   101 | NULL                       | 2019-07-25 |
|  2 | 1004 | 10001 |   102 | NULL                       | 2019-07-25 |
|  3 | NULL | 10003 |   101 | Reason is very funny ...:) | 2019-07-25 |
|  4 | NULL | 10002 |   103 | Gandhi ji ko de diye       | 2019-07-25 |
+----+------+-------+-------+----------------------------+------------+
4 rows in set (0.47 sec)

mysql>