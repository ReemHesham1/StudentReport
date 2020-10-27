CREATE TABLE `student` (
  `id` bigint NOT NULL,
  `student_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `course` (
  `id` bigint NOT NULL,
  `grade` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `semester_number` int DEFAULT NULL,
  `semester_season` bit(1) DEFAULT NULL,
  `student_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs8aqr642dup1oio7xa51t5vw5` (`student_id`),
  CONSTRAINT `FKs8aqr642dup1oio7xa51t5vw5` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `student_report` (
  `id` bigint NOT NULL,
  `cumultative_gpa` double DEFAULT NULL,
  `semester_gpa` double DEFAULT NULL,
  `semester_number` int DEFAULT NULL,
  `year` int DEFAULT NULL,
  `student_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKggpclr9ij2lankkn76129uhgw` (`student_id`),
  CONSTRAINT `FKggpclr9ij2lankkn76129uhgw` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
