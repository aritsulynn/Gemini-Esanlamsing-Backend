# SpringBootOCS

You need to have `Postgresql` on your device and need to go to `pgAdmin` and create database name `ocs`
Then install `postman` on your Computer and do following steps:
1. Create test science plan data by using `GET` and paste `http://localhost:3030/autosp` to insert it in postman to database.
2. You need to create user which using `POST` and paste `http://localhost:3030/users/register?role=Astronomer&email=test@gmail.com&password=1234` and `http://localhost:3030/users/register?role=Science Observer&email=testob@gmail.com&password=1234` to insert it in postman to database.
Then back to VSCODE and do this:
1. run `DemoApplication.java` to finish running backend.



# Our selected design pattern is `MVC` or ` Model-View-Controller `
    - It's seperates the components: Model, View, and Controller so it help managing complexity by dividing the responsibilities of the application.
    - Better Code Organization easy to read.
    - Reusable we can reuse the function easily.