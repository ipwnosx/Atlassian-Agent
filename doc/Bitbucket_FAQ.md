# Bitbucket FAQ

### Mingming configured the agent according to the document, and successfully activated confluence, but when Bitbucket was activated, it prompted that the generated key was invalid
This situation is often caused by the setting of `JAVA_OPTS`. If `JAVA_OPTS` is set according to the following method, the activation will fail
    * You can put commands like `export JAVA_OPTS="-javaagent:/path/to/atlassian-agent.jar ${JAVA_OPTS}"` into files like `.bashrc` or `.bash_profile`.

The reason is that Bitbucket does not use the globally set variable, and mainly relies on the configuration in the `installation directory/bin/_start-webapp.sh` in its own directory, so edit this file and modify

`JAVA_OPTS="-classpath $INST_DIR/app $JAVA_OPTS $BITBUCKET_ARGS $JMX_OPTS $JVM_REQUIRED_ARGS $JVM_SUPPORT_RECOMMENDED_ARGS"`

Be at

`JAVA_OPTS="-javaagent:/atlassian-agent storage directory/atlassian-agent.jar -classpath $INST_DIR/app $JAVA_OPTS $BITBUCKET_ARGS $JMX_OPTS $JVM_REQUIRED_ARGS $JVM_SUPPORT_RECOMMENDED_ARGS"`

Try to activate again