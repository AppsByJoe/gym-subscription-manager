Hello!  Thanks for grading my project!
I have a few notes before we get started:
***

1. For Extra Credit, I implemented a simple use case method to
   cancel a member's currently active contract. This is used in the
   /assign_contracts vaadin page. There is a button,
   "Cancel Current Active Contract of Selected Client". Note that
   this contract will still remain in the Client's contract history,
   and their eligibility for future contracts will be modified appropriately.
2. Note that test coverage of generateSampleData bean will not cover
   the entire method if tables are already populated. Tests will have
   to be run with coverage both when the database is empty and when
   the database has already been populated to cover the entire method.
   I understand if this loses points. I was unable to test for this
   interaction since I couldn't deduce how to empty a database before
   running the program in a unit test.
3. Note that if the vaadin UI does not populate the tables with
   Client data, stop the program, drop database tables, Maven clean +
   package rebuild, then run again. I only came across this problem
   once while I was building my project, but I want to make sure my
   project works when it comes time to grade. This occurred because of
   some type of nuance with the generateSampleData bean at runtime.