# simple-blog
This is a very simple blog for the hack-day in Salt! My very first FullStack child &lt;3
This simple full-stack blog has a following functionality:

- Can add blog post conatining title and body (text) to the view and database (request method: POST)
- Can read all added blog post from the database in the 'recent' section on a side (request method: GET)
- Can red and show selected single article from the data base (request method: GET)
- Can delete article from the view and from the database (request method: DELETE)

Funcionality that only backend has (no time to fix it - gonna improve! :))
- Can update single blog post (request method: PUT)


#Backend: 
- Java 
- SpringBoot
- REST api

#Data base:
- Mongo DB running locally in Docker 

#Frontend:
- JavaScript
- React
- html
- css

#Tools:
- IntelliJ
- Visual Studio Code
- Docker
- Postman (I used for data flow in the backend side)

#Requirements to run this application

- Download docker
- Start mongodb locally in docker: 
    ```sh
    mongo pull
    docker run --name mongodb -d -p 27017:27017 mongo
    ```
- Run Java backend by starting spring boot application. Application will start in localhost:8080
- Run react application:
```sh
  npm install
  npm start
```

