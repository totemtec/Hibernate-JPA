DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

BEGIN;
INSERT INTO `employee` VALUES (2, '马江林');
INSERT INTO `employee` VALUES (3, '史密斯');
INSERT INTO `employee` VALUES (4, '布什');
INSERT INTO `employee` VALUES (5, '乔治');
COMMIT;


DROP TABLE IF EXISTS `work_station`;
CREATE TABLE `work_station` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `workstation_number` bigint(20) DEFAULT NULL,
  `floor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

BEGIN;
INSERT INTO `work_station` VALUES (30, 303, '3层');
INSERT INTO `work_station` VALUES (40, 404, '4层');
INSERT INTO `work_station` VALUES (50, 505, '5层');
INSERT INTO `work_station` VALUES (60, 606, '6层');
COMMIT;


DROP TABLE IF EXISTS `emp_workstation`;
CREATE TABLE `emp_workstation` (
  `employee_id` bigint(20) NOT NULL,
  `workstation_id` bigint(20) NOT NULL
) ;

BEGIN;
INSERT INTO `emp_workstation` VALUES (2, 30);
INSERT INTO `emp_workstation` VALUES (3, 40);
INSERT INTO `emp_workstation` VALUES (4, 50);
INSERT INTO `emp_workstation` VALUES (5, 60);
COMMIT;
