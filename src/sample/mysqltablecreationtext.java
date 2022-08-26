package sample;

public class mysqltablecreationtext {

    //CREATE TABLE `squeekdb`.`tenantdomains` (
    //`id` INT  NOT NULL AUTO_INCREMENT,
    //`name` VARCHAR(305) NOT NULL,
    //`author` VARCHAR(305) NOT NULL,
    //PRIMARY KEY (`id`),
    //UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
    //UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE);
    //
    //CREATE TABLE `squeekdb`.`users` (
    //`id` INT NOT NULL AUTO_INCREMENT,
    //`name` VARCHAR(305) NOT NULL,
    //`password` VARCHAR(305) NOT NULL,
    //`domain` VARCHAR(305) NOT NULL,
    //PRIMARY KEY (`id`),
    //UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
    //UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE,
    //UNIQUE INDEX `domain_UNIQUE` (`domain` ASC) VISIBLE);
    //
    //ALTER TABLE `squeekdb`.`users`
    //ADD CONSTRAINT `name`
    //FOREIGN KEY (`domain`)
    //REFERENCES `squeekdb`.`tenantdomains` (`name`)
    //ON DELETE NO ACTION
    //ON UPDATE NO ACTION;


   // CREATE TABLE `squeekdb`.`smscontacts` (
   // `id` INT NOT NULL AUTO_INCREMENT,
   // `fullname` VARCHAR(305) NOT NULL,
   // `user` VARCHAR(305) NOT NULL,
   // `org` VARCHAR(305) NULL,
   // `phonenumber` INT NOT NULL,
   // PRIMARY KEY (`id`),
   // UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);


    //CREATE TABLE `squeekdb`.`smsmessages` (
    //  `id` INT NOT NULL AUTO_INCREMENT,
    //  `user` VARCHAR(305) NOT NULL,
    //  `contact` VARCHAR(305) NOT NULL,
    //  `message` VARCHAR(2000) NOT NULL,
    //  `size` INT NOT NULL,
    //  `author` VARCHAR(305) NOT NULL,
    //  PRIMARY KEY (`id`),
    //  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);


    //CREATE TABLE `squeekdb`.`smscampaign` (
    //  `id` INT NOT NULL AUTO_INCREMENT,
    //  `creator` VARCHAR(305) NOT NULL,
    //  `contact` VARCHAR(305) NOT NULL,
    //  `schedule` VARCHAR(305) NOT NULL,
    //  `datetime` VARCHAR(455) NOT NULL,
    //  `template` VARCHAR(1000) NOT NULL,
    //  PRIMARY KEY (`id`),
    //  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
    //  UNIQUE INDEX `creator_UNIQUE` (`creator` ASC) VISIBLE);




}
