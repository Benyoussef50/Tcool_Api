INSERT INTO `APP_Role` (`id`, `role`) VALUES
(1, 'RESIDENT'),
(2, 'SYNDIC'),
(3, 'INTERVENANT');

INSERT INTO `Compte` (`created_by`, `first_name`, `last_name`, `email`, `password`, `phone`, `created_date`,`last_modified_date`,`version` ) VALUES
('KF2Y','mehdi','benyoussef','mehdi@gmail.com','$2a$10$zgK6QKoz6ftlCHYMe/2wj.MDsK9l5Tj2zg1n3hLMuOf2KvP7FvRJG', '0606060606',now(),now(),0),
('KF2Y','ROBBILE','KONDE-MANE','robb@gmail.com','$2a$10$zgK6QKoz6ftlCHYMe/2wj.MDsK9l5Tj2zg1n3hLMuOf2KvP7FvRJG', '0607070707',now(),now(),0)
;

INSERT INTO `compte_my_role` (`compte_id_compte`, `my_role_id`) VALUES
(1, 1),
(2, 1)
;

INSERT INTO `Discussion` (`created_by`, `created_date`, `last_modified_date`, `details`,`status`, `title`, `visibility`, `version`) VALUES
('Robb', now(), now(), 'Discussion 1', 'EN COURS', 'Discussion 1', 'Public', 0),
('Robb', now(), now(), 'Discussion 2', 'EN COURS', 'Discussion 2', 'Public', 0),
('Robb', now(), now(), 'Discussion 3', 'EN COURS', 'Discussion 3', 'Public', 0),
('Robb', now(), now(), 'Discussion 4', 'EN COURS', 'Discussion 4', 'Public', 0),
('Robb', now(), now(), 'Discussion 5', 'CLOTUREE', 'Discussion 5', 'Public', 0),
('Robb', now(), now(), 'Discussion 6', 'CLOTUREE', 'Discussion 6', 'Public', 0),
('Robb', now(), now(), 'Discussion 7', 'REJETEE', 'Discussion 7', 'Public', 0),
('Robb', now(), now(), 'Discussion 8', 'REJETEE', 'Discussion 8', 'Public', 0),
('Robb', now(), now(), 'Discussion 9', 'REJETEE', 'Discussion 9', 'Public', 0);

INSERT INTO `Intervention` (`created_by`, `created_date`, `last_modified_date`, `details`,`status`, `title`,`version`) VALUES
('Mehdi', now(), now(), 'Intervention 1', 'EN COURS', 'Intervention 1',0),
('Mehdi', now(), now(), 'Intervention 2', 'EN COURS', 'Intervention 2',0),
('Mehdi', now(), now(), 'Intervention 3', 'EN COURS', 'Intervention 3',0),
('Mehdi', now(), now(), 'Intervention 4', 'EN COURS', 'Intervention 4',0),
('Mehdi', now(), now(), 'Intervention 5', 'CLOTUREE', 'Intervention 5',0),
('Mehdi', now(), now(), 'Intervention 6', 'CLOTUREE', 'Intervention 6',0),
('Mehdi', now(), now(), 'Intervention 7', 'ANNULEE', 'Intervention 7',0),
('Mehdi', now(), now(), 'Intervention 8', 'ANNULEE', 'Intervention 8',0),
('Mehdi', now(), now(), 'Intervention 9', 'ANNULEE', 'Intervention 9',0),
('Mehdi', now(), now(), 'Intervention 10', 'EN COURS', 'Intervention 10',0);

