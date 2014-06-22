SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';
 
DROP SCHEMA IF EXISTS `jsf_spring_sec_default` ;
CREATE SCHEMA IF NOT EXISTS `jsf_spring_sec_default` DEFAULT CHARACTER SET latin1 ;
USE `jsf_spring_sec_default` ;
 
-- -----------------------------------------------------
-- Table `jsf_spring_sec_default`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jsf_spring_sec_default`.`users` ;
 
CREATE  TABLE IF NOT EXISTS `users` (
  `username` VARCHAR(50) NOT NULL ,
  `password` VARCHAR(50) NOT NULL ,
  `enabled` VARCHAR(50) NOT NULL ,
  PRIMARY KEY (`username`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;
 
-- -----------------------------------------------------
-- Table `jsf_spring_sec_default`.`authorities`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `authorities` ;
 
CREATE  TABLE IF NOT EXISTS `authorities` (
  `username` VARCHAR(50) NOT NULL ,
  `authority` VARCHAR(50) NOT NULL ,
  INDEX `fk_authorities_users` (`username` ASC) ,
  CONSTRAINT `fk_authorities_users`
    FOREIGN KEY (`username` )
    REFERENCES `users` (`username` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;
 
-- -----------------------------------------------------
-- Table `jsf_spring_sec_default`.`groups`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `groups` ;
 
CREATE  TABLE IF NOT EXISTS `groups` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `group_name` VARCHAR(50) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;
 
-- -----------------------------------------------------
-- Table `jsf_spring_sec_default`.`group_authorities`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `group_authorities` ;
 
CREATE  TABLE IF NOT EXISTS `group_authorities` (
  `group_id` INT(11) NOT NULL ,
  `authority` VARCHAR(50) NOT NULL ,
  PRIMARY KEY (`group_id`) ,
  INDEX `fk_group_authorities_group` (`group_id` ASC) ,
  CONSTRAINT `fk_group_authorities_group`
    FOREIGN KEY (`group_id` )
    REFERENCES `groups` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;
 
-- -----------------------------------------------------
-- Table `jsf_spring_sec_default`.`group_members`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `group_members` ;
 
CREATE  TABLE IF NOT EXISTS `group_members` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `username` VARCHAR(50) NOT NULL ,
  `group_id` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_group_members_group` (`id` ASC) ,
  CONSTRAINT `fk_group_members_group`
    FOREIGN KEY (`id` )
    REFERENCES `groups` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;
 
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `users` VALUES ('admin','admin','1'),('guest','guest','1');
 
INSERT INTO `authorities` VALUES ('admin','ROLE_USER'),('guest','ROLE_USER'),('admin','ROLE_ADMIN');
