INSERT INTO sec_user (email, encryptedPassword, enabled)
VALUES ('jay.patel@sheridancollege.ca', '$2a$10$Etp6oZzxQgVduD4TfDGHpub2UQOTenXCSFT95gAzErLNHzRmQ1Roe', 1);


INSERT INTO sec_user (email, encryptedPassword, enabled)
VALUES ('guest.guest@sheridancollege.ca', '$2a$10$qJDernWhQDubtnpqwWbVyu2XMEJD5Ts82TlMBbTongY1YPJBDeaqG', 1);

INSERT INTO sec_user (email, encryptedPassword, enabled)
VALUES ('john.wick@sheridancollege.ca', '$2a$10$CQ/QAOQChkMdg3Q93KQpzuw4h36HVdOYm8xLbcyQLv3YyASmQNR3q', 1);
 
INSERT INTO sec_role (roleName)
VALUES ('ROLE_ADMIN');
 
INSERT INTO sec_role (roleName)
VALUES ('ROLE_USER');
 

 
INSERT INTO user_role (userId, roleId)
VALUES (1, 1);
 
INSERT INTO user_role (userId, roleId)
VALUES (1, 2);
 
INSERT INTO user_role (userId, roleId)
VALUES (2, 2);

INSERT INTO user_role (userId, roleId)
VALUES (3, 1);

INSERT INTO user_role (userId, roleId)
VALUES (3, 2);
