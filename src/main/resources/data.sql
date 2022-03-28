INSERT INTO user(id,name,mail,password,created,modified) VALUES(1,'Ronald','rndsgl@gmail.com',
    '$2a$12$m9sPDOnljHHEFFwwV20mR.dKY23wZguSVgol1CJQoVhJOGaAyItiK',CURRENT_DATE, CURRENT_DATE );
INSERT INTO user(id,name,mail,password,created,modified) VALUES(2,'Vicente','vicente.gonzalez@bci.cl',
'$2a$12$MGyrmBO1KGkr7AfTi2upNOrZxWqPPZAi4CsQiJTG7mMFLuxP8fw6C',CURRENT_DATE,CURRENT_DATE );

INSERT INTO role (id, description, name) VALUES (1, 'Admin role', 'ADMIN');
INSERT INTO role (id, description, name) VALUES (2, 'User role', 'USER');

INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (1, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2);