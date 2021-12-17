use spring_kty4;
drop table memberboard_table;
drop table memberboard_table2;
drop table memberboard_table3;
create table memberboard_table(
	m_number bigint auto_increment,
    m_id varchar(20),
    m_pw varchar(20),
    m_name varchar(20),
    m_email varchar(30),
	constraint primary key(m_number));
    
select * from memberboard_table;
    
    create table memberboard_table2(
   b_number bigint auto_increment,
    b_writer varchar(10),
    b_password varchar(20),
    b_title varchar(30),
    b_hits int default 0,
    b_contentsl varchar(2000),
    -- 시간 날짜!!
    b_date timestamp not null default current_timestamp,
    constraint primary key(b_number));
    
select * from memberboard_table2;
    
    create table memberboard_table3(
      c_number bigint auto_increment,
      b_number bigint,
      c_writer varchar(20),
      c_contentsl varchar(200),
      c_date datetime,
      constraint primary key(c_number));
    
select * from memberboard_table3;
    
    
    
    
    
    
    