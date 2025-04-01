@echo off

echo Starting Book Registry Service...

pg_isready -h localhost -p 5432
if %ERRORLEVEL% neq 0 (
    echo PostgreSQL is not running. Please start it and create the database
    exit /b 1
)

java -jar docker/app.jar
