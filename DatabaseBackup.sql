CREATE DATABASE  IF NOT EXISTS `fishgame` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `fishgame`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: fishgame
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country` (
  `CountryID` int NOT NULL AUTO_INCREMENT,
  `Country` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`CountryID`),
  UNIQUE KEY `CountryID_UNIQUE` (`CountryID`)
) ENGINE=InnoDB AUTO_INCREMENT=196 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'Afghanistan'),(2,'Albania'),(3,'Algeria'),(4,'Andorra'),(5,'Angola'),(6,'Antigua and Barbuda'),(7,'Argentina'),(8,'Armenia'),(9,'Australia'),(10,'Austria'),(11,'Azerbaijan'),(12,'Bahamas'),(13,'Bahrain'),(14,'Bangladesh'),(15,'Barbados'),(16,'Belarus'),(17,'Belgium'),(18,'Belize'),(19,'Benin'),(20,'Bhutan'),(21,'Bolivia'),(22,'Bosnia and Herzegovina'),(23,'Botswana'),(24,'Brazil'),(25,'Brunei'),(26,'Bulgaria'),(27,'Burkina Faso'),(28,'Burundi'),(29,'Côted Ivoire'),(30,'Cabo Verde'),(31,'Cambodia'),(32,'Cameroon'),(33,'Canada'),(34,'Central African Republic'),(35,'Chad'),(36,'Chile'),(37,'China'),(38,'Colombia'),(39,'Comoros'),(40,'Congo (Congo-Brazzaville)'),(41,'Costa Rica'),(42,'Croatia'),(43,'Cuba'),(44,'Cyprus'),(45,'Czechia (CzechRepublic)'),(46,'Democratic Republic of the Congo'),(47,'Denmark'),(48,'Djibouti'),(49,'Dominica'),(50,'Dominican Republic'),(51,'Ecuador'),(52,'Egypt'),(53,'El Salvador'),(54,'Equatorial Guinea'),(55,'Eritrea'),(56,'Estonia'),(57,'Eswatini'),(58,'Ethiopia'),(59,'Fiji'),(60,'Finland'),(61,'France'),(62,'Gabon'),(63,'Gambia'),(64,'Georgia'),(65,'Germany'),(66,'Ghana'),(67,'Greece'),(68,'Grenada'),(69,'Guatemala'),(70,'Guinea'),(71,'Guinea-Bissau'),(72,'Guyana'),(73,'Haiti'),(74,'HolySee'),(75,'Honduras'),(76,'Hungary'),(77,'Iceland'),(78,'India'),(79,'Indonesia'),(80,'Iran'),(81,'Iraq'),(82,'Ireland'),(83,'Israel'),(84,'Italy'),(85,'Jamaica'),(86,'Japan'),(87,'Jordan'),(88,'Kazakhstan'),(89,'Kenya'),(90,'Kiribati'),(91,'Kuwait'),(92,'Kyrgyzstan'),(93,'Laos'),(94,'Latvia'),(95,'Lebanon'),(96,'Lesotho'),(97,'Liberia'),(98,'Libya'),(99,'Liechtenstein'),(100,'Lithuania'),(101,'Luxembourg'),(102,'Madagascar'),(103,'Malawi'),(104,'Malaysia'),(105,'Maldives'),(106,'Mali'),(107,'Malta'),(108,'Marshall Islands'),(109,'Mauritania'),(110,'Mauritius'),(111,'Mexico'),(112,'Micronesia'),(113,'Moldova'),(114,'Monaco'),(115,'Mongolia'),(116,'Montenegro'),(117,'Morocco'),(118,'Mozambique'),(119,'Myanmar'),(120,'Namibia'),(121,'Nauru'),(122,'Nepal'),(123,'Netherlands'),(124,'New Zealand'),(125,'Nicaragua'),(126,'Niger'),(127,'Nigeria'),(128,'North Korea'),(129,'North Macedonia'),(130,'Norway'),(131,'Oman'),(132,'Pakistan'),(133,'Palau'),(134,'Palestine State'),(135,'Panama'),(136,'Papua New Guinea'),(137,'Paraguay'),(138,'Peru'),(139,'Philippines'),(140,'Poland'),(141,'Portugal'),(142,'Qatar'),(143,'Romania'),(144,'Russia'),(145,'Rwanda'),(146,'Saint Kitts and Nevis'),(147,'Saint Lucia'),(148,'Saint Vincent and the Grenadines'),(149,'Samoa'),(150,'San Marino'),(151,'Sao Tomeand Principe'),(152,'Saudi Arabia'),(153,'Senegal'),(154,'Serbia'),(155,'Seychelles'),(156,'Sierra Leone'),(157,'Singapore'),(158,'Slovakia'),(159,'Slovenia'),(160,'Solomon Islands'),(161,'Somalia'),(162,'South Africa'),(163,'South Korea'),(164,'South Sudan'),(165,'Spain'),(166,'SriLanka'),(167,'Sudan'),(168,'Suriname'),(169,'Sweden'),(170,'Switzerland'),(171,'Syria'),(172,'Tajikistan'),(173,'Tanzania'),(174,'Thailand'),(175,'Timor-Leste'),(176,'Togo'),(177,'Tonga'),(178,'Trinidad and Tobago'),(179,'Tunisia'),(180,'Turkey'),(181,'Turkmenistan'),(182,'Tuvalu'),(183,'Uganda'),(184,'Ukraine'),(185,'United Arab Emirates'),(186,'United Kingdom'),(187,'United States'),(188,'Uruguay'),(189,'Uzbekistan'),(190,'Vanuatu'),(191,'Venezuela'),(192,'Vietnam'),(193,'Yemen'),(194,'Zambia'),(195,'Zimbabwe');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leaderboard`
--

DROP TABLE IF EXISTS `leaderboard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `leaderboard` (
  `LeaderBoardID` int NOT NULL AUTO_INCREMENT,
  `PlayerID` int NOT NULL,
  `CountryID` int NOT NULL,
  `Score` double NOT NULL,
  PRIMARY KEY (`LeaderBoardID`),
  UNIQUE KEY `LeaderBoardID_UNIQUE` (`LeaderBoardID`),
  KEY `fk_Leaderboard_Player_idx` (`PlayerID`),
  KEY `fk_Leaderboard_Country1_idx` (`CountryID`),
  CONSTRAINT `fk_Leaderboard_Country1` FOREIGN KEY (`CountryID`) REFERENCES `country` (`CountryID`),
  CONSTRAINT `fk_Leaderboard_Player` FOREIGN KEY (`PlayerID`) REFERENCES `player` (`PlayerID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leaderboard`
--

LOCK TABLES `leaderboard` WRITE;
/*!40000 ALTER TABLE `leaderboard` DISABLE KEYS */;
INSERT INTO `leaderboard` VALUES (1,1,43,5.11),(2,2,187,33.33),(3,3,43,15.27),(4,1,38,4.63),(5,1,1,5.97),(6,4,3,84.78),(7,5,1,39.02),(8,6,1,20),(9,7,1,34.78),(10,8,2,17.24),(11,9,2,18.6),(12,1,51,6.73),(13,10,14,42.05),(14,1,21,38.34),(15,1,3,21.95),(16,1,4,21.88),(17,1,6,10.71),(18,7,12,1.16),(19,11,6,61.54),(20,11,3,92.21);
/*!40000 ALTER TABLE `leaderboard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player`
--

DROP TABLE IF EXISTS `player`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `player` (
  `PlayerID` int NOT NULL AUTO_INCREMENT,
  `Gamertag` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`PlayerID`),
  UNIQUE KEY `PlayerID_UNIQUE` (`PlayerID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player`
--

LOCK TABLES `player` WRITE;
/*!40000 ALTER TABLE `player` DISABLE KEYS */;
INSERT INTO `player` VALUES (1,'walkiejvc'),(2,'sodabutty'),(3,'juane'),(4,'asdfds'),(5,'walaa'),(6,'walla'),(7,'walki'),(8,'logic'),(9,'walkie'),(10,'randomtext'),(11,'asdasd');
/*!40000 ALTER TABLE `player` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `population`
--

DROP TABLE IF EXISTS `population`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `population` (
  `PopulationID` int NOT NULL AUTO_INCREMENT,
  `CounterZero` int DEFAULT NULL,
  `CounterOne` int DEFAULT NULL,
  `CounterTwo` int DEFAULT NULL,
  `CounterThree` int DEFAULT NULL,
  `CounterFour` int DEFAULT NULL,
  `CounterFive` int DEFAULT NULL,
  `CounterSix` int DEFAULT NULL,
  `CounterSeven` int DEFAULT NULL,
  `CounterEight` int DEFAULT NULL,
  PRIMARY KEY (`PopulationID`),
  UNIQUE KEY `idFishSettings_UNIQUE` (`PopulationID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `population`
--

LOCK TABLES `population` WRITE;
/*!40000 ALTER TABLE `population` DISABLE KEYS */;
INSERT INTO `population` VALUES (1,0,2,4,1,0,1,2,0,0),(2,2,4,1,0,1,2,0,0,0),(3,4,1,0,1,2,0,2,0,0),(4,1,0,1,2,0,2,4,0,0),(5,0,1,2,0,2,4,1,0,0),(6,1,2,0,2,4,1,0,0,0),(7,2,0,2,4,1,0,1,0,0),(8,1,0,3,1,2,0,1,0,0),(9,0,3,1,2,0,1,1,0,0),(10,3,1,2,0,1,1,0,0,0),(11,1,2,0,1,1,0,3,0,0),(12,2,0,1,1,0,3,1,0,0),(13,0,1,1,0,3,1,2,0,0),(14,1,1,0,3,1,2,0,0,0);
/*!40000 ALTER TABLE `population` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'fishgame'
--

--
-- Dumping routines for database 'fishgame'
--
/*!50003 DROP PROCEDURE IF EXISTS `ClearDatabase` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `ClearDatabase`()
BEGIN
	SET SQL_SAFE_UPDATES = 0;

	DELETE FROM Leaderboard;
    DELETE FROM Player;
    
    ALTER TABLE Leaderboard AUTO_INCREMENT = 1;
	ALTER TABLE Player AUTO_INCREMENT = 1;
    
    SET SQL_SAFE_UPDATES = 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GetAllCountries` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetAllCountries`()
BEGIN
	SELECT Country FROM Country;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GetInitialPopulation` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetInitialPopulation`(_populationID INT)
BEGIN
	SELECT PopulationID FROM Population WHERE PopulationID = _populationID;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GetNumberOfPopulations` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetNumberOfPopulations`()
BEGIN
	SELECT COUNT(*) FROM Population;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GetPopulation` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetPopulation`(_populationID INT)
BEGIN
	SELECT 
		CounterZero AS `Counter0`, 
		CounterOne AS `Counter1`, 
		CounterTwo AS `Counter2`, 
		CounterThree AS `Counter3`, 
		CounterFour AS `Counter4`, 
		CounterFive AS `Counter5`, 
		CounterSix AS `Counter6`,
        CounterSeven AS `Counter7`,
        CounterEight AS `Counter8`
	FROM Population
    WHERE PopulationID = _populationID;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GetPopulationsCount` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetPopulationsCount`()
BEGIN
	SELECT COUNT(*) AS `Count` FROM Population;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `GetTopTwenty` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetTopTwenty`()
BEGIN
	SELECT ROW_NUMBER() OVER (ORDER BY MIN(Score)) as `Placement`, Gamertag, Country, MIN(Score) AS `Score`
	FROM Leaderboard 
	INNER JOIN Player, Country
	WHERE Leaderboard.PlayerID = Player.PlayerID AND Leaderboard.CountryID = Country.CountryID
	group by Gamertag
	ORDER BY Score
    Limit 20;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `InsertNewAttempt` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertNewAttempt`(_gamertag VARCHAR(25), _country VARCHAR(100), _percentageError DOUBLE)
BEGIN
	SET @_countryID = (SELECT CountryID FROM Country WHERE Country = _country);

	IF EXISTS(SELECT Gamertag FROM Player WHERE Gamertag = _gamertag) THEN
		SET @_playerID = (SELECT PlayerID FROM Player WHERE Gamertag = _gamertag);
	ELSE
		INSERT INTO Player (Gamertag)
        VALUES(_gamerTag);
        
        SET @_playerID = (SELECT PlayerID FROM Player WHERE Gamertag = _gamertag);
	END IF;
    
    IF EXISTS (SELECT PlayerID, CountryID FROM Leaderboard WHERE PlayerID = @_playerID AND CountryID = @_countryID) THEN
		IF(SELECT Score FROM Leaderboard WHERE PlayerID = @_playerID AND CountryID = @_countryID) > _percentageError THEN
			UPDATE Leaderboard
			SET Score = _percentageError
			WHERE PlayerID = @_playerID AND CountryID = @_countryID;
		END IF;
	ELSE
		INSERT INTO Leaderboard (PlayerID, CountryID, Score)
        VALUES(@_playerID, @_countryID, _percentageError);
	END IF;
    
    SELECT MIN(a.Score) AS 'PersonalBest', MIN(b.Score) AS 'NationalBest', MIN(c.Score) AS 'WorldwideBest'
		FROM Leaderboard a JOIN Leaderboard b JOIN Leaderboard c
		WHERE a.PlayerID = @_playerID AND b.CountryID = @_countryID;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-13 21:09:35
