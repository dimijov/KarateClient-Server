/*
SQLyog Community v13.1.9 (64 bit)
MySQL - 10.4.22-MariaDB : Database - karate
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`karate` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `karate`;

/*Table structure for table `clan` */

DROP TABLE IF EXISTS `clan`;

CREATE TABLE `clan` (
  `clanID` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `prezime` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `datumRodjenja` date NOT NULL,
  `adresa` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `brojTelefona` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `gradID` int(11) NOT NULL,
  `grupaID` int(11) NOT NULL,
  PRIMARY KEY (`clanID`),
  KEY `grad_fk` (`gradID`),
  KEY `grupaclan_fk` (`grupaID`),
  CONSTRAINT `grad_fk` FOREIGN KEY (`gradID`) REFERENCES `grad` (`gradID`),
  CONSTRAINT `grupaclan_fk` FOREIGN KEY (`grupaID`) REFERENCES `grupa` (`grupaID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `clan` */

insert  into `clan`(`clanID`,`ime`,`prezime`,`datumRodjenja`,`adresa`,`brojTelefona`,`gradID`,`grupaID`) values 
(1,'Zoran','Pantelic','1996-10-21','Dositejava 22','+38162589931',4,4),
(2,'Dusan','Kovacevic','2010-06-30','Nemanjina 43','+381629358834',3,1),
(8,'Aleksa','Simonovic','2000-10-21','Limanska 90','+381655432199',3,3),
(9,'Borko','Stekic','1996-05-01','Knjeginje Milice 23','+38162645590',2,4),
(11,'Vuk','Manojlovic','2000-06-21','Vojvode Stepe 320','+381652241043',2,2),
(13,'Joca','Separevic','1985-10-20','Bezanijska kosa','+381692844944',1,1),
(14,'Petar','Petrovic','2000-01-21','Kostolacka 82','+381643381457',1,3);

/*Table structure for table `grad` */

DROP TABLE IF EXISTS `grad`;

CREATE TABLE `grad` (
  `gradID` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `postanskiBroj` int(11) NOT NULL,
  PRIMARY KEY (`gradID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `grad` */

insert  into `grad`(`gradID`,`naziv`,`postanskiBroj`) values 
(1,'Beograd',11000),
(2,'Jagodina',35000),
(3,'Novi Sad',21000),
(4,'Nis',18000),
(5,'Pancevo',26000);

/*Table structure for table `grupa` */

DROP TABLE IF EXISTS `grupa`;

CREATE TABLE `grupa` (
  `grupaID` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`grupaID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `grupa` */

insert  into `grupa`(`grupaID`,`naziv`) values 
(1,'Pocetnicka grupa'),
(2,'Srednja grupa'),
(3,'Napredna grupa'),
(4,'Takmicarska grupa');

/*Table structure for table `sala` */

DROP TABLE IF EXISTS `sala`;

CREATE TABLE `sala` (
  `salaID` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `kapacitet` int(11) NOT NULL,
  PRIMARY KEY (`salaID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `sala` */

insert  into `sala`(`salaID`,`naziv`,`kapacitet`) values 
(1,'Sala 1',20),
(2,'Sala 2',25),
(3,'Dojo sala',10),
(4,'Tatami sala',15);

/*Table structure for table `stavkatreninga` */

DROP TABLE IF EXISTS `stavkatreninga`;

CREATE TABLE `stavkatreninga` (
  `rbStavke` int(11) NOT NULL,
  `treningID` int(11) NOT NULL,
  `brojPonavljanja` int(11) NOT NULL,
  `tezina` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `trajanje` int(11) NOT NULL,
  `vezbaID` int(11) NOT NULL,
  PRIMARY KEY (`rbStavke`,`treningID`),
  KEY `vezba_fk` (`vezbaID`),
  KEY `trening_fk` (`treningID`),
  CONSTRAINT `trening_fk` FOREIGN KEY (`treningID`) REFERENCES `trening` (`treningID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `vezba_fk` FOREIGN KEY (`vezbaID`) REFERENCES `vezba` (`vezbaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `stavkatreninga` */

insert  into `stavkatreninga`(`rbStavke`,`treningID`,`brojPonavljanja`,`tezina`,`trajanje`,`vezbaID`) values 
(1,2,5,'Srednje',50,1),
(1,8,6,'Tesko',72,3),
(1,9,5,'Tesko',60,1),
(1,10,9,'Tesko',108,3),
(1,11,6,'Tesko',72,3),
(1,12,3,'Srednje',30,1),
(1,13,4,'Srednje',40,3),
(1,14,5,'Tesko',50,4),
(1,16,9,'Tesko',63,5),
(1,17,3,'Srednje',30,3),
(1,18,5,'Lako',15,2),
(2,2,5,'Srednje',25,2),
(2,8,2,'Lako',16,1),
(2,9,2,'Lako',10,6),
(2,10,2,'Tesko',18,6),
(2,12,3,'Srednje',24,4),
(2,13,2,'Srednje',10,5),
(2,14,2,'Lako',36,7),
(2,16,3,'Srednje',21,6),
(2,17,7,'Tesko',84,1),
(2,18,5,'Srednje',40,4),
(3,2,2,'Lako',12,4),
(3,9,4,'Srednje',40,3),
(3,10,1,'Tesko',22,7),
(3,13,3,'Tesko',66,7),
(3,14,2,'Lako',16,1),
(3,16,1,'Srednje',10,1);

/*Table structure for table `trener` */

DROP TABLE IF EXISTS `trener`;

CREATE TABLE `trener` (
  `trenerID` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `prezime` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `godineIskustva` int(11) NOT NULL,
  `pojas` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`trenerID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `trener` */

insert  into `trener`(`trenerID`,`ime`,`prezime`,`godineIskustva`,`pojas`,`username`,`password`) values 
(1,'Dimitrije','Jovanovic',5,'braon','dimijo','dimidimi'),
(2,'Stefan','Milosavljevic',10,'braon','steevs','stisti'),
(3,'Marko','Milosevic',2,'plavi','panta4','1312'),
(4,'Bogoljub','Zivic',15,'crni','bogonoob','bogisha');

/*Table structure for table `trening` */

DROP TABLE IF EXISTS `trening`;

CREATE TABLE `trening` (
  `treningID` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `datumVreme` datetime NOT NULL,
  `trajanje` int(11) NOT NULL,
  `trenerID` int(11) NOT NULL,
  `grupaID` int(11) NOT NULL,
  `salaID` int(11) NOT NULL,
  PRIMARY KEY (`treningID`),
  KEY `trener_fk` (`trenerID`),
  KEY `grupa_fk` (`grupaID`),
  KEY `sala_fk` (`salaID`),
  CONSTRAINT `grupa_fk` FOREIGN KEY (`grupaID`) REFERENCES `grupa` (`grupaID`),
  CONSTRAINT `sala_fk` FOREIGN KEY (`salaID`) REFERENCES `sala` (`salaID`),
  CONSTRAINT `trener_fk` FOREIGN KEY (`trenerID`) REFERENCES `trener` (`trenerID`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `trening` */

insert  into `trening`(`treningID`,`naziv`,`datumVreme`,`trajanje`,`trenerID`,`grupaID`,`salaID`) values 
(2,'Srednja 1 nedelja','2023-05-13 18:30:00',87,4,2,3),
(8,'Proba 1','2023-05-14 11:00:00',88,4,4,1),
(9,'Srednja ispit','2023-05-25 12:00:00',110,3,1,2),
(10,'Blic test','2023-05-26 14:00:00',148,4,3,2),
(11,'Borbe','2023-05-26 16:00:00',72,3,1,3),
(12,'Timski sparing','2023-05-27 17:00:00',54,3,3,3),
(13,'Srednje practice','2023-05-20 18:00:00',116,2,2,3),
(14,'Proba 11','2023-06-30 12:00:00',102,1,1,3),
(16,'Teske borbe','2023-06-06 14:00:00',94,1,4,3),
(17,'Uvod','2023-06-14 11:00:00',114,1,1,2),
(18,'Proba','2023-06-30 10:00:00',55,1,1,2);

/*Table structure for table `vezba` */

DROP TABLE IF EXISTS `vezba`;

CREATE TABLE `vezba` (
  `vezbaID` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `opis` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `duzina` int(11) NOT NULL,
  PRIMARY KEY (`vezbaID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `vezba` */

insert  into `vezba`(`vezbaID`,`naziv`,`opis`,`duzina`) values 
(1,'Kihon','Osnovne tehnike',10),
(2,'Kata','Koreografija pokreta',5),
(3,'Kumite','Borba sa partnerom',10),
(4,'Bunkai','Primena tehnika iz kate',8),
(5,'Yakusoku','Borba tri napadaca',5),
(6,'Gohon','Borba pet napadaca',7),
(7,'Sanbon','Borba slobodnom tehnikom',20);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
