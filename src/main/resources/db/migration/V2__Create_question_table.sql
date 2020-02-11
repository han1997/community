create table question
(
	id bigint auto_increment,
	title varchar(50),
	description text,
	gmt_create bigint,
	gmt_modified bigint,
	creator bigint,
	comment_count bigint default 0,
	view_count bigint default 0,
	like_count bigint default 0,
	tag varchar(256),
	constraint question_pk
		primary key (id)
)
comment '问题';