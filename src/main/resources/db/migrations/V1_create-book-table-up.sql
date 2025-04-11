CREATE TABLE book (
    id BIGINT PRIMARY KEY BIGSERIAL,
    isbn VARCHAR(13) NOT NULL UNIQUE,
    title VARCHAR(255) NOT NULL,
    authors VARCHAR(255) NOT NULL,
    genre VARCHAR(100),
    publisher VARCHAR(255) NOT NULL,
    year_of_publication INTEGER NOT NULL,
    pages INTEGER NOT NULL,
    date_added TIMESTAMP NOT NULL,
    
    INDEX idx_isbn (isbn),
    INDEX idx_authors (authors),
    INDEX idx_date_added (date_added)
);