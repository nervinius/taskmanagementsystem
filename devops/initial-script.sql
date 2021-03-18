CREATE TABLE IF NOT EXISTS users
(
    user_id  BIGINT      NOT NULL AUTO_INCREMENT,
    username VARCHAR(20) NOT NULL,
    password VARCHAR(20) not null,
    PRIMARY KEY (user_id)

)
    ENGINE = InnoDB
    AUTO_INCREMENT = 0;

CREATE TABLE IF NOT EXISTS tasks
(
    task_id            BIGINT      NOT NULL AUTO_INCREMENT,
    user_id            BIGINT      NOT NULL,
    task_name          VARCHAR(20) NOT NULL,
    task_group         VARCHAR(20) NOT NULL,
    task_status        VARCHAR(20) NOT NULL ,
    time_spent_minutes BIGINT      NOT NULL,
    created            TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (task_id),
    FOREIGN KEY (user_id) REFERENCES users (user_id)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 0;

CREATE TABLE IF NOT EXISTS subtasks
(
    subtask_id         BIGINT      NOT NULL AUTO_INCREMENT,
    task_id            BIGINT      NOT NULL,
    user_id            BIGINT      NOT NULL,
    task_name          VARCHAR(20) NOT NULL,
    task_status        VARCHAR(20) NOT NULL ,
    time_spent_minutes BIGINT      NOT NULL,
    created            TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (subtask_id),
    FOREIGN KEY (task_id) REFERENCES tasks (task_id),
    FOREIGN KEY (user_id) REFERENCES users (user_id)
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 0;