ALTER TABLE students_backup RENAME COLUMN deleted_date to action_date;
ALTER TABLE students_backup RENAME COLUMN deleted_time to action_time;

ALTER TABLE students_backup ADD actions VARCHAR(100);



