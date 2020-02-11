create table comment
(
	id bigint auto_increment,
	parent_id bigint not null,
	type int not null,
	commentator bigint not null,
	content varchar(1024),
    comment_count bigint default 0 null,
	gmt_create bigint not null,
	gmt_modeified bigint not null,
	like_count bigint default 0 null,
	constraint comment_pk
		primary key (id)
)
comment '回复';

