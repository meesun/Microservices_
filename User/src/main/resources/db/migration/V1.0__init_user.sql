CREATE TABLE user (
USER_ID bigint NOT NULL AUTO_INCREMENT,
USER_NAME varchar(20),
USER_ADDRESS varchar(100),
USER_PHONE_NO bigint(10),
IS_ACTIVE TINYINT(1),
PRIMARY KEY(USER_ID)
);