# How to start
### Prerequisites
* OpenJDK 11
* Docker (or mariadb server)

### DB
Run the command bellow to start mariadb server in a docker container, or run the server in your machine directly.

```
docker run -p 3306:3306 -e "MYSQL_ROOT_PASSWORD=root" --name cigma-shop-db mariadb
```

### Application

1. Place with your terminal in the root directory of the project.
2. Run the command `./mvnw clean install`
3. Start the project with your favorite IDE with the profile `dev`

Run the command bellow to start the application in your terminal.
```
./mvnw spring-boot:run -Dspring.profiles.active=dev
```

# Deploy in prod
1. Place with your terminal in the root directory of the project.
2. Run the command bellow.
```
docker-compose up --build
```
