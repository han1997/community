create table notification
(
	id bigint auto_increment,
	notifier bigint not null,
	notifier_name varchar(100) not null,
	receiver int not null,
	outer_id bigint not null,
	outer_title varchar(50) not null,
	type int not null,
	gmt_create bigint not null,
	status int default 0 not null,
	constraint notification_pk
		primary key (id)
)
