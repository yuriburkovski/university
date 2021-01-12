##  Test task:
Create a simple Spring Boot java project with the console interface for university, 
which consists of departments and lectors. The lectors could work in more than one department. 
A lector could have one degree (assistant, associate professor, professor).
The app should implement such commands:

1.Who is head of department {department_name}

       Answer: Head of {department_name} department is {head_of_department_name}

2.Show {department_name} statistics.

        Answer: assistans - {assistams_count}. 
        associate professors - {associate_professors_count}
        professors -{professors_count}

3. Show the average salary for the department {department_name}.

       Answer: The average salary of {department_name} is {average_salary}

4. Show count of employee for {department_name}.

	      Answer: {employee_count}

5. Global search by {template}.   
         Example: Global search by van.
         
	      Answer: Ivan Petrenko, Petro Ivanov

##  I'm using the next stack:

SPRING Boot, SPRING Data JPA, H2 Database, JUnit tests
and project create in three-layer architecture pattern

##  Running the H2 Database:

localhost:8082/h2-console

userName:  test

password:  test
