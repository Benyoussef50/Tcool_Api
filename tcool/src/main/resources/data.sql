INSERT INTO `APP_Role` (`id`, `role`) VALUES
(1, 'RESIDENT'),
(2, 'GESTIONNAIRE'),
(3, 'INTERVENANT'),
(4, 'ADMIN');

INSERT INTO `Compte` (`created_by`, `first_name`, `last_name`,`immeuble`,`appartement`, `email`, `password`, `phone`, `created_date`,`last_modified_date`,`version` ) VALUES
('KF2Y','mehdi','benyoussef','94','3','mehdi@gmail.com','$2a$10$zgK6QKoz6ftlCHYMe/2wj.MDsK9l5Tj2zg1n3hLMuOf2KvP7FvRJG', '0606060606',now(),now(),0),
('KF2Y','kondi-mane','robbile','94','3','robb@gmail.com','$2a$10$zgK6QKoz6ftlCHYMe/2wj.MDsK9l5Tj2zg1n3hLMuOf2KvP7FvRJG', '0607070707',now(),now(),0),
('KF2Y','test1','test2','94','3','test1@gmail.com','$2a$10$zgK6QKoz6ftlCHYMe/2wj.MDsK9l5Tj2zg1n3hLMuOf2KvP7FvRJG', '0604370707',now(),now(),0),
('KF2Y','test2','test2','94','3','test2@gmail.com','$2a$10$zgK6QKoz6ftlCHYMe/2wj.MDsK9l5Tj2zg1n3hLMuOf2KvP7FvRJG', '0607070707',now(),now(),0),
('KF2Y','said','bendrioue','94','3','said@gmail.com','$2a$10$zgK6QKoz6ftlCHYMe/2wj.MDsK9l5Tj2zg1n3hLMuOf2KvP7FvRJG', '0607070707',now(),now(),0),
('KF2Y','kans','kant','94','3','kans@gmail.com','$2a$10$zgK6QKoz6ftlCHYMe/2wj.MDsK9l5Tj2zg1n3hLMuOf2KvP7FvRJG', '0607070707',now(),now(),0)
;

INSERT INTO `compte_my_role` (`compte_id_compte`, `my_role_id`) VALUES
(1, 4),
(2, 1),
(3, 3),
(4, 3),
(5, 2),
(6,3)
;

INSERT INTO `Discussion` (`created_by`, `created_date`, `last_modified_date`, `details`,`status`, `title`, `visibility`, `version`, `theme`) VALUES
('robb@gmail.com', now(), now(), 'Discussion 1', 'EN COURS', 'Discussion 1', 'Public', 0, 'gestionnaire_rel'),
('robb@gmail.com', now(), now(), 'Discussion 2', 'EN COURS', 'Discussion 2', 'Public', 0,'gestionnaire_rel'),
('robb@gmail.com', now(), now(), 'Discussion 3', 'EN COURS', 'Discussion 3', 'Public', 0, 'gestionnaire_rel'),
('robb@gmail.com', now(), now(), 'Discussion 4', 'EN COURS', 'Discussion 4', 'Public', 0, 'gestionnaire_rel'),
('robb@gmail.com', now(), now(), 'Discussion 5', 'CLOTUREE', 'Discussion 5', 'Public', 0, 'gestionnaire_rel'),
('robb@gmail.com', now(), now(), 'Discussion 6', 'CLOTUREE', 'Discussion 6', 'Public', 0, 'gestionnaire_rel'),
('robb@gmail.com', now(), now(), 'Discussion 7', 'REJETEE', 'Discussion 7', 'Public', 0, 'gestionnaire_rel'),
('robb@gmail.com', now(), now(), 'Discussion 8', 'REJETEE', 'Discussion 8', 'Public', 0, 'gestionnaire_rel'),
('robb@gmail.com', now(), now(), 'Discussion 9', 'REJETEE', 'Discussion 9', 'Public', 0, 'gestionnaire_rel');

INSERT INTO `Intervention` (`created_by`, `created_date`, `last_modified_date`, `details`,`status`, `title`,`version`,`location`,`theme`) VALUES
('robb@gmail.com', now(), now(), 'Intervention 1', 'VALIDER', 'Intervention 1',0,'13 Rue Al Adarissa, Rabat 10020, Morocco','peinture'),
('robb@gmail.com', now(), now(), 'Intervention 2', 'VALIDER', 'Intervention 2',0,'22 Avenue Michlifen, Rabat 10080, Morocco','peinture'),
('mehdi@gmail.com', now(), now(), 'Intervention 3', 'VALIDER', 'Intervention 3',0,'n10 Rue el Baoudi, Rabat 10000, Morocco','peinture'),
('mehdi@gmail.com', now(), now(), 'Intervention 4', 'CLOTUREE', 'Intervention 4',0,'20 Rue Ghana, Rabat, Morocco','peinture'),
('mehdi@gmail.com', now(), now(), 'Intervention 5', 'ANNULEE', 'Intervention 5',0,'Avenue Sidi Moussa, Salé, Morocco','peinture');

INSERT INTO `Evenement` (`created_by`, `created_date`, `last_modified_date`, `details`,`status`, `title`, `visibility`, `version`,`duration`,`event_date`) VALUES
('mehdi@gmail.com', now(), now(), 'Evenement 1', 'EN COURS', 'Evenement 1', 'Public', 0,'2:8:1','2020-09-10'),
('mehdi@gmail.com', now(), now(), 'Evenement 2', 'EN COURS', 'Evenement 2', 'Public', 0,'2:8:1','2020-09-10'),
('mehdi@gmail.com', now(), now(), 'Evenement 3', 'EN COURS', 'Evenement 3', 'Public', 0,'2:8:1','2020-09-10'),
('mehdi@gmail.com', now(), now(), 'Evenement 4', 'EN COURS', 'Evenement 4', 'Public', 0,'2:8:1','2020-09-10'),
('mehdi@gmail.com', now(), now(), 'Evenement 5', 'CLOTUREE', 'Evenement 5', 'Public', 0,'2:8:1','2020-09-10'),
('mehdi@gmail.com', now(), now(), 'Evenement 6', 'CLOTUREE', 'Evenement 6', 'Public', 0,'2:8:1','2020-09-10'),
('mehdi@gmail.com', now(), now(), 'Evenement 7', 'REJETEE', 'Evenement 7', 'Public', 0,'2:8:1','2020-09-10'),
('mehdi@gmail.com', now(), now(), 'Evenement 8', 'REJETEE', 'Evenement 8', 'Public', 0,'2:8:1','2020-09-10'),
('mehdi@gmail.com', now(), now(), 'Evenement 9', 'REJETEE', 'Evenement 9', 'Public', 0,'2:8:1','2020-09-10');
INSERT INTO `Copropriete` (`created_by`, `created_date`, `last_modified_date`, `name`,`details`, `city`,`version`,`nb_residents`, `gestionnaire_id_compte`) VALUES
('robb@gmail.com', now(), now(), 'Copropriete 1', 'EN COURS', 'Casa',0,14, '1'),
('robb@gmail.com', now(), now(), 'Copropriete 2', 'EN COURS', 'Marrakech',0,14, '1'),
('robb@gmail.com', now(), now(), 'Copropriete 3', 'EN COURS', 'Rabat',0,8,'1'),
('robb@gmail.com', now(), now(), 'Copropriete 4', 'CLOTUREE', 'Safi',0,4,'1'),
('robb@gmail.com', now(), now(), 'Copropriete 5', 'ANNULEE', 'Settat',0,96,'1');

INSERT INTO `copropriete_list_residents` (`copropriete_id_copropriete`, `list_residents_id_compte`) VALUES
(1, 1),
(2, 2);

INSERT INTO `Operation` (`created_by`, `created_date`, `last_modified_date`, `title`,`type_op`, `amount`,`version`) VALUES
('robb@gmail.com', now(), now(), 'Opération 1', 'CREDIT', 400, 0),
('robb@gmail.com', now(), now(), 'Opération 2', 'CREDIT', 150, 0),
('robb@gmail.com', now(), now(), 'Opération 3', 'CREDIT', 120, 0),
('robb@gmail.com', now(), now(), 'Opération 4', 'CREDIT', 130, 0),
('robb@gmail.com', now(), now(), 'Opération 5', 'DEBIT', 80, 0),
('robb@gmail.com', now(), now(), 'Opération 6', 'CREDIT', 44, 0),
('robb@gmail.com', now(), now(), 'Opération 7', 'DEBIT', 50, 0),
('robb@gmail.com', now(), now(), 'Opération 8', 'CREDIT', 80, 0),
('robb@gmail.com', now(), now(), 'Opération 9', 'CREDIT', 96, 0),
('robb@gmail.com', now(), now(), 'Opération 10', 'DEBIT', 100, 0),
('robb@gmail.com', now(), now(), 'Opération 11', 'DEBIT', 100, 0),
('robb@gmail.com', now(), now(), 'Opération 12', 'DEBIT', 200, 0),
('robb@gmail.com', now(), now(), 'Opération 13', 'DEBIT', 200, 0),
('robb@gmail.com', now(), now(), 'Opération 14', 'CREDIT', 200, 0);

INSERT INTO `Notification` (`created_by`, `created_date`, `last_modified_date`, `message`,`is_read`,`version`, `theme`,`parent_id`) VALUES
('mehdi@gmail.com', now(), now(), 'Notification 1', false,0,'DISCUSSION',1),
('mehdi@gmail.com', now(), now(), 'Notification 2', false,0, 'DISCUSSION',1),
('robb@gmail.com', now(), now(), 'Notification 3', false,0,'EVENEMENT',1),
('robb@gmail.com', now(), now(), 'Notification 4', false,0,'EVENEMENT',1),
('robb@gmail.com', now(), now(), 'Notification 5', false,0,'INTERVENTION',1);

INSERT INTO `compte_my_notifications` VALUES
(2,1),(2,2),(2,5);

INSERT INTO `Code` ( `content`,`status`) VALUES
(100000,'FREE'),
(200000,'FREE'),
(222222,'FREE'),
(123456,'FREE');
