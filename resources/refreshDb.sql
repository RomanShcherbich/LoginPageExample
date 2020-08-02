DROP TABLE `servletapi`.`users`;

CREATE TABLE `servletapi`.`users`
(
    `id`       INT         NOT NULL AUTO_INCREMENT,
    `name`     VARCHAR(45) NULL,
    `password` VARCHAR(45) NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `password_UNIQUE` (`password` ASC) VISIBLE
);

INSERT INTO `servletapi`.`users` (`name`, `password`)
VALUES ('Vasya', 'Trunevvskiy');