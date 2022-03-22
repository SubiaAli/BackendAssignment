OVERVIEW : 
In this assignment a user would be able to make his/her profile with the use of multiple api's created where they can :
-update the profile
-add friends 
-view all his friends
-delete friends

How to Run the Project : 
-All the relevant information has already been put up in the application.properties , one has to enter 
the username and password in order to run the project.

-the port on which the application is running is 8080

The name of the database is assignment as shown as below:
- spring.datasource.url=jdbc:mysql://localhost:3306/assignment

- First, create a user by hitting the "/user" get method , then enter the name and the email.
-Incase any mistake, you can edit the user details by hitting the put api "/user/{id}" put method.
- Now, a user can add friends by hitting the "/addfriend" Post method.
- A user can also delete the friend by "/deletefriend" delete method.
- Incase he wants to view all his friends he can view them by /users/{id}" get method.
- If a user wants to delete his profile he can directly call the "/user/{id}" delete method.

Thank you! Hope you like my project

