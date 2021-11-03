INSERT INTO `truyum_fse`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`, `me_url`) VALUES (1, 'Sandwich', 99.00, 1, '2017-03-15', 'Main Course', 1, 'https://images.unsplash.com/photo-1528735602780-2552fd46c7af');

INSERT INTO `truyum_fse`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`, `me_url`) VALUES (2, 'Burger', 129.00, 1, '2017-12-23', 'Main Course', 0, 'https://images.unsplash.com/photo-1512152272829-e3139592d56f');

INSERT INTO `truyum_fse`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`, `me_url`) VALUES (3, 'Pizza', 149.00, 1, '2017-08-21', 'Main Course', 0, 'https://images.unsplash.com/photo-1534308983496-4fabb1a015ee');

INSERT INTO `truyum_fse`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`, `me_url`) VALUES (4, 'French Fries', 57.00, 0, '2017-07-02', 'Starters', 1, 'https://images.unsplash.com/photo-1526230427044-d092040d48dc');

INSERT INTO `truyum_fse`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`, `me_url`) VALUES (5, 'Chocolate Brownie', 32.00, 1, '2022-11-02', 'Dessert', 1, 'https://images.unsplash.com/photo-1564355808539-22fda35bed7e');


INSERT INTO `truyum_fse`.`role` (`ro_id`, `ro_name`) VALUES (1, 'USER');

INSERT INTO `truyum_fse`.`role` (`ro_id`, `ro_name`) VALUES (2, 'ADMIN');


INSERT INTO `truyum_fse`.`user` (`us_id`, `us_name`, `us_password`) VALUES (1, 'user', '$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK');

INSERT INTO `truyum_fse`.`user` (`us_id`, `us_name`, `us_password`) VALUES (2, 'admin', '$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK');


INSERT INTO `truyum_fse`.`user_role` (`ur_id`, `ur_us_id`, `ur_ro_id`) VALUES (1, 1, 1);

INSERT INTO `truyum_fse`.`user_role` (`ur_id`, `ur_us_id`, `ur_ro_id`) VALUES (2, 2, 2);


INSERT INTO `truyum_fse`.`cart` (`ct_id`, `ct_pr_id`, `ct_us_id`) VALUES (1, 1, 1);




