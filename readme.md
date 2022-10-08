Hi!  Thanks for grading my project!\
I have a few notes before we get started:
***

1. _**For extra credit**_, I implemented a simple use case method to
   cancel a member's currently active contract. This is used in the
   /assign_contracts vaadin page. There is a button,
   "Cancel Current Active Contract of Selected Client". Note that
   this contract will still remain in the Client's contract history,
   and their eligibility for future contracts will be modified appropriately.
   <br></br>
2. Note that the test coverage of non-vaadin files is 99%. The generateSampleData bean in App.java
   will not cover
   the entire method if tables are already populated. Tests will have
   to be run both when the database is empty and when
   the database has already been populated to cover the entire method.
   I understand if this loses points. I was unable to test for this
   interaction simultaneously since I couldn't solve how to empty a
   database before running the program in a unit test.
   <br></br>
3. _I only came across this problem once early on while I was building my project,
   but just in case_: if the vaadin UI does not populate the tables with
   Client data, stop the program, drop database tables, Maven clean +
   package rebuild, then run again.