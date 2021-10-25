# Bamboo FAQ

### Mingming configured the agent as stated in the document, and successfully activated confluence, but when Bamboo was activated, it prompted that the generated key was invalid
This situation is often caused by the setting of `JAVA_OPTS`. If `JAVA_OPTS` is set according to the following method, the activation will fail
   * You can put commands like `export JAVA_OPTS="-javaagent:/path/to/atlassian-agent.jar ${JAVA_OPTS}"` into files like `.bashrc` or `.bash_profile`.

The reason is that Bamboo does not use this variable set globally, and it mainly relies on the configuration in the `installation directory/bin/setenv.sh` in its own directory, so edit this file and modify

`JAVA_OPTS="-Xms${JVM_MINIMUM_MEMORY} -Xmx${JVM_MAXIMUM_MEMORY} ${JAVA_OPTS} ${JVM_REQUIRED_ARGS} ${JVM_SUPPORT_RECOMMENDED_ARGS} ${BAMBOO_HOME_MINUSD}"`

Be at

`JAVA_OPTS="-javaagent:/atlassian-agent storage directory/atlassian-agent.jar -Xms${JVM_MINIMUM_MEMORY} -Xmx${JVM_MAXIMUM_MEMORY} ${JAVA_OPTS} ${JVM_REQUIRED_ARGS} ${JVM_SUPPORT_RECOMMENDED_HOME`

Try to activate again