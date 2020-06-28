DROP TABLE IF EXISTS `vehicle`;
CREATE TABLE `vehicle` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `license` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

BEGIN;
INSERT INTO `vehicle` VALUES (10, '冀FSL670');
INSERT INTO `vehicle` VALUES (20, '京ABCDEF');
COMMIT;

DROP TABLE IF EXISTS `driver`;
CREATE TABLE `driver` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) DEFAULT NULL,
  `vehicle_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

BEGIN;
INSERT INTO `driver` VALUES (1, '马江林', 20);
INSERT INTO `driver` VALUES (2, '那谁谁', 10);
COMMIT;
