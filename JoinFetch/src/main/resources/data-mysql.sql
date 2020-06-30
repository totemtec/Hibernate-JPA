DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(60) NOT NULL,
  `isbn` varchar(60) NOT NULL,
  `author_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;


BEGIN;
INSERT INTO `book` VALUES (1, 'A History of Ancient Prague', '001-JN', 4);
INSERT INTO `book` VALUES (2, 'A Peoples History', '002-JN', 4);
INSERT INTO `book` VALUES (3, 'The Beatles Anthology', '001-MJ', 1);
INSERT INTO `book` VALUES (4, 'Carrie', '001-OG', 2);
COMMIT;

DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  `genre` varchar(60) DEFAULT NULL,
  `name` varchar(60) NOT NULL,
  PRIMARY KEY (`id`)
) ;

BEGIN;
INSERT INTO `author` VALUES (1, 23, 'Anthology', 'Mark Janel');
INSERT INTO `author` VALUES (2, 43, 'Horror', 'Olivia Goy');
INSERT INTO `author` VALUES (3, 51, 'Anthology', 'Quartis Young');
INSERT INTO `author` VALUES (4, 34, 'History', 'Joana Nimar');
INSERT INTO `author` VALUES (5, 38, 'Anthology', 'Alicia Tom');
INSERT INTO `author` VALUES (6, 56, 'Anthology', 'Katy Loin');
COMMIT;