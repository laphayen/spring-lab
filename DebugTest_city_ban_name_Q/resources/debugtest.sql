DROP DATABASE IF EXISTS `debugtest`;
CREATE DATABASE IF NOT EXISTS `debugtest`;
USE `debugtest`;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` varchar(20) NOT NULL,
  `pw` varchar(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `birthdate` DATE NOT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `reg_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 가입 날짜 자동 반영
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `users` VALUES ('admin', '1234', '관리자', '1990-01-01', '010-1234-5678', 'admin@example.com', NOW()),
                           ('ssafy', '1234', '김싸피', '1995-05-15', '010-8765-4321', 'ssafy@example.com', NOW());


DROP TABLE IF EXISTS `mobiles`;
CREATE TABLE `mobiles` (
  `code` varchar(20) NOT NULL,
  `model` varchar(20) NOT NULL,
  `price` int NOT NULL,
  `company` varchar(20) DEFAULT NULL,
  `user_id` varchar(20) NOT NULL, 
  PRIMARY KEY (`code`),
  CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `mobiles` VALUES ('ios-2655', 'iphoneX', 1700000, '애플', 'admin'),
                             ('S236ZD95P', '갤럭시S24', 1475900, '삼성', 'ssafy'),
                             ('NT550XDZ-AD5A', '갤럭시 폴드', 1729000, '삼성', 'ssafy');

COMMIT;

select * from mobiles;