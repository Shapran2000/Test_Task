# Getting Started


## Get Started

Run database in Docker
- Run  MYSQL Container with a database (*it will start the
  DB named air-company on port: 3307, username = password = root*):
  - docker run --name air-company -p 3307:3306 -e MYSQL_ROOT_PASSWORD=root -e 
  MYSQL_USER=root -e MYSQL_PASSWORD=root -e MYSQL_DATABASE=aircompanies -d 
  mysql/mysql-server:5.7
  
  Run App + Database in Docker

- Open location of docker-compose.yml file using terminal (path: src/main/docker).
    - docker-compose up -d - run the container;
    - docker-compose stop - stop container (not removing data from DB);
    - docker-compose down - remove container (removing all data from DB);

Postman

-postman/http://localhost:9090/aircompany/all - show you all air companies;

-postman/http://localhost:9090/aircompany/{id}/delete - delete air company by id;

-postman/http://localhost:9090/aircompany/{id}/update - update air company by id;

-postman/http://localhost:9090/aircompany/{id}/read - read air company by id;

-postman/http://localhost:9090/aircompany/create - create air company ;


-postman/http://localhost:9090/airplane/all - show all airplanes ;

-postman/http://localhost:9090/airplane/{airplane_id}/change - move airplanes between companies ;

-postman/http://localhost:9090/airplane/{company_id}/add-airplane - add Airplane ;

-postman/http://localhost:9090/flight/all - show all flight 

-postman/http://localhost:9090/flight/{id}/change-status - change Flight status:
if status to change is DELAYED – set delay started at
if status to change is ACTIVE – set started at
if status to change is COMPLETED set ended at

-postman/http://localhost:9090/flight/find-active - find all Flights in ACTIVE status and started more than 24 hours ago

-postman/http://localhost:9090/flight/{id}/find-by-status - find all Air Company Flights by status

-postman/http://localhost:9090/flight/{id}/delete - delete flight by id;

-postman/http://localhost:9090/flight/{id}/update - update flight by id;

-postman/http://localhost:9090/flight/{id}/read- read flight by id;

-postman/http://localhost:9090/flight/{id}/create- create flight and add Air Company and Airplane ;


## Other

Docker useful commands:

1. docker-compose up -d - run the container
2. docker-compose down - remove the container
3. docker-compose stop - stop the container
4. docker build <PATH> - build image from Dockerfile
5. docker image list -a - get list of local images
6. docker container list -a - get list of local containers
7. docker ps -a - same as above



