# SpringBootOCS

You need to have `Postgresql` on your device and need to create database name `ocs`

1. Create test science plan data by using `http://localhost:3030/autosp` to insert it to database.
2. You need to create user which using `http://localhost:3030/users/register?role=Astronomer&email=test@gmail.com&password=1234` to database too.
3. run `DemoApplication.java` to finish running backend.



# Our selected design pattern is `MVC` or ` Model-View-Controller `
    - It's seperates the components: Model, View, and Controller so it help managing complexity by dividing the responsibilities of the application.
    - Better Code Organization easy to read.
    - Reusable we can reuse the function easily.