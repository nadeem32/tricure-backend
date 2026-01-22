-- liquibase formatted sql

-- changeset tricure:2
CREATE TABLE company_settings (
    id BIGINT PRIMARY KEY,
    mission_statement TEXT,
    history TEXT,
    email VARCHAR(255),
    phone VARCHAR(50),
    address VARCHAR(500),
    facebook_url VARCHAR(255),
    linkedin_url VARCHAR(255),
    twitter_url VARCHAR(255)
);

INSERT INTO company_settings (id, mission_statement, history, email, phone, address) 
VALUES (1, 'Innovating healthcare for a better tomorrow.', 'Founded in 2024, Tricure Innovations has been at the forefront of medical technology.', 'info@tricureinnovations.com', '+1 (555) 123-4567', '123 Innovation Dr, Tech City, TC 90210');
