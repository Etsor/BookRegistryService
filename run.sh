#!/bin/bash

echo "Starting Book Registry Service..."

if ! pg_isready -h localhost -p 5432; then
    echo "PostgreSQL is not running. Please start it and create the database"
    exit 1
fi

java -jar docker/app.jar