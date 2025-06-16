CREATE TABLE student (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    grade VARCHAR(50),
    age INT NOT NULL,
    teacher_id BIGINT NOT NULL,
    CONSTRAINT fk_student_teacher FOREIGN KEY (teacher_id) REFERENCES teacher(id) ON DELETE CASCADE
);