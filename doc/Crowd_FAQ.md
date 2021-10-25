# Crowd FAQ

### Mingming configured the agent as stated in the document, and successfully activated confluence, but when Crowd was activated, it prompted that the generated key was invalid
This situation is often caused by the setting of `JAVA_OPTS`. If `JAVA_OPTS` is set according to the following method, the activation will fail
    * You can put commands like `export JAVA_OPTS="-javaagent:/path/to/atlassian-agent.jar ${JAVA_OPTS}"` into files like `.bashrc` or `.bash_profile`.

The reason is that Crowd does not use the globally set variable, and mainly depends on the configuration in the `installation directory /apache-tomcat/bin/setenv.sh` in its own directory, so edit this file and add `JAVA_OPTS= "-javaagent:/atlassian-agent storage directory/atlassian-agent.jar $JAVA_OPTS"`, try to activate again