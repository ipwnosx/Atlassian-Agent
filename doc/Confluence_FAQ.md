# Confluence FAQ

### Confluence activation points under Windows

* Do not use start-service.bat to start (if you have to start in this way, go to the registry to change the -javaagent parameter)
* Use bin\start-confluence.bat to start
* Add -javaagent parameter in bin\setenv.bat
* There is a bug in Confluence under Windows, which needs to be fixed by changing setenv.bat

  ```bash
set CATALINA_OPTS=-Xloggc:"%atlassian_logsdir%\gc-%atlassian_timestamp%.log" %CATALINA_OPTS%
//Change to
set CATALINA_OPTS=-Xloggc:"%atlassian_logsdir%\gc-%%t.log" %CATALINA_OPTS%
```