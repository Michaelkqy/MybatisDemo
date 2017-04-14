use test;
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `dname` varchar(100) CHARACTER SET utf8 NOT NULL,
  `comments` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `ts` datetime NOT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


INSERT INTO `dept` VALUES ('1', '城管部', null, '2017-03-11 00:21:02');
SELECT * FROM dept;

DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `eid` int(11) NOT NULL AUTO_INCREMENT,
  `ename` varchar(30) CHARACTER SET utf8 NOT NULL,
  `did` int(11) NOT NULL,
  `comments` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `ts` datetime NOT NULL,
  PRIMARY KEY (`eid`),
  KEY `fk_empl_dept` (`did`),
  CONSTRAINT `fk_empl_dept` FOREIGN KEY (`did`) REFERENCES `dept` (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SELECT * FROM employee;

SELECT * from employee e INNER JOIN dept d on d.did=e.did  where e.ename='aa'; 