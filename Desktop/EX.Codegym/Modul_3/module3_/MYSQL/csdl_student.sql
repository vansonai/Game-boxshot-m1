create database manageStudent;
use manageStudent;

create table student(

    id int primary key auto_increment,
    name varchar(255),
    dateOfBirth date,
    email varchar(255),
    address varchar(255),
    phone int,
    classroom_id int,
    foreign key (classroom_id) references classroom(id)
);

create table classroom(

    id int primary key auto_increment,
    classroom varchar(255) unique
); 

insert into student(name, dateOfBirth,email,address,phone,classroom_id)
values("Tran Van Quyet","2001-07-23","tranvanquyet@gmail.com","Ha Noi",0989898765,1),
("Nguyen Duc Anh","2003-11-16","nducanh@gmail.com","Ha Giang",0378987768,1),
("Tran Quoc Bao","1995-02-09","quocbao@gmail.com","Can tho",0388987677,2),
("Nguyen Van Son","1988-05-09","vanson@gmail.com","Hai Duong",0989874322,3),
("Tran Lap","1999-03-27","tranlap@gmail.com","Ninh Binh",0987678555,3);

insert into classroom(classroom)
values("C0823H1"),
    ("C0723H1"),
    ("C0623H1");
