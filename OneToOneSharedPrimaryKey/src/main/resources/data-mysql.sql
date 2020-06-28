
DROP TABLE IF EXISTS `driver`;
CREATE TABLE `driver` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

BEGIN;
INSERT INTO `driver` VALUES (1, '马江林');
COMMIT;



DROP TABLE IF EXISTS `vehicle`;
CREATE TABLE `vehicle` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `driver_id` bigint(20) NOT NULL,
  `license` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;
