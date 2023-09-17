# Gym Subscription Manager
***
### Summary
This project is designed to be used by a gym owner to track members or guests who use the gym.
Membership status, contract type, and history can be edited through the browser user interface.
***
### Dependencies
MAC:
1. Download Derby 10.6.1 [HERE](https://db.apache.org/derby/releases/release-10.6.1.0.html)
2. Extract to */opt/Apache/*
3. Run in terminal: `export DERBY_INSTALL=/opt/Apache/db-derby-10.16.1.1-bin`
4. Run in terminal: `export CLASSPATH=$DERBY_INSTALL/lib/derby.jar:$DERBY_INSTALL/lib/derbytools.jar:$DERBY_INSTALL/lib/derbyoptionaltools.jar:$DERBY_INSTALL/lib/derbyshared.jar:.`

WINDOWS:
1. Download Derby 10.6.1 [HERE](https://db.apache.org/derby/releases/release-10.6.1.0.html)
2. Extract to *C:\Apache*
3. Run in terminal: `set DERBY_INSTALL=C:\Apache\db-derby-10.16.1.1-bin`
4. Run in terminal: `set CLASSPATH=%DERBY_INSTALL%\lib\derby.jar;%DERBY_INSTALL%\lib\derbytools.jar;%DERBY_INSTALL%\lib\derbyoptionaltools.jar;%DERBY_INSTALL%\lib\derbyshared.jar;.`

***
### Run Instructions

MAC:
1. Navigate to */opt/Apache/db-derby-10.16.1.1-bin*
2. Run in terminal: `/bin/startNetworkServer -p 1528`
3. Run file from project: */src/main/java/edu.au.cpsc.homework/App.java*
4. In web browser enter URL "localhost:8080"

WINDOWS:
1. Navigate to *C:\Apache\db-derby-10.4.1.3-bin\bin*
2. Run in terminal: `startNetworkServer.bat`
> **NOTE**
>
> Network Server will run on port 1527 by default
3. Run file from project: */src/main/java/edu.au.cpsc.homework/App.java*
4. In web browser enter URL "localhost:8080"
