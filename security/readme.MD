## Start application
`mvn spring-boot:run`

## Build application
`mvn clean package`

## Docker guideline
### Build docker image , account can exist or not
`docker build -t <account>/identity-service:0.0.1 .`

### Run docker image 
`docker run -d <account>/identity-service:0.0.1`

### Push docker image to Docker Hub
`docker image push <account>/identity-service:0.0.1`

## Run container
`docker run --name identity-service -p 8080:8080 -e DBMS_CONNECTION=jdbc:mysql://172.17.0.2:3306/review_security_exception identity-service:0.0.1`

### Create network:
    `docker network create monkey-network`

### Start MySQL in monkey-network
`docker run --network monkey-network --name mysql-new -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123123za -d mysql:8.0.37-debian`

### Run your application in monkey-network
`docker run  --network monkey-network -p 8080:8080 -e DBMS_CONNECTION=jdbc:mysql://mysql-new:3306/review_security_exception  duycoder/identity-service:0.0.1`

docker run  --network monkey-network -p 8080:8080 -e DBMS_CONNECTION=jdbc:mysql://mysql-new:3306/review_security_exception  duycoder/identity-service:0.0.1