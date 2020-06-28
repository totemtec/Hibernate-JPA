
DROP TABLE IF EXISTS `driver`;
CREATE TABLE `driver` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) DEFAULT NULL,
  `vehicle_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;



DROP TABLE IF EXISTS `vehicle`;
CREATE TABLE `vehicle` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `license` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;
