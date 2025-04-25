Console Database Manager (Dockerized)
A simple console-based application for managing a database using PostgreSQL, built with Docker.

Features
List all players in the database.
Add new players.
Remove players.
Exit the application.

Technologies Used
Java 
PostgreSQL 
Docker 
Maven 

Requirements
Docker installed on your machine.
Docker Compose to orchestrate the containers.
Java 17 or higher if you need to run it outside the container.

Setup instructions:

1. git clone https://github.com/evgenievp/db-manager-dockerized.git
cd db-manager-dockerized
2. docker-compose up --build

Stop container and remove data:
docker-compose down --volumes --rmi all

This container is made with training purpose. 
