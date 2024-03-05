CREATE DATABASE  IF NOT EXISTS `emenu` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `emenu`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: emenu
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `username` varchar(20) NOT NULL,
  `password` varchar(30) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `email` varchar(30) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('1','1','1','1');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bill` (
  `bill_ID` int unsigned NOT NULL AUTO_INCREMENT,
  `client_ID` int unsigned NOT NULL,
  `table_ID` int unsigned NOT NULL,
  `bill_date` date DEFAULT NULL,
  `total_price` double NOT NULL,
  PRIMARY KEY (`bill_ID`),
  KEY `table_ID` (`table_ID`),
  KEY `client_ID` (`client_ID`),
  CONSTRAINT `bill_ibfk_1` FOREIGN KEY (`table_ID`) REFERENCES `tables` (`table_ID`),
  CONSTRAINT `bill_ibfk_2` FOREIGN KEY (`client_ID`) REFERENCES `client` (`client_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `client_ID` int unsigned NOT NULL AUTO_INCREMENT,
  `client_name` varchar(50) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `dob` date DEFAULT NULL,
  PRIMARY KEY (`client_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'Xuan Huy ','0973772793','0026-05-24'),(2,'Tung Nguyen','0123456789','2004-05-24'),(3,'Toan Dinh','0987654321','2008-12-04'),(4,'Quan Nguyen','0123987456','1989-08-20');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dish`
--

DROP TABLE IF EXISTS `dish`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dish` (
  `dish_ID` int unsigned NOT NULL AUTO_INCREMENT,
  `dish_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `price` double NOT NULL,
  `availability` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `made_price` double NOT NULL,
  `image_link` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `stock` int DEFAULT NULL,
  PRIMARY KEY (`dish_ID`),
  KEY `idx_dish_name` (`dish_name`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dish`
--

LOCK TABLES `dish` WRITE;
/*!40000 ALTER TABLE `dish` DISABLE KEYS */;
INSERT INTO `dish` VALUES (1,'Pho',30000,'Availability',10000,'C:\\Users\\SamGau\\Desktop\\z5117056334035_e3e7065fae2c66926b4ed534607e998d.jpg',1),(2,'Pizza',150000,'1',50000,NULL,NULL),(3,'Taco',80000,'1',25000,NULL,NULL),(4,'Su-shi',90000,'0',30000,NULL,NULL),(5,'Salad Ceasar',90000,'1',25000,NULL,NULL),(6,'Russian Salad',50000,'1',12000,NULL,NULL),(7,'Beef Steak',50000,'1',30000,NULL,NULL),(8,'Cao Lau',60000,'1',20000,NULL,NULL),(9,'Caviar',500000,'0',300000,NULL,NULL),(10,'Alaska King Crab',1000000,'1',350000,NULL,NULL),(11,'Root beer',20000,'1',10000,NULL,NULL),(12,'Red Wine',300000,'1',158000,NULL,NULL),(13,'Coca-Cola',15000,'1',5000,NULL,NULL),(14,'Sake',150000,'1',60000,NULL,NULL),(15,'Green Tea',20000,'1',2000,NULL,NULL),(16,'Iced Tea',5000,'1',300,NULL,NULL),(17,'French Fries',50000,'1',15000,NULL,NULL),(18,'Cake',30000,'1',12000,NULL,NULL),(19,'Pudding',20000,'1',14000,NULL,NULL),(20,'Cream Puff',15000,'1',3000,NULL,NULL),(21,'Seafood Soup',15000,'1',8000,NULL,NULL),(22,'Pumpkin Soup',20000,'1',7000,NULL,NULL),(23,'Cheese Rolls',50000,'1',15000,NULL,NULL);
/*!40000 ALTER TABLE `dish` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `emp_ID` int unsigned NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(50) NOT NULL,
  `position` varchar(45) NOT NULL,
  `department` varchar(50) NOT NULL,
  `salary` double NOT NULL,
  `image` varchar(1000) NOT NULL,
  PRIMARY KEY (`emp_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (2,'huy','Manage','Kitchen',2,'C:\\\\Users\\\\SamGau\\\\Desktop\\\\z5117056334035_e3e7065fae2c66926b4ed534607e998d.jpg'),(3,'hoang anh','Manage','Kitchen',2,'C:\\\\\\\\Users\\\\\\\\SamGau\\\\\\\\Desktop\\\\\\\\z5117056334035_e3e7065fae2c66926b4ed534607e998d.jpg');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `table_ID` int unsigned DEFAULT NULL,
  `dish_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `quantity` int DEFAULT NULL,
  KEY `fk_dish_name` (`dish_name`),
  CONSTRAINT `fk_dish_name` FOREIGN KEY (`dish_name`) REFERENCES `dish` (`dish_name`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`dish_name`) REFERENCES `dish` (`dish_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (4,'Pho',3),(4,'Su-shi',3),(4,'Salad Ceasar',3),(1,'Pizza',3),(1,'Su-shi',3),(1,'Cao Lau',3);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tables`
--

DROP TABLE IF EXISTS `tables`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tables` (
  `table_ID` int unsigned NOT NULL AUTO_INCREMENT,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`table_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tables`
--

LOCK TABLES `tables` WRITE;
/*!40000 ALTER TABLE `tables` DISABLE KEYS */;
INSERT INTO `tables` VALUES (1,'in-use'),(2,'available'),(3,'available'),(4,'in-use'),(5,'available'),(6,'available'),(7,'available'),(8,'available');
/*!40000 ALTER TABLE `tables` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `types`
--

DROP TABLE IF EXISTS `types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `types` (
  `type_ID` int unsigned NOT NULL AUTO_INCREMENT,
  `type_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`type_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `types`
--

LOCK TABLES `types` WRITE;
/*!40000 ALTER TABLE `types` DISABLE KEYS */;
INSERT INTO `types` VALUES (1,'Main'),(2,'Drinks'),(3,'Dessert'),(4,'Appetizer'),(5,'Salad');
/*!40000 ALTER TABLE `types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `types_dish`
--

DROP TABLE IF EXISTS `types_dish`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `types_dish` (
  `dish_ID` int unsigned NOT NULL AUTO_INCREMENT,
  `type_ID` int unsigned DEFAULT NULL,
  KEY `dish_ID` (`dish_ID`),
  KEY `type_ID` (`type_ID`),
  CONSTRAINT `types_dish_ibfk_1` FOREIGN KEY (`dish_ID`) REFERENCES `dish` (`dish_ID`),
  CONSTRAINT `types_dish_ibfk_2` FOREIGN KEY (`type_ID`) REFERENCES `types` (`type_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `types_dish`
--

LOCK TABLES `types_dish` WRITE;
/*!40000 ALTER TABLE `types_dish` DISABLE KEYS */;
INSERT INTO `types_dish` VALUES (1,1),(2,1),(3,1),(4,1),(5,5),(6,5),(7,1),(8,1),(9,3),(10,1),(11,2),(12,2),(13,2),(14,2),(15,2),(16,2),(17,4),(18,3),(19,3),(20,3),(21,4),(22,4),(23,4);
/*!40000 ALTER TABLE `types_dish` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-05 13:50:10
