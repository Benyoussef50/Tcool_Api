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

INSERT INTO `Discussion` (`created_by`, `created_date`, `last_modified_date`, `details`,`status`, `title`, `version`, `visibility`) VALUES
('Robb', now(), now(), 'Discussion 1', 'EN COURS', 'Discussion 1', 0, 'Public'),
('Robb', now(), now(), 'Discussion 2', 'EN COURS', 'Discussion 2', 0, 'Public'),
('Robb', now(), now(), 'Discussion 3', 'EN COURS', 'Discussion 3', 0, 'Public'),
('Robb', now(), now(), 'Discussion 4', 'EN COURS', 'Discussion 4', 0, 'Public'),
('Robb', now(), now(), 'Discussion 5', 'CLOTUREE', 'Discussion 5', 0, 'Public'),
('Robb', now(), now(), 'Discussion 6', 'CLOTUREE', 'Discussion 6', 0, 'Public'),
('Robb', now(), now(), 'Discussion 7', 'REJETEE', 'Discussion 7', 0, 'Public'),
('Robb', now(), now(), 'Discussion 8', 'REJETEE', 'Discussion 8', 0, 'Public'),
('Robb', now(), now(), 'Discussion 9', 'REJETEE', 'Discussion 9', 0, 'Public');