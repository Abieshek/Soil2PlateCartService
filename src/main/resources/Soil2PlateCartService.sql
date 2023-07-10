-- Ignore Safe Mode Restrictions
SET SQL_SAFE_UPDATES=0;

use soil2platecartservice;

CREATE TABLE `cart` (
  `cart_id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `consumer_id` INT
);

CREATE TABLE `orderLine` (
  `orderLine_id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  `cart_id` INT,
  `produce_id` INT,
  `quantity_selected` INT NOT NULL DEFAULT 0
);

ALTER TABLE `orderLine` ADD FOREIGN KEY (`cart_id`) REFERENCES `cart` (`cart_id`);

ALTER TABLE cart ENGINE = InnoDB;
ALTER TABLE orderLine ENGINE = InnoDB;

insert into cart (consumer_id)  values(1);
insert into cart values(2,1);

insert into orderline (cart_id, produce_id, quantity_selected) values ((select cart_id from cart where cart_id = 1), 1, 3);

show create table cart;

select * from cart;
select * from orderline;

