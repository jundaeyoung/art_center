
-- user, manager, admin, teacher
CREATE TABLE role_tb(
   id INT PRIMARY KEY AUTO_INCREMENT,
   role VARCHAR(10) NOT NULL
);

-- 유저
CREATE TABLE user_tb(
   id INT PRIMARY KEY AUTO_INCREMENT,
   user_name VARCHAR (255) NOT NULL UNIQUE,
   password VARCHAR (200) NOT NULL,
   nickname VARCHAR (30) NOT NULL UNIQUE,
   email VARCHAR (100) NOT NULL,
   birth_date DATE NOT NULL,
   tel VARCHAR (50) NOT NULL,
   role_id int DEFAULT 1,
   api_id VARCHAR(255) UNIQUE,
   FOREIGN KEY (role_id) REFERENCES role_tb (id) ON UPDATE CASCADE ON DELETE CASCADE
);

-- 장소 ex) 오페라하우스
CREATE TABLE location_tb(
   id INT PRIMARY KEY AUTO_INCREMENT,
   location VARCHAR (100) NOT NULL,
   location_info VARCHAR (200) NOT NULL
);

-- 홀 ex) a,b,c,d,e
CREATE TABLE hole_tb(
   id INT PRIMARY KEY AUTO_INCREMENT,
   name VARCHAR (100) NOT NULL,
   price VARCHAR (100),
   tel VARCHAR (30) NOT NULL,
   location_id INT NOT NULL,
   FOREIGN KEY (location_id) REFERENCES location_tb (id) ON UPDATE CASCADE ON DELETE CASCADE
);

-- show 종류
CREATE TABLE category_tb(
   id INT PRIMARY KEY AUTO_INCREMENT,
   show_type VARCHAR (50) NOT NULL
);

-- 공연
CREATE TABLE show_tb(
   id INT PRIMARY KEY AUTO_INCREMENT,
   img_route VARCHAR (200) NOT NULL,
   title VARCHAR (100) NOT NULL,
   content TEXT NOT NULL,
   start_date date NOT NULL,
   end_date date NOT NULL,
   admission_age VARCHAR (100) NOT NULL,
   adult_rate VARCHAR (30) NOT NULL,
   youth_rate VARCHAR (30) NOT NULL,
   infant_rate VARCHAR (30) NOT NULL,
   organizer_id INT NOT NULL,
   hole_id INT NOT NULL,
   show_type_id INT NOT NULL,
   show_status TINYINT NOT NULL DEFAULT 0,
   FOREIGN KEY (organizer_id) REFERENCES user_tb (id) ON UPDATE CASCADE ON DELETE CASCADE,
   FOREIGN KEY (show_type_id) REFERENCES category_tb (id) ON UPDATE CASCADE ON DELETE CASCADE,
   FOREIGN KEY (hole_id) REFERENCES hole_tb (id) ON UPDATE CASCADE ON DELETE CASCADE
);


-- 좌석 정보
create table if not exists seat_tb(
	seat_id int primary key auto_increment,
    level varchar(20) not null,
    seat_num int not null,
    reserv_state tinyint(1) default 0
);

-- 상영시간
CREATE TABLE show_datetime_tb(
   id INT PRIMARY KEY AUTO_INCREMENT,
   show_date DATE NOT NULL,
   show_time TIME NOT NULL,
   show_id INT NOT NULL,
   foreign key (show_id) references show_tb (id) ON UPDATE CASCADE ON DELETE CASCADE
);

-- 관람평
CREATE TABLE review_tb(
   id INT PRIMARY KEY AUTO_INCREMENT,
   content TEXT NOT NULL,
   review_creation_date TIMESTAMP DEFAULT now(),
   rating INT NOT NULL,
   user_id INT NOT NULL,
   show_id INT NOT NULL,
   FOREIGN KEY (user_id) REFERENCES user_tb (id) ON UPDATE CASCADE ON DELETE CASCADE,
   FOREIGN KEY (show_id) REFERENCES show_tb (id) ON UPDATE CASCADE ON DELETE CASCADE
);

-- 찜목록
CREATE TABLE wish_list_tb(
   id INT PRIMARY KEY AUTO_INCREMENT,
   user_id INT NOT NULL,
   show_id INT NOT NULL,
   FOREIGN KEY (user_id) REFERENCES user_tb (id) ON UPDATE CASCADE ON DELETE CASCADE,
   FOREIGN KEY (show_id) REFERENCES show_tb (id) ON UPDATE CASCADE ON DELETE CASCADE
);

-- 질문 카테고리
CREATE TABLE question_category_tb(
   id INT PRIMARY KEY AUTO_INCREMENT,
   question_type VARCHAR (30) NOT NULL
);

-- 질문
CREATE TABLE question_tb(
   id INT PRIMARY KEY AUTO_INCREMENT,
   title varchar (100) NOT NULL,
   content TEXT NOT NULL,
   answer_status TINYINT NOT NULL default 0,
   user_id INT NOT NULL,
   question_type_id INT NOT NULL,
   FOREIGN KEY (question_type_id) REFERENCES question_category_tb (id) ON UPDATE CASCADE ON DELETE CASCADE,
   FOREIGN KEY (user_id) REFERENCES user_tb (id) ON UPDATE CASCADE ON DELETE CASCADE
);

-- 답글
CREATE TABLE answer_tb(
   id INT PRIMARY KEY AUTO_INCREMENT,
   content TEXT NOT NULL,
   user_id INT NOT NULL,
   question_id INT NOT NULL,
   FOREIGN KEY (user_id) REFERENCES user_tb (id) ON UPDATE CASCADE ON DELETE CASCADE,
   FOREIGN KEY (question_id) REFERENCES question_tb (id) ON UPDATE CASCADE ON DELETE CASCADE
);

-- 유아, 청소년, 성인
CREATE TABLE age_group_tb(
   id INT PRIMARY KEY AUTO_INCREMENT,
   age_group VARCHAR (20) NOT NULL
);

-- 전시회 예매
CREATE TABLE ticketing_tb(
   id INT PRIMARY KEY AUTO_INCREMENT,
   ticketing_date TIMESTAMP DEFAULT now(),
   user_id INT NOT NULL,
   show_time_id INT NOT NULL,
   age_group_id INT NOT NULL,
   FOREIGN KEY (user_id) REFERENCES user_tb (id) ON UPDATE CASCADE ON DELETE CASCADE,
   FOREIGN KEY (show_time_id) REFERENCES show_datetime_tb (id) ON UPDATE CASCADE ON DELETE CASCADE,
   FOREIGN KEY (age_group_id) REFERENCES age_group_tb (id) ON UPDATE CASCADE ON DELETE CASCADE
);

-- 대관 예약
CREATE TABLE rent_place_reservation_tb(
   id INT PRIMARY KEY AUTO_INCREMENT,
   start_date DATE DEFAULT (current_date),
   end_date DATE DEFAULT (current_date),
   reservation_date DATETIME DEFAULT now(),
   user_id INT NOT NULL,
   hole_id INT NOT NULL,
   FOREIGN KEY (user_id) REFERENCES user_tb (id) ON UPDATE CASCADE ON DELETE CASCADE,
   FOREIGN KEY (hole_id) REFERENCES hole_tb (id) ON UPDATE CASCADE ON DELETE CASCADE
);

-- 아카데미 신청
CREATE TABLE class_registration_tb(
   id INT PRIMARY KEY AUTO_INCREMENT,
   class_registration_date DATETIME DEFAULT now(),
   user_id INT NOT NULL,
   academy_id INT NOT NULL,
   FOREIGN KEY (user_id) REFERENCES user_tb (id) ON UPDATE CASCADE ON DELETE CASCADE,
   FOREIGN KEY (academy_id) REFERENCES show_tb (id) ON UPDATE CASCADE ON DELETE CASCADE
);

-- 공지사항
CREATE TABLE announcement(
   id INT PRIMARY KEY AUTO_INCREMENT,
   title VARCHAR (100) NOT NULL,
   content TEXT NOT NULL,
   created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
   user_id INT NOT NULL,
   FOREIGN KEY (user_id) REFERENCES user_tb (id) ON UPDATE CASCADE ON DELETE CASCADE
);