# mobile_clicker_system

Use Case
1. Instructor shows a MCQ with options.
2. Students select an option from their mobile devices.
3. Instructor displays the statistics on his console.

1. Refer to your “ebookshop” case study, in particular, the section on “Processing the Order”.
2. Create a webApp to display 10 questions, each with options a, b, c, and d. (10 screens with a next and back button to navigate between questions)
3. Create a table "responses" to capture the responses from the students.

Assume that there are many questions with any number of responses (a, b, c,...). Create two
columns: questionNo, and choice.

  CREATE TABLE responses (
      questionNo INT,
      choice VARCHAR(1)
  );

4. Whenever a response is received, you shall insert a new record into the table for that questionNo and choice, via SQL statement:
   INSERT INTO responses (questionNo, choice) VALUES (8, '?');

5. Write an Android app (as client) for the users:
   [A]- On click, trigger a URL: http://ip_addr:port/clicker/select?choice=a
   [B]- On click, trigger a URL: http://ip_addr:port/clicker/select?choice=b
   [C]- On click, trigger a URL: http://ip_addr:port/clicker/select?choice=c
   [D]- On click, trigger a URL: http://ip_addr:port/clicker/select?choice=d

6. Write a servlet, which maps to URL “/select”, to capture the choice and store in the database
table.

// Step 3 & 4 of the database servlet
// Assume that the URL is http://ip‐addr:port/clicker/select?choice=x
// Assume that the questionNo is 8
String choice = request.getParameter("choice");
String sqlstr = "INSERT INTO responses (questionNo, choice) VALUES (8, '"
      + choice + "')";
int count = stmt.executeUpdate(sqlStr);   // run the SQL statement

8. Display the user's choice on http://ip_addr:port/clicker/select?choice='x'; 
E.g You selected option "*b*" for question "*8*";

Add back button to Android App to return to the main activity (options)




