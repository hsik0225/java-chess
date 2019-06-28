-- MySQL Script generated by MySQL Workbench
-- Tue Jun 25 20:37:47 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema chess
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema chess
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `chess` DEFAULT CHARACTER SET utf8 ;
USE `chess` ;

-- -----------------------------------------------------
-- Table `chess`.`Game`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chess`.`Game` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `pieces` VARCHAR(200) NULL,
  `turn` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

/* 체스판 초기화 */
INSERT INTO chess.Game (pieces) VALUES ("RNBQKBNR\nPPPPPPPP\n........\n........\n........\n........\npppppppp\nrnbqkbnr\n");