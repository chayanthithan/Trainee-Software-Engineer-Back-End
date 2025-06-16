CREATE TABLE `academic_staff_backup` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(155) NOT NULL,
  `gender` VARCHAR(10) NOT NULL,
  `age` INT NOT NULL,
  `dob` DATE NOT NULL,
  `job` VARCHAR(100) NOT NULL,
  `faculty` VARCHAR(155) NOT NULL,
  `deleted_date` date DEFAULT NULL,
  `deleted_time` time DEFAULT NULL,
  PRIMARY KEY (`id`));