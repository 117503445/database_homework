INSERT INTO `dbhomework`.`rule`(`rule_id`,`max_bi_xiu_failed_credit`,`max_ren_xuan_failed_credit`,`max_xian_xuan_failed_credit`,`min_bi_xiu_credit`,`min_ren_xuan_credit`,`min_xian_xuan_credit`) VALUES (1,10,30,20,22,10,6);

INSERT INTO `dbhomework`.`college`(`college_id`, `name`) VALUES (1, "网络与信息安全");
INSERT INTO `dbhomework`.`college`(`college_id`, `name`) VALUES (2, "应用数学与统计");

INSERT INTO `dbhomework`.`subject`(`subject_id`,`name`,`college_id`) VALUES (1,"网络空间安全",1);
INSERT INTO `dbhomework`.`subject`(`subject_id`,`name`,`college_id`) VALUES (2,"应用数学",2);

INSERT INTO `dbhomework`.`class`(`class_id`,`class_name`,`rule_id`,`subject_id`) VALUES (1,"1818039",1,"1");
INSERT INTO `dbhomework`.`class`(`class_id`,`class_name`,`rule_id`,`subject_id`) VALUES (2,"1807021",1,"2");
INSERT INTO `dbhomework`.`class`(`class_id`,`class_name`,`rule_id`,`subject_id`) VALUES (3,"1807022",1,"2");

INSERT INTO `dbhomework`.`teacher`(`teacher_id`,`is_male`,`name`) VALUES (1,true,"张语一");
INSERT INTO `dbhomework`.`teacher`(`teacher_id`,`is_male`,`name`) VALUES (2,true,"张语二");
INSERT INTO `dbhomework`.`teacher`(`teacher_id`,`is_male`,`name`) VALUES (3,true,"张语三");
INSERT INTO `dbhomework`.`teacher`(`teacher_id`,`is_male`,`name`) VALUES (4,false,"张数一");
INSERT INTO `dbhomework`.`teacher`(`teacher_id`,`is_male`,`name`) VALUES (5,true,"张数二");
INSERT INTO `dbhomework`.`teacher`(`teacher_id`,`is_male`,`name`) VALUES (6,true,"张数三");
INSERT INTO `dbhomework`.`teacher`(`teacher_id`,`is_male`,`name`) VALUES (7,true,"张英一");
INSERT INTO `dbhomework`.`teacher`(`teacher_id`,`is_male`,`name`) VALUES (8,false,"张英二");
INSERT INTO `dbhomework`.`teacher`(`teacher_id`,`is_male`,`name`) VALUES (9,false,"张英三");
INSERT INTO `dbhomework`.`teacher`(`teacher_id`,`is_male`,`name`) VALUES (10,true,"张限一");
INSERT INTO `dbhomework`.`teacher`(`teacher_id`,`is_male`,`name`) VALUES (11,true,"张限二");
INSERT INTO `dbhomework`.`teacher`(`teacher_id`,`is_male`,`name`) VALUES (12,true,"张限三");
INSERT INTO `dbhomework`.`teacher`(`teacher_id`,`is_male`,`name`) VALUES (13,false,"张任一");
INSERT INTO `dbhomework`.`teacher`(`teacher_id`,`is_male`,`name`) VALUES (14,true,"张任二");
INSERT INTO `dbhomework`.`teacher`(`teacher_id`,`is_male`,`name`) VALUES (15,true,"张任三");

INSERT INTO `dbhomework`.`student`(`student_id`,`birth_date`,`is_male`,`name`,`student_num`,`class_id`) VALUES (1,968688000,true,"张宇恺","18180100102",1);
INSERT INTO `dbhomework`.`student`(`student_id`,`birth_date`,`is_male`,`name`,`student_num`,`class_id`) VALUES (2,953740800,true,"齐浩天","18079100004",1);
INSERT INTO `dbhomework`.`student`(`student_id`,`birth_date`,`is_male`,`name`,`student_num`,`class_id`) VALUES (3,957801600,true,"伍松","18079100007",2);
INSERT INTO `dbhomework`.`student`(`student_id`,`birth_date`,`is_male`,`name`,`student_num`,`class_id`) VALUES (4,963158400,false,"陈昆","18070300011",3);



INSERT INTO `dbhomework`.`course`(`course_id`,`credit`,`name`,`type`,`class_id`,`teacher_id`) VALUES (1,10,"语文",0,1,1);
INSERT INTO `dbhomework`.`course`(`course_id`,`credit`,`name`,`type`,`class_id`,`teacher_id`) VALUES (2,10,"数学",0,1,4);
INSERT INTO `dbhomework`.`course`(`course_id`,`credit`,`name`,`type`,`class_id`,`teacher_id`) VALUES (3,8,"英语",0,1,7);
INSERT INTO `dbhomework`.`course`(`course_id`,`credit`,`name`,`type`,`class_id`,`teacher_id`) VALUES (4,10,"限选",1,1,10);
INSERT INTO `dbhomework`.`course`(`course_id`,`credit`,`name`,`type`,`class_id`,`teacher_id`) VALUES (5,6,"任选",2,1,13);

INSERT INTO `dbhomework`.`course`(`course_id`,`credit`,`name`,`type`,`class_id`,`teacher_id`) VALUES (6,10,"语文",0,2,2);
INSERT INTO `dbhomework`.`course`(`course_id`,`credit`,`name`,`type`,`class_id`,`teacher_id`) VALUES (7,10,"数学",0,2,5);
INSERT INTO `dbhomework`.`course`(`course_id`,`credit`,`name`,`type`,`class_id`,`teacher_id`) VALUES (8,8,"英语",0,2,8);
INSERT INTO `dbhomework`.`course`(`course_id`,`credit`,`name`,`type`,`class_id`,`teacher_id`) VALUES (9,10,"限选",1,2,11);
INSERT INTO `dbhomework`.`course`(`course_id`,`credit`,`name`,`type`,`class_id`,`teacher_id`) VALUES (10,6,"任选",2,2,14);

INSERT INTO `dbhomework`.`course`(`course_id`,`credit`,`name`,`type`,`class_id`,`teacher_id`) VALUES (11,10,"语文",0,3,3);
INSERT INTO `dbhomework`.`course`(`course_id`,`credit`,`name`,`type`,`class_id`,`teacher_id`) VALUES (12,10,"数学",0,3,6);
INSERT INTO `dbhomework`.`course`(`course_id`,`credit`,`name`,`type`,`class_id`,`teacher_id`) VALUES (13,8,"英语",0,3,9);
INSERT INTO `dbhomework`.`course`(`course_id`,`credit`,`name`,`type`,`class_id`,`teacher_id`) VALUES (14,10,"限选",1,3,12);
INSERT INTO `dbhomework`.`course`(`course_id`,`credit`,`name`,`type`,`class_id`,`teacher_id`) VALUES (15,6,"任选",2,3,15);



INSERT INTO `dbhomework`.`guide`(`score_id`,`first_score`,`second_score`,`course_id`,`student_id`) VALUES (1,100,-1,1,1);
INSERT INTO `dbhomework`.`guide`(`score_id`,`first_score`,`second_score`,`course_id`,`student_id`) VALUES (2,100,-1,2,1);
INSERT INTO `dbhomework`.`guide`(`score_id`,`first_score`,`second_score`,`course_id`,`student_id`) VALUES (3,100,-1,3,1);
INSERT INTO `dbhomework`.`guide`(`score_id`,`first_score`,`second_score`,`course_id`,`student_id`) VALUES (4,100,-1,4,1);
INSERT INTO `dbhomework`.`guide`(`score_id`,`first_score`,`second_score`,`course_id`,`student_id`) VALUES (5,100,-1,5,1);

INSERT INTO `dbhomework`.`guide`(`score_id`,`first_score`,`second_score`,`course_id`,`student_id`) VALUES (6,100,-1,1,2);
INSERT INTO `dbhomework`.`guide`(`score_id`,`first_score`,`second_score`,`course_id`,`student_id`) VALUES (7,100,-1,2,2);
INSERT INTO `dbhomework`.`guide`(`score_id`,`first_score`,`second_score`,`course_id`,`student_id`) VALUES (8,100,-1,3,2);
INSERT INTO `dbhomework`.`guide`(`score_id`,`first_score`,`second_score`,`course_id`,`student_id`) VALUES (9,100,-1,4,2);
INSERT INTO `dbhomework`.`guide`(`score_id`,`first_score`,`second_score`,`course_id`,`student_id`) VALUES (10,100,-1,5,2);

INSERT INTO `dbhomework`.`guide`(`score_id`,`first_score`,`second_score`,`course_id`,`student_id`) VALUES (11,100,-1,6,3);
INSERT INTO `dbhomework`.`guide`(`score_id`,`first_score`,`second_score`,`course_id`,`student_id`) VALUES (12,100,-1,7,3);
INSERT INTO `dbhomework`.`guide`(`score_id`,`first_score`,`second_score`,`course_id`,`student_id`) VALUES (13,59,59,8,3);
INSERT INTO `dbhomework`.`guide`(`score_id`,`first_score`,`second_score`,`course_id`,`student_id`) VALUES (14,100,-1,9,3);
INSERT INTO `dbhomework`.`guide`(`score_id`,`first_score`,`second_score`,`course_id`,`student_id`) VALUES (15,100,-1,10,3);

INSERT INTO `dbhomework`.`guide`(`score_id`,`first_score`,`second_score`,`course_id`,`student_id`) VALUES (16,100,-1,11,4);
INSERT INTO `dbhomework`.`guide`(`score_id`,`first_score`,`second_score`,`course_id`,`student_id`) VALUES (17,59,59,12,4);
INSERT INTO `dbhomework`.`guide`(`score_id`,`first_score`,`second_score`,`course_id`,`student_id`) VALUES (18,100,-1,13,4);
INSERT INTO `dbhomework`.`guide`(`score_id`,`first_score`,`second_score`,`course_id`,`student_id`) VALUES (19,100,-1,14,4);
INSERT INTO `dbhomework`.`guide`(`score_id`,`first_score`,`second_score`,`course_id`,`student_id`) VALUES (20,100,-1,15,4);