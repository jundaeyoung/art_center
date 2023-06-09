
set foreign_key_checks=0;

INSERT INTO role_tb(role)
VALUES
	('user'),
	('manager'),
	('admin'),
	('teacher');
	
	
INSERT INTO user_tb(user_name, password, nickname, email, birth_date, tel, role_id)
VALUES
	('1', '$2a$10$Xbpckp1apx/cbwLjne5gw.Bj1mNFCf5dcFbYe9uEoiRfmw7DDMTt2', '김미정', 'kmj@naver.com' ,'19971217', '01011111111', 1),
	('2', '$2a$10$Xbpckp1apx/cbwLjne5gw.Bj1mNFCf5dcFbYe9uEoiRfmw7DDMTt2', '손주이', 'sji@naver.com' ,'19950119', '01022222222', 2),
	('3', '$2a$10$Xbpckp1apx/cbwLjne5gw.Bj1mNFCf5dcFbYe9uEoiRfmw7DDMTt2', '전대영', 'jdy@naver.com' ,'19971117', '01033333333', 3),
	('4', '$2a$10$Xbpckp1apx/cbwLjne5gw.Bj1mNFCf5dcFbYe9uEoiRfmw7DDMTt2', '편용림', 'pyr@naver.com' ,'19920208', '01044444444', 4);
	

INSERT INTO amdinNotice_tb(notice,user_id, admin_id)
values('님이 공연등록을 신청하였습니다.',2,3);


INSERT INTO managerNotice_tb(notice,user_id, admin_id)
values('신청 하신 공연등록이 승인 되었습니다.',2,3);

	
INSERT INTO location_tb(location, location_info)
VALUES
	('오페라하우스', '오페라 극장 4층 중 1~4층 무대 객석1 객석2 객석3'),
	('아트홀', '본관 전체 3층 중 1층 총 3개 전시실'),
	('아카데미', '본관 전체 3층 중 2~3층 총 5개 아카데미');
	
insert into time_tb (start_time, end_time)
values ('090000','210000'),
	   ('090000','120000'),
	   ('120000','150000'),
       ('150000','180000'),
       ('180000','210000');


INSERT INTO hole_tb(name,price,tel,location_id,time_id)
VALUES
	('1층','300000','051-332-1231', 1,1),
	('2층','500000','051-332-1231', 1,1),
	('3층','800000','051-332-1231', 1,1),
	('전시실A','100000','051-332-1232', 2,1),
	('전시실b','100000','051-332-1233', 2,1),
	('전시실c','100000','051-332-1234', 2,1),
	('전시실d','100000','051-332-1235', 2,1),
	('인문실','100000','051-332-1236', 3,2),
    ('인문실','100000','051-332-1236', 3,3),
    ('인문실','100000','051-332-1236', 3,4),
    ('인문실','100000','051-332-1236', 3,5),
	('과학실','100000','051-332-1237', 3,2),
    ('과학실','100000','051-332-1237', 3,3),
    ('과학실','100000','051-332-1237', 3,4),
    ('과학실','100000','051-332-1237', 3,5),
	('미술실','500000','051-332-1238', 3,2),
    ('미술실','500000','051-332-1238', 3,3),
    ('미술실','500000','051-332-1238', 3,4),
    ('미술실','500000','051-332-1238', 3,5),
	('어린이','100000','051-332-1239', 3,2),
    ('어린이','100000','051-332-1239', 3,3),
    ('어린이','100000','051-332-1239', 3,4),
    ('어린이','100000','051-332-1239', 3,5);


	
INSERT INTO category_tb(show_type)
VALUES
	('공연'),
	('전시회'),
	('아카데미');
	
	
INSERT INTO show_tb(img_route ,title, content, start_date, end_date, admission_age, adult_rate, youth_rate, infant_rate, organizer_id,show_type_id, hole_id,show_status)
VALUES
   ('마르쿠스 슈텐츠와 조슈아 벨.png','11시 콘서트','비 제 - 교향곡 제1번 다장조 1악장 생상스 - 첼로 협주곡 2번 라단조 Op.119 풀랑크 - 두 대의 피아노를 위한 협주곡 비 제 - <카르멘> 모음곡 제1번 & 제2번 발췌', '20230502','20230504','연령무관','50,000','30,000','10,000',2, 1 ,1,1),
   ('마르쿠스 슈텐츠와 조슈아 벨.png','2222222222222','비 제 - 교향곡 제1번 다장조 1악장 생상스 - 첼로 협주곡 2번 라단조 Op.119 풀랑크 - 두 대의 피아노를 위한 협주곡 비 제 - <카르멘> 모음곡 제1번 & 제2번 발췌', '20230502','20230504','연령무관','50,000','30,000','10,000',2, 1 ,1,0),
   ('미클로시 페레니.png','추남, 미녀','원작 아멜리 노통브의 소설「추남,미녀」를 무대화2019년에 이어 4년만에 앙코르 공연 「살인자의 건강법」「배고픔의 자서전」「오후 네시」 등 프랑스 베스트셀러 작가 아멜리 노통브가 샤를 페로의 동화 「도가머리 리케」를 재창작한「추남,미녀」 원작을 무대화한 작품으로2019년 예술의전당 자유소극장에서 국내 초연됐다.재능과 열정이 넘치는 배우! 스펙터클 무한변신 2인극 도전!남녀 주인공부터 그들을 둘러싼 주변 인물들까지 무대 위 두 명의 배우가 쉴 틈 없이 다역을 소화!데오다役 초연배우‘백석광’과 또 다른 매력을 보여줄‘김상보’트레미에르役‘김소이’,‘이지혜’가 각자의 개성을 살리며 편견 없는 진실과 자신의 가치를 발견하는 소중한 시간을 선사할 예정이다.', '20230428','20230501','15','40,000','35,000','5,000',2, 1 ,1,1),
<<<<<<< HEAD
   ('심청.png','많은 사람들','작가는 《많은 사람들》이란 프로젝트를 통해 미술관을 찾는 사람들이 레고와 같은 정형적 배열을 통해 입체화하는 것이 아닌 크고 작은 형태로 잘린 조각을 재배열하여 나만의 작품을 제작해보길 제안한다. 각자의 스토리를 만들고 작품을 제작하는 과정들을 유도하며 아이들의 자유분방함, 어질러짐, 앞뒤가 안 맞는 이야기들이 새로운 미술의 체계가 될 수 있음에 주목한다.
=======
	('미클로시 페레니.png','1111111111','원작 아멜리 노통브의 소설「추남,미녀」를 무대화2019년에 이어 4년만에 앙코르 공연 「살인자의 건강법」「배고픔의 자서전」「오후 네시」 등 프랑스 베스트셀러 작가 아멜리 노통브가 샤를 페로의 동화 「도가머리 리케」를 재창작한「추남,미녀」 원작을 무대화한 작품으로2019년 예술의전당 자유소극장에서 국내 초연됐다.재능과 열정이 넘치는 배우! 스펙터클 무한변신 2인극 도전!남녀 주인공부터 그들을 둘러싼 주변 인물들까지 무대 위 두 명의 배우가 쉴 틈 없이 다역을 소화!데오다役 초연배우‘백석광’과 또 다른 매력을 보여줄‘김상보’트레미에르役‘김소이’,‘이지혜’가 각자의 개성을 살리며 편견 없는 진실과 자신의 가치를 발견하는 소중한 시간을 선사할 예정이다.', '20230428','20230501','15','40,000','35,000','5,000',2, 1 ,1,0),
   ('심청.png','많은 사람들','작가는 《많은 사람들》이란 프로젝트를 통해 미술관을 찾는 사람들이 레고와 같은 정형적 배열을 통해 입체화하는 것이 아닌 크고 작은 형태로 잘린 조각을 재배열하여 나만의 작품을 제작해보길 제안한다. 각자의 스토리를 만들고 작품을 제작하는 과정들을 유도하며
    아이들의 자유분방함, 어질러짐, 앞뒤가 안 맞는 이야기들이 새로운 미술의 체계가 될 수 있음에 주목한다.
>>>>>>> feature/admin3
이번 전시의 프로젝트는 잘 만들었다 또는 못 만들었다는 기준이 없으며, 미술이라고 해도 되고, 아니라고 해도 되는, 딱히
 무엇이라고 말하지 않아도 되는 것을 실천하는 내용을 가지고 있다. 참여하는 어린이들이 기쁘고, 즐거운 마음으로 자신이 표현하고 싶은 
 것을 만들고, 그 안에서 뜻밖의 아름다움을 발견하는 계기가 되길 기대한다.', '20230506','20230510','연령무관','20,000','10,000','0',2, 2 ,4,1),   
 ('오페라 페스티벌.png','이우환 공간 상설전시','‘이우환 공간’은 1960년대부터 현재까지 이우환 예술의 진수를 감상할 수 있는 장소이다. 일본 나오시마에 이
 은 세계 두 번째의 이우환 개인미술관으로 입지 선정부터 건축 기본설계와 디자인까지 이우환 작가가 직접 참여했다. 공간 건립 당시 현장을
 방문해 건물 높이와 공간 구성을 비롯하여 마감재, 조명, 집기에 이르기까지 세부 설계와 작품 한 점 한 점의 섬세한 설치에 무한한 열정을 담아냈다.
이우환 작가는 “ ‘이우환 공간’은 공간 자체를 하나의 작품으로 감상할 수 있어 타 미술 공간과는 다른 독특한 특징을 지니고 있다.”라고 이야
기한 바 있다. ‘이우환 공간’은 건물 자체가 하나의 예술품으로, 공간과 작품 어느 한쪽으로 치우치지 않고 모두를 함께 보여주고자 하는 선생의 소망이 투영
된 곳이다.', '20230406','20230411','연령무관','20,000','10,000','0',2, 2 ,5,1),
('테스트코레오그라피.png','뚝딱뚝딱 도형마술사','부산시립미술관에서는 어린이를 대상으로 올바른 미술관 관람문화 조성을 위해
귀여운 캐릭터와 함께 미술관을 보호하고 탐험하는 수호자가 되어 즐겁게 관람예절을 배우고
미술관 문화를 건강하게 즐길 수 있는 프로그램을 준비하였습니다.
프로그램 완료 시 미술관 굿즈도 제공되니 많은 참여 바랍니다.', '20230504','20230505','유치부, 초등 저학년','0','0','5,000',2, 3 ,11,1),
('마르쿠스 슈텐츠와 조슈아 벨.png','손주이의 즹즹 콘서트','비 제 - 교향곡 제1번 다장조 1악장 생상스 - 첼로 협주곡 2번 라단조 Op.119 풀랑크 - 두 대의 피아노를 위한 협주곡 비 제 - <카르멘> 모음곡 제1번 & 제2번 발췌', '20230508','20230509','연령무관','50,000','30,000','10,000',2, 1 ,9,1);


-- 고정데이터
-- 좌석 정보
INSERT INTO seat_tb(hole_id,seat_name)
VALUES (1,'R1'),
(1,'R2'),
(1,'R3'),
(1,'R4'),
(1,'R5'),
(1,'S6'),
(1,'S7'),
(1,'S8'),
(1,'S9'),
(1,'S10'),
(1,'S11'),
(1,'S12'),
(1,'S13'),
(1,'S14'),
(1,'S15'),
(2,'R1'),
(2,'R2'),
(2,'R3'),
(2,'R4'),
(2,'R5'),
(2,'S6'),
(2,'S7'),
(2,'S8'),
(2,'S9'),
(2,'S10'),
(2,'S11'),
(2,'S12'),
(2,'S13'),
(2,'S14'),
(2,'S15'),
(3,'R1'),
(3,'R2'),
(3,'R3'),
(3,'R4'),
(3,'R5'),
(3,'S6'),
(3,'S7'),
(3,'S8'),
(3,'S9'),
(3,'S10'),
(3,'S11'),
(3,'S12'),
(3,'S13'),
(3,'S14'),
(3,'S15');

INSERT INTO age_group_tb(age_group)
VALUES
	('infant (5~13)'),
	('youth (14~19)'),
	('adult (20~)');

INSERT INTO show_datetime_tb(show_date, show_time , show_id, hole_id)
VALUES ('20230520', '17:00', 1,1),
('20230520', '19:00', 1,1),
('20230521', '18:00', 1,1),
('20230521', '19:00', 1,1),
('20230522', '18:00', 1,1),
('20230522', '19:00', 1,1),
('20230525', '19:00', 2,1),
('20230525', '20:00', 2,1),
('20230526', '20:00', 2,1),
('20230527', '19:00', 2,1),
('20230528', '19:00', 2,1),
('20230528', '20:00', 2,1),
('20230528', '17:00', 3,4),
('20230528', '19:00', 3,4),
('20230529', '16:00', 3,4),
('20230529', '18:00', 3,4),
('20230529', '20:00', 3,4),
('20230530', '18:00', 3,4),
('20230530', '20:00', 3,4),
('20230531', '17:00', 3,4),
('20230531', '19:00', 3,4),
('20230601', '17:30', 3,4),
('20230601', '20:00', 3,4),
('20230519', '18:00', 4,5),
('20230519', '19:00', 4,5),
('20230520', '17:00', 4,5),
('20230520', '18:00', 4,5),
('20230520', '19:00', 4,5),
('20230521', '19:00', 4,5),
('20230521', '20:00', 4,5),
('20230522', '19:00', 4,5),
('20230522', '20:00', 4,5),
('20230523', '18:00', 4,5),
('20230523', '19:00', 4,5),
('20230523', '20:00', 4,5),
('20230525', '11:00', 5,11),
('20230525', '12:00', 5,11),
('20230525', '13:00', 5,11),
('20230525', '16:00', 5,11),
('20230525', '17:00', 5,11),
('20230525', '18:00', 5,11),
('20230526', '11:00', 5,11),
('20230526', '12:00', 5,11),
('20230526', '13:00', 5,11),
('20230526', '16:00', 5,11),
('20230526', '17:00', 5,11),
('20230526', '18:00', 5,11),
('20230531','17:00', 6,9),
('20230531','18:00',6,9);

INSERT INTO ticketing_tb(user_id, seat_id, show_time_id, age_group_id)
VALUES
   (1, 13,1,3),
   (1, 14,1,3),
   (1, 15,1,2),
   (1, 25,2,3),
   (1, 40,3,3),
   (1, null,4,3),
   (1, null,5,2),   
   (2, 12,1,3),
   (2, 10,1,3),
   (2, 16,2,3),
   (2, 41,3,3),
   (2, null,4,3),
   (2, null,5,2),   
   (3, 11,1,3),
   (3, 17,2,3),
   (3, 35,3,3),
   (3, null,4,3),
   (3, null,5,3);

INSERT INTO payment_tb(user_id, payment_option, ticketing1_id, ticketing2_id, ticketing3_id, ticketing4_id)
VALUES (1, '카드결제', 1, 2, 3, null ),
(1, '카드결제', 4, null, null, null ),
(1, '계좌결제', 5, null, null, null ),
(1, '카드결제', 6, null, null, null ),
(1, '카드결제', 7, null, null, null ),
(2, '카드결제', 8, null, null, null ),
(2, '카드결제', 8, null, null, null ),
(2, '카드결제', 9, 10, null, null ),
(2, '카드결제', 11, null, null, null );  
	
INSERT INTO review_tb(content,rating, user_id, show_id)
VALUES
	('주인공 역할하시는 배우님이 맘에안들었어요.',1,1,1),
	('헐 나만 그생각한게 아니였어',2,3,1),
	('다시는 안감',3,4,1),
	('재밌었어요 지인들한테 추천할만해요',3,1,2),
	('와 진짜 인생 연극이었어요',5,3,2),
	('여운이 가시질 않았어요.',4,4,2),
    ('너무 지루해요..',1,1,3),
	('헐 나만 그생각한게 아니였어',2,3,3),
	('다시는 안감',2,4,3),
	('재밌었어요 지인들한테 추천할만해요',4,1,4),
	('와 진짜 인생 전시회였어요',5,3,4),
	('여운이 가시질 않았어요.',5,4,4),
	('애들이 좋아하네요.',5,1,5),
	('아이가 좋아해요.',5,3,5),
	('그냥그래요.',4,4,5);
	
	
INSERT INTO wish_list_tb(user_id, show_id)
VALUES
	(1,1),
	(1,2),
	(1,3),
	(1,4),
	(1,5);
	
	
INSERT INTO question_category_tb(question_type)
VALUES
	('안내'),
	('대관'),
	('아카데미'),
	('모집');
	
INSERT INTO question_tb(title, content, user_id, question_type_id)
VALUES
	('주차장 있나요?','주차장 있나요?',1,1),
	('대관 신청?','대관 신청 어떻게 하나요?',1,2),
	('아카데미 질문입니다.','아카데미 연령 제한 있나요? 저희애가 4살이라.. 너무 어린가 해서요',1,3),
	('작품공모전','이번달에 작품공모전 있을까요?',1,4);
	
INSERT INTO answer_tb(content, user_id, question_id)
VALUES
	('네 주차장 있습니다.',3,1),
	('대관신청은 홈페이지 대관 신청 페이지로 들어가면 자세히 적혀있습니다.',3,2),
	('어떤 아카데미인가에 따라 다른데 지금 진행중인 아카데미는 전부 6세 이상입니다.',3,3),
	('이번달은 없고 다음달초에 작품공모전 있을 예정입니다.',3,4);
	

INSERT INTO rent_place_reservation_tb(start_date,end_date,start_time,end_time, hole_id,location_id)
VALUES
	('20230510','20230520','090000','120000',10,3),
	('20230515','20230520',null,null,1,1),
	('20230520','20230530',null,null,5,2),
	('20230525','20230610','090000','120000',11,3),
	('20230529','20230620',null,null,6,2),
	('20230601','20230622','090000','120000',11,3),
	('20230603','20230624','090000','120000',11,3);
	
INSERT INTO class_registration_tb(user_id,academy_id)
VALUES
	(1,5),
	(1,5),
	(1,5),
	(1,5),
	(1,5),
	(1,5),
	(1,5);
	
INSERT INTO announcement(title, content, user_id)
values
	('제목','콘텐트',3),
	('제목제목제목제목제목제목제','콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트',3),
	('제목제목제목제목제목제목','콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트',3),
	('제목제목제목제','콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트',3),
	('제목제목제','콘콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트콘텐트텐트',3);
    
	