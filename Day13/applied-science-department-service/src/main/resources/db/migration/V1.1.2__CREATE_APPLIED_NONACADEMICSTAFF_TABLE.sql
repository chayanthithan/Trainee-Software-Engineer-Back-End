CREATE TABLE `non_academic_staff` (
  `id` VARCHAR(100) NOT NULL,
  `full_name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(155) NOT NULL,
  `gender` VARCHAR(10) NOT NULL,
  `age` INT NOT NULL,
  `dob` DATE NOT NULL,
  `job` VARCHAR(100) NOT NULL,
  `faculty` VARCHAR(155) NOT NULL,
  PRIMARY KEY (`id`));