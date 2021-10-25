# FishEye & Crucible FAQ

### Mingming configured the agent according to the document, and successfully activated the confluence, but when FishEye or Crucible was activated, it prompts that the generated key is invalid
This situation is often caused by the setting of `JAVA_OPTS`. If `JAVA_OPTS` is set according to the following method, the activation will fail
   * You can put commands like `export JAVA_OPTS="-javaagent:/path/to/atlassian-agent.jar ${JAVA_OPTS}"` into files like `.bashrc` or `.bash_profile`.

The reason is that FishEye and Crucible do not directly use this environment variable, they use the environment variable `FISHEYE_OPTS`

So we open the fisheyectl.sh file in the bin directory and change the

```FISHEYE_CMD="$JAVACMD $FISHEYE_OPTS -Dfisheye.library.path=$FISHEYE_LIBRARY_PATH -Dfisheye.inst=$FISHEYE_INST -Djava.awt.headless=true -Djava.endorsed.dirs=$FISHEYE_HOME/lib/endorsed -jar FISHEYE_HOME/fisheyeboot.jar"```

Add to

```FISHEYE_CMD="$JAVACMD $FISHEYE_OPTS -javaagent:/path/to/atlassian-agent-v1.2.2/atlassian-agent.jar -Dfisheye.library.path=$FISHEYE_LIBRARY_PATH -Dfisheye.inst=$FISHEYE_INST -Djava. awt.headless=true -Djava.endorsed.dirs=$FISHEYE_HOME/lib/endorsed -jar $FISHEYE_HOME/fisheyeboot.jar"```

Try to activate again.