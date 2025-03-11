CREATE TABLE students (
    reg_num VARCHAR(255) NOT NULL ,
    full_name VARCHAR(255),
    address VARCHAR(255),
    gender VARCHAR(50),
    age INT,
    dob DATE,
    course VARCHAR(50),
    acc_year YEAR,
    PRIMARY KEY (`reg_num`)
);
