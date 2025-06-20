
-- Sample SQL Dump (Optional)

INSERT INTO user (id, name, email, password, role) VALUES
(1, 'Admin User', 'admin@example.com', '$2a$10$hashhere', 'ROLE_ADMIN'),
(2, 'John Doe', 'john@example.com', '$2a$10$hashhere', 'ROLE_USER');

INSERT INTO job (id, title, description, company) VALUES
(1, 'Software Engineer', 'Develop web applications', 'TechCorp'),
(2, 'Data Analyst', 'Analyze data trends', 'DataCorp');

INSERT INTO event (id, title, description, date) VALUES
(1, 'Alumni Meetup', 'Annual alumni gathering', '2025-08-01'),
(2, 'Career Fair', 'Networking and job opportunities', '2025-09-15');
