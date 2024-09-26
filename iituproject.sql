sudo -u postgres psql
CREATE DATABASE iituproject;
CREATE USER Ain WITH ENCRYPTED PASSWORD 'asdasd';
GRANT ALL PRIVILEGES ON DATABASE iituproject TO Ain;
