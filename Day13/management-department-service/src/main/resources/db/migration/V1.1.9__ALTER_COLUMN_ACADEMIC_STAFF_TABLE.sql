ALTER TABLE academic_staff_backup RENAME COLUMN deleted_date to action_date;
ALTER TABLE academic_staff_backup RENAME COLUMN deleted_time to action_time;

ALTER TABLE academic_staff_backup ADD actions VARCHAR(100);

