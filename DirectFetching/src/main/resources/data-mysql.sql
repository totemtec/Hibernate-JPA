DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  `genre` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

BEGIN;
INSERT INTO `author` VALUES (1, 23, 'Anthology', 'Mark Janel');
INSERT INTO `author` VALUES (2, 43, 'Horror', 'Olivia Goy');
COMMIT;
