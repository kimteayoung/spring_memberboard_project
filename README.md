# 기능
회원가입
아이디,비밀번호,이름,이메일 입력

#일반 회원 로그인

아이디,비밀번호를 입력시 페이징 처리된 글목록 화면으로 이동
첫 인덱스 페이지에 로그아웃,마이페이지,글목록 화면 보임

#페이징 글목록

홈,글쓰기,로그아웃 호출가능
제목이나 작성자에대한 검색가능
작성자본인의 게시글에 대해서 삭제,수정가능
게시글 상세조회 클릭시 작성자 본인일 경우 삭제,수정,글목록 호출가능 (본인이 아닐시 글목록만 보임), (상세 조회시 조회수 +1)
댓글 입력시 작성자는 본인이름으로 자동입력되고 내용작성 후 등록가능 (댓글 번호, 작성자, 내용, 작성 시간이 보임)

#마이 페이지

일반 회원 로그인시 마이페이지 호출가능
회원가입 정보가 보이고 정보 수정가능 (이메일만 수정 가능 수정 클릭시 비밀번호가 맞지 않으면 alert가 뜸)

#관리자 로그인

로그인 시 첫 인덱스 화면에 전체 회원 목록이 보임
모든 회원의 글 삭제 가능

#전체회원목록

회원 삭제 가능
회원 정보 상세조회 가능

#완료 사이트 링크 

http://localhost:8081/member/logout

#DB 테이블

1.memberboard_table
회원가입시 입력했던 정보를 담음

2.memberboard_table2
글작성,글수정 페이지로 작성자, 제목, 내용을 입력시
입력한 값과 글번호,조회수,작성시간이 함께 담겨짐

3.memberboard_table3
댓글 입력페이지로 작성자,내용 입력시
입력한 값과 댓글번호,글번호,입력시간이 담겨짐




mysql 테이블
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


