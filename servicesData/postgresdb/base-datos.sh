#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL

    CREATE USER admin PASSWORD 'admin';

    CREATE DATABASE red_social OWNER admin;
    GRANT ALL PRIVILEGES ON DATABASE red_social TO admin; 

EOSQL