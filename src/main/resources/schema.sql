-- Crear la tabla de usuarios
CREATE TABLE IF NOT EXISTS "user" (
    id SERIAL PRIMARY KEY,
    username VARCHAR(10) NOT NULL,
    email VARCHAR(10) NOT NULL,
    password VARCHAR(255) NOT NULL,
    roles VARCHAR(25) NOT NULL,
    CONSTRAINT username_unique UNIQUE (username),
    CONSTRAINT email_unique UNIQUE (email)
    );