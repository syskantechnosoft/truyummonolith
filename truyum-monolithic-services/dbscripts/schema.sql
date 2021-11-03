SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `truyum_fse` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `truyum_fse` ;

-- -----------------------------------------------------
-- Table `truyum_fse`.`menu_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `truyum_fse`.`menu_item` ;

CREATE  TABLE IF NOT EXISTS `truyum_fse`.`menu_item` (
  `me_id` INT NOT NULL AUTO_INCREMENT ,
  `me_name` VARCHAR(100) NULL ,
  `me_price` DOUBLE NULL ,
  `me_active` TINYINT(1) NULL ,
  `me_date_of_launch` DATE NULL ,
  `me_category` VARCHAR(45) NULL ,
  `me_free_delivery` TINYINT(1) NULL ,
  `me_url` VARCHAR(200) NULL ,
  PRIMARY KEY (`me_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `truyum_fse`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `truyum_fse`.`user` ;

CREATE  TABLE IF NOT EXISTS `truyum_fse`.`user` (
  `us_id` INT NOT NULL AUTO_INCREMENT ,
  `us_name` VARCHAR(60) NULL ,
  `us_password` VARCHAR(100) NULL ,
  `us_first_name` VARCHAR(45) NULL ,
  `us_last_name` VARCHAR(45) NULL ,
  PRIMARY KEY (`us_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `truyum_fse`.`cart`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `truyum_fse`.`cart` ;

CREATE  TABLE IF NOT EXISTS `truyum_fse`.`cart` (
  `ct_id` INT NOT NULL AUTO_INCREMENT ,
  `ct_pr_id` INT NULL ,
  `ct_us_id` INT NULL ,
  PRIMARY KEY (`ct_id`) ,
  INDEX `fk_cart_menu_item` (`ct_pr_id` ASC) ,
  INDEX `fk_cart_user1` (`ct_us_id` ASC) ,
  CONSTRAINT `fk_cart_menu_item`
    FOREIGN KEY (`ct_pr_id` )
    REFERENCES `truyum_fse`.`menu_item` (`me_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cart_user1`
    FOREIGN KEY (`ct_us_id` )
    REFERENCES `truyum_fse`.`user` (`us_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `truyum_fse`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `truyum_fse`.`role` ;

CREATE  TABLE IF NOT EXISTS `truyum_fse`.`role` (
  `ro_id` INT NOT NULL AUTO_INCREMENT ,
  `ro_name` VARCHAR(45) NULL ,
  PRIMARY KEY (`ro_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `truyum_fse`.`user_role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `truyum_fse`.`user_role` ;

CREATE  TABLE IF NOT EXISTS `truyum_fse`.`user_role` (
  `ur_id` INT NOT NULL AUTO_INCREMENT ,
  `ur_us_id` INT NULL ,
  `ur_ro_id` INT NULL ,
  INDEX `fk_user_has_role_role1` (`ur_ro_id` ASC) ,
  INDEX `fk_user_has_role_user1` (`ur_us_id` ASC) ,
  PRIMARY KEY (`ur_id`) ,
  CONSTRAINT `fk_user_has_role_user1`
    FOREIGN KEY (`ur_us_id` )
    REFERENCES `truyum_fse`.`user` (`us_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_role_role1`
    FOREIGN KEY (`ur_ro_id` )
    REFERENCES `truyum_fse`.`role` (`ro_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
