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