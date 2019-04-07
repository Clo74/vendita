CREATE DATABASE  IF NOT EXISTS `db_vendita` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `db_vendita`;
-- MySQL dump 10.16  Distrib 10.1.37-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: db_vendita
-- ------------------------------------------------------
-- Server version	10.1.37-MariaDB-0+deb9u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_negozi`
--

DROP TABLE IF EXISTS `t_negozi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_negozi` (
  `id_negozio` int(11) NOT NULL AUTO_INCREMENT,
  `descrizione` varchar(200) DEFAULT NULL,
  `indirizzo` varchar(100) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_negozio`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_negozi`
--

LOCK TABLES `t_negozi` WRITE;
/*!40000 ALTER TABLE `t_negozi` DISABLE KEYS */;
INSERT INTO `t_negozi` VALUES (1,'solo donna rivarolo','via roma 19 10010 torre canavese','0124/112255','mail@mail.it'),(2,'uomo ivrea','via palestro, 25 ivrea','0125/112255','mailivreal@mail.it');
/*!40000 ALTER TABLE `t_negozi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_prodotti`
--

DROP TABLE IF EXISTS `t_prodotti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_prodotti` (
  `id_prodotto` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(2) NOT NULL DEFAULT 'A',
  `descrizione` varchar(100) DEFAULT NULL,
  `prezzo_acq` decimal(6,2) NOT NULL,
  `prezzo_vend_netto` decimal(6,2) NOT NULL,
  `iva` int(11) NOT NULL DEFAULT '4',
  `prezzo_vend_lordo` decimal(6,2) NOT NULL,
  `qta` int(11) NOT NULL,
  PRIMARY KEY (`id_prodotto`),
  KEY `idx_desc` (`descrizione`),
  KEY `idx_tipo` (`tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_prodotti`
--

LOCK TABLES `t_prodotti` WRITE;
/*!40000 ALTER TABLE `t_prodotti` DISABLE KEYS */;
INSERT INTO `t_prodotti` VALUES (1,'A','mela rossa',10.50,18.30,4,20.00,1);
/*!40000 ALTER TABLE `t_prodotti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_scontrini_righe`
--

DROP TABLE IF EXISTS `t_scontrini_righe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_scontrini_righe` (
  `id_riga` int(11) NOT NULL AUTO_INCREMENT,
  `id_scontrino` int(11) NOT NULL,
  `id_prodotto` int(11) NOT NULL,
  `prezzo_vend_lordo` decimal(6,2) NOT NULL,
  `qta` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_riga`),
  KEY `idx_scont` (`id_scontrino`),
  KEY `idx_prod` (`id_prodotto`),
  CONSTRAINT `fk_prodotto` FOREIGN KEY (`id_prodotto`) REFERENCES `t_prodotti` (`id_prodotto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_scont` FOREIGN KEY (`id_scontrino`) REFERENCES `t_scontrini_testa` (`id_scontrino`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_scontrini_righe`
--

LOCK TABLES `t_scontrini_righe` WRITE;
/*!40000 ALTER TABLE `t_scontrini_righe` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_scontrini_righe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_scontrini_testa`
--

DROP TABLE IF EXISTS `t_scontrini_testa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_scontrini_testa` (
  `id_scontrino` int(11) NOT NULL AUTO_INCREMENT,
  `data_scontrino` varchar(45) NOT NULL DEFAULT 'DATELOCAL',
  `id_negozio` int(11) NOT NULL,
  PRIMARY KEY (`id_scontrino`),
  KEY `fk_negozio_idx` (`id_negozio`),
  CONSTRAINT `fk_negozio` FOREIGN KEY (`id_negozio`) REFERENCES `t_negozi` (`id_negozio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_scontrini_testa`
--

LOCK TABLES `t_scontrini_testa` WRITE;
/*!40000 ALTER TABLE `t_scontrini_testa` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_scontrini_testa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-07 21:49:32
