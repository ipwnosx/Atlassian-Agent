JIRA FAQ
Obviously, the agent is configured according to the document and the confluence is successfully activated, but the generated key is invalid when JIRA is activated.

This situation is often a problem with the JAVA_OPTS setting. If JAVA_OPTS is set in the following way, the activation will fail
* You can put commands like export JAVA_OPTS="-javaagent:/path/to/atlassian-agent.jar ${JAVA_OPTS}" into files such as .bashrc or .bash_profile.

The reason is that JIRA does not use this variable set globally, and mainly depends on the configuration in /bin/setenv.sh under the installation directory in its own directory, so edit this file and add JAVA_OPTS="-javaagent:/atlassian- Agent storage directory/atlassian-agent.jar $JAVA_OPTS" is at JAVA_OPTS, and then try to activate again