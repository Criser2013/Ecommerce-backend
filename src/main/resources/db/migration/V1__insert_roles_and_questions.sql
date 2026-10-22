-- Defining tables
CREATE TABLE zipcode (
    zipcode CHAR(10) PRIMARY KEY,
    city VARCHAR(100) NOT NULL,
    country VARCHAR(50) NOT NULL,
    district VARCHAR(50) NOT NULL,
    state VARCHAR(100) NOT NULL
);

CREATE TABLE role (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL
);

CREATE TABLE security_question (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    content VARCHAR(200) NOT NULL
);

CREATE TABLE user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    role_id BIGINT,
    question_id BIGINT,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    registration_date DATETIME NOT NULL,
    phone CHAR(10) NOT NULL,
    dni VARCHAR(15) NOT NULL,
    password TEXT NOT NULL,
    security_answer TEXT NOT NULL,
    status BIGINT NOT NULL,
    CONSTRAINT fk_user_role_id
        FOREIGN KEY (role_id) REFERENCES role(id),
    CONSTRAINT fk_user_question_id
        FOREIGN KEY (question_id) REFERENCES security_question(id)
);

CREATE TABLE address (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    zipcode CHAR(10),
    address VARCHAR(100) NOT NULL,
    is_default BOOLEAN NOT NULL,
    CONSTRAINT fk_address_user_id
        FOREIGN KEY (user_id) REFERENCES user(id),
    CONSTRAINT fk_address_zipcode
        FOREIGN KEY (zipcode) REFERENCES zipcode(zipcode)
);

-- Inserting base data

INSERT INTO security_question (content) VALUES
    ('Which is your favorite color?'),
    ('What is the name of your father?'),
    ('What is the name of your most beloved pet?');

INSERT INTO role (name) VALUES
    ('super_user'),
    ('administrator'),
    ('user');
