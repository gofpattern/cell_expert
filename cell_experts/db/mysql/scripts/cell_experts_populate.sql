ALTER TABLE `cell_experts`.`employees` MODIFY phone BIGINT;
INSERT INTO `cell_experts`.`employees` (`employee_id`, `first_name`, `last_name`, `start_dt`, `phone`, `email`, `end_dt`, `address`) VALUES (1, 'abdul', 'hafeez', STR_TO_DATE('26-08-2015', '%d-%m-%Y'),3097506468, 'gofpattern@gmail.com', STR_TO_DATE('31-12-9999', '%d-%m-%Y'), '31 N 19th');