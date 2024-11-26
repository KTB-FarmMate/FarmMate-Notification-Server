CREATE TABLE `member`
(
    `id` CHAR(36) NOT NULL,
    PRIMARY KEY (`id`) -- PRIMARY KEY 정의
);

CREATE TABLE `crop`
(
    `id`   INT          NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(100) NULL,
    PRIMARY KEY (`id`) -- PRIMARY KEY 정의
);

CREATE TABLE `chat_room`
(
    `id`         CHAR(31)     NOT NULL,
    `member_id`  CHAR(36)     NOT NULL,
    `crop_id`    INT          NOT NULL,
    `created_at` DATETIME(6)  NOT NULL,
    `updated_at` DATETIME(6)  NOT NULL,
    `planted_at` DATE         NOT NULL,
    `address`    VARCHAR(255) NULL,
    PRIMARY KEY (`id`) -- PRIMARY KEY 정의
);

-- 외래 키 제약 조건 추가
ALTER TABLE `chat_room`
    ADD CONSTRAINT `FK_member_TO_chat_room_1` FOREIGN KEY (`member_id`)
        REFERENCES `member` (`id`);

ALTER TABLE `chat_room`
    ADD CONSTRAINT `FK_crop_TO_chat_room_1` FOREIGN KEY (`crop_id`)
        REFERENCES `crop` (`id`);
