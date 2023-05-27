-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bitdb
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `board` (
  `no` int NOT NULL AUTO_INCREMENT,
  `category_no` int NOT NULL DEFAULT '1',
  `writer` varchar(20) NOT NULL,
  `title` varchar(30) NOT NULL,
  `contents` varchar(1000) DEFAULT ' ',
  `filename` varchar(50) DEFAULT 'null',
  `regdate` datetime DEFAULT CURRENT_TIMESTAMP,
  `parent_no` int DEFAULT '0',
  `hit` int DEFAULT '0',
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (1,2,'test1','테스트글입니다.',' ','null','2023-05-15 21:30:32',0,0),(2,2,'test1','테스트글입니다2.',' ','null','2023-05-15 21:31:02',0,0),(3,2,'test1','테스트글입니다3.',' ','null','2023-05-15 21:31:14',0,0),(4,3,'test1','테스트글입니다.',' ','null','2023-05-17 17:35:13',0,0),(5,3,'test1','테스트글입니다.',' ','null','2023-05-17 17:35:14',0,0),(6,3,'test1','테스트글입니다.',' ','null','2023-05-17 17:35:14',0,0),(7,3,'test1','테스트글입니다.',' ','null','2023-05-17 17:35:15',0,0),(8,4,'test1','테스트글입니다.',' ','null','2023-05-17 17:35:16',0,0),(9,4,'test1','테스트글입니다.',' ','null','2023-05-17 17:35:16',0,0),(10,5,'test1','테스트글입니다.',' ','null','2023-05-17 17:35:16',0,1),(11,5,'test1','테스트글입니다.',' ','null','2023-05-17 17:35:17',0,0),(12,1,'test1','테스트글입니다.',' ','null','2023-05-17 17:35:17',0,0),(13,6,'test1','테스트글입니다.2',' ','null','2023-05-18 16:33:06',0,0),(14,7,'test1','테스트글입니다.2',' ','null','2023-05-18 16:33:18',0,0),(15,8,'test1','이불조아','이불안에들어가고싶다아아아<br>예아~','null','2023-05-18 16:33:21',0,1),(16,2,'test1','룰루랄라','까까오페이~','kakakopay.png','2023-05-18 16:33:23',0,0),(17,4,'test1','테스트글입니다.2','테스트입니다아아아아앙','null','2023-05-18 16:33:24',0,1),(18,6,'test1','포켓몬조아','예에에에에<br>파이어~','000501.png','2023-05-18 16:33:47',0,0),(19,5,'test1','꺼북왕','하이드로펌프~<br>포켓몬스터조아~<br>','000901.png','2023-05-18 16:33:55',0,0),(20,2,'test1','asdasd','asdasdasds','null','2023-05-23 09:49:15',0,0),(21,2,'test1','테스트입니다아아아아','으아앙아아아아아아아앙~','null','2023-05-23 10:02:39',0,0),(22,2,'test1','예아','테스틥니당','null','2023-05-23 10:04:20',0,0),(23,8,'test1','mysql','너무힘드러~','null','2023-05-23 10:06:54',0,0),(24,2,'test1','테스트입니다','테스트123','null','2023-05-23 10:10:56',0,2),(25,2,'test1','ㅁㄴㅇㄴㅁㅇ','ㅁㅇㅁㄴㅇㄴㅁㅇㄴㅇㄴㅁㄴㅇㅁㄴㅇ','null','2023-05-23 10:11:17',0,2),(26,2,'test1','ㅁㄴㅇㅁ','ㄴㅇㄴㅁㅇㅁㅇㅁ','null','2023-05-23 10:15:14',0,4),(28,2,'test1','풀날리기파바바ㅏㄱ','으앙아아앙집에가고싶어<br>예아아아아','000301.png','2023-05-23 19:13:36',0,7),(30,2,'admin','로그인테스트입니다.','예스으으으ㅡ<br>로그인대라<br>수정함','img.jpg','2023-05-26 09:42:35',0,49);
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `board_category`
--

DROP TABLE IF EXISTS `board_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `board_category` (
  `category_no` int NOT NULL,
  `category_name` varchar(20) NOT NULL,
  PRIMARY KEY (`category_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board_category`
--

LOCK TABLES `board_category` WRITE;
/*!40000 ALTER TABLE `board_category` DISABLE KEYS */;
INSERT INTO `board_category` VALUES (1,'Etc'),(2,'Java'),(3,'Javascript'),(4,'Html/CSS'),(5,'Servlet'),(6,'Spring'),(7,'Mybatis'),(8,'MySql');
/*!40000 ALTER TABLE `board_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `board_empathy`
--

DROP TABLE IF EXISTS `board_empathy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `board_empathy` (
  `no` int NOT NULL AUTO_INCREMENT,
  `board_no` int DEFAULT NULL,
  `cnt_like` int DEFAULT '0',
  `cnt_dislike` int DEFAULT '0',
  PRIMARY KEY (`no`),
  UNIQUE KEY `board_no` (`board_no`),
  CONSTRAINT `board_empathy_ibfk_1` FOREIGN KEY (`board_no`) REFERENCES `board` (`no`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board_empathy`
--

LOCK TABLES `board_empathy` WRITE;
/*!40000 ALTER TABLE `board_empathy` DISABLE KEYS */;
INSERT INTO `board_empathy` VALUES (1,19,5,0),(3,18,1,0),(4,16,0,1),(5,17,1,0),(6,15,0,1),(8,28,1,1),(10,26,0,1),(11,25,1,0),(12,24,2,0),(16,14,0,0),(17,30,2,0),(18,10,0,1);
/*!40000 ALTER TABLE `board_empathy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_empathy`
--

DROP TABLE IF EXISTS `user_empathy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_empathy` (
  `user_name` varchar(30) NOT NULL,
  `user_like` varchar(100) DEFAULT NULL,
  `user_scrap` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_name`),
  CONSTRAINT `user_emphaty_userid_ID_fk` FOREIGN KEY (`user_name`) REFERENCES `userid` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_empathy`
--

LOCK TABLES `user_empathy` WRITE;
/*!40000 ALTER TABLE `user_empathy` DISABLE KEYS */;
INSERT INTO `user_empathy` VALUES ('admin','@30',NULL),('asd','!28',NULL),('bit','@24,@30',NULL);
/*!40000 ALTER TABLE `user_empathy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userid`
--

DROP TABLE IF EXISTS `userid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userid` (
  `ID` varchar(20) NOT NULL,
  `PASSWORD` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `userid_pk` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userid`
--

LOCK TABLES `userid` WRITE;
/*!40000 ALTER TABLE `userid` DISABLE KEYS */;
INSERT INTO `userid` VALUES ('admin','1234'),('asd','1234'),('bit','1234'),('qwe','1234'),('test1','1234'),('test2','1234'),('zxc','1234');
/*!40000 ALTER TABLE `userid` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-27 14:22:01
