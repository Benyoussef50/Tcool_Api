INSERT INTO `APP_Role` (`id`, `role`) VALUES
(1, 'RESIDENT'),
(2, 'SYNDIC'),
(3, 'INTERVENANT');

INSERT INTO `Compte` (`created_by`, `first_name`, `last_name`, `email`, `password`, `phone`, `created_date`,`last_modified_date` ) VALUES
('KF2Y','mehdi','benyoussef','mehdi@gmail.com','$2a$10$zgK6QKoz6ftlCHYMe/2wj.MDsK9l5Tj2zg1n3hLMuOf2KvP7FvRJG', '0606060606',now(),now()),
('KF2Y','ROBBILE','KONDE-MANE','robb@gmail.com','$2a$10$zgK6QKoz6ftlCHYMe/2wj.MDsK9l5Tj2zg1n3hLMuOf2KvP7FvRJG', '0607070707',now(),now())
;

INSERT INTO `compte_my_role` (`compte_id_compte`, `my_role_id`) VALUES
(1, 1),
(2, 1)
;

INSERT INTO `Intervention` (`created_by`, `created_date`, `last_modified_date`, `details`,`status`, `title`) VALUES
('Mehdi', now(), now(), 'Intervention 1', 'EN COURS', 'Intervention 1'),
('Mehdi', now(), now(), 'Intervention 2', 'EN COURS', 'Intervention 2'),
('Mehdi', now(), now(), 'Intervention 3', 'EN COURS', 'Intervention 3'),
('Mehdi', now(), now(), 'Intervention 4', 'EN COURS', 'Intervention 4'),
('Mehdi', now(), now(), 'Intervention 5', 'CLOTUREE', 'Intervention 5'),
('Mehdi', now(), now(), 'Intervention 6', 'CLOTUREE', 'Intervention 6'),
('Mehdi', now(), now(), 'Intervention 7', 'ANNULEE', 'Intervention 7'),
('Mehdi', now(), now(), 'Intervention 8', 'ANNULEE', 'Intervention 8'),
('Mehdi', now(), now(), 'Intervention 9', 'ANNULEE', 'Intervention 9'); 