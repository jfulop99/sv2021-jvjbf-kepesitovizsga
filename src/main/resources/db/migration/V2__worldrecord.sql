create table world_record
(
    id      bigint auto_increment,
    description varchar(255) not null,
    value   double not null ,
    unit_of_measure varchar(255) not null ,
    date_of_record  date not null ,
    recorder_id bigint not null ,
    primary key (id),
    foreign key (recorder_id) references recorder(id)
)