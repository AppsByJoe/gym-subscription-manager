Hi!  Thanks for grading my project!\
I have a few notes before we get started:
***

1. _**For extra credit**_, I created a new view which can be reached
   from the drawer on the left hand side of the viewport.  "View History"
   implements a new use case to view the entire contract history of any
   client in the database. To operate, first select the name of a client
   from the left-hand side combo-box. Then, the grid on the right-hand
   side will be populated with all the client's contract data.
   <br></br>
2. _**For extra credit**_, I implemented a simple use case method to
   cancel a member's currently active contract. This is used in the
   /assign_contracts vaadin page. Click the button,
   "Cancel Current Active Contract of Selected Client". This canceled
   contract will still remain in the Client's contract history.
   <br></br>
3. Note that the test coverage of non-vaadin files is 99%. The generateSampleData bean in App.java
   will not cover
   the entire method if tables are already populated. Tests will have
   to be run both when the database is empty and when
   the database has already been populated to cover the entire method.
   I understand if this loses points. I was unable to test for this
   interaction simultaneously since I couldn't solve how to empty a
   database before running the program in a unit test.
   <br></br>
4. I only came across this problem a single time early on while I was building my project,
   but just in case: if the vaadin UI does not populate the tables with
   Client data, stop the program, drop database tables, Maven clean +
   package rebuild, then run again.