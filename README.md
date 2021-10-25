# Atlassian Agent v1.3.1
 
#### Support (almost any version, include 8.0):
* JIRA Software [FAQ](doc/JIRA_FAQ.md)
* JIRA Core
* JIRA Service Desk
* JIRA plugin: Capture
* JIRA plugin: Training
* JIRA plugin: Portfolio
* Confluence [Windows Special Note ](doc/Confluence_FAQ.md)
* Confluence plugin: Questions
* Confluence plugin: Team Calendars
* Bamboo [FAQ](doc/Bamboo_FAQ.md)
* Bitbucket [FAQ](doc/Bitbucket_FAQ.md)
* FishEye [FAQ](doc/FishEye_Crucible_FAQ.md)
* Crowd [FAQ](doc/Crowd_FAQ.md)
* Crucible [FAQ](doc/FishEye_Crucible_FAQ.md)
* Third party plugins
 
## Instructions
 
### Advantages
* Support almost all Atlassian products, and also support plug-ins (including third-party plug-ins in the plug-in market).
* Support DataCenter mode.
* Compared with the traditional crack , you can easily upgrade your service without having to crack it again.
* Provide java- based command line keygen , which is more convenient to use in the terminal environment.
* Open source project, you know what you did when you cracked it.
 
### Direct download
* Directly download the [release](https://gitee.com/pengzhile/atlassian-agent/releases) package of this project .
 
### Compile by yourself
* Clone the source code of this project, and the pom.xml directory can be compiled after executing `mvn package` at the same level .
* Use the `atlassian-agent-jar-with-dependencies.jar` produced in the `target` directory instead of `atlassian-agent.jar` !
* * If you don’t know what I’m talking about, it’s best to download the package I compiled directly. *
 
### Using Help
*The cracking needs to be used in a complete set, not just the plug-in, but the `atlassian-agent.jar` cracking service must be used first .
* If you have obtained `atlassian-agent.jar` , you can try to execute `java -jar atlassian-agent.jar` to see the help output.
* The help here uses Atlassian 's Confluence service as an example.
 
### Configuration Agent
1. Put `atlassian-agent.jar` in a location that you will not delete randomly (all Atlassian services on your server can share the same `atlassian-agent.jar` ).
2. Set the environment variable `JAVA_OPTS` (this is actually the environment variable of Java , used to specify the parameters attached when starting the java program), and attach the `-javaagent` parameter. Specifically, you can do this:
   * You can put commands like `export JAVA_OPTS="-javaagent:/path/to/atlassian-agent.jar ${JAVA_OPTS}"` into a file like `.bashrc` or `.bash_profile` .
   * You can put: `Export the JAVA_OPTS =" - the javaagent: /path/to/atlassian-agent.jar the JAVA_OPTS $ {} "` such an order where the service is installed into the `bin directory ` under the `setenv.sh` or ` setenv.bat (for windows use) ` in.
   * You can also directly execute the command line: `JAVA_OPTS="-javaagent:/path/to/atlassian-agent.jar" /path/to/start-confluence.sh` to start your service.
   * Or other methods of modifying environment variables that you know, but if there are unrelated services on your machine, it is not recommended to modify the global `JAVA_OPTS` environment variable.
   * In short, you find a way to attach the `-javaagent` parameter to the java process to be started .
3. Please restart your Confluence service after the configuration is complete .
4. If you want to verify whether the configuration is successful, you can do this:
   * Execute a similar command: `ps aux|grep java` find the corresponding process to see if the `-javaagent` parameter is correctly attached.
   *It is similar to the software installation directory: `/path/to/confluence/ logs/ catalina.out` Tomcat log should be found: `========= agent working =========` The output words.
 
### Use KeyGen
* You have to confirm that the agent has been configured , refer to the above instructions.
* When you try to execute `java -jar /path/to/atlassian-agent.jar` , you should be able to see the output of KeyGen parameter help.
* Please take a closer look at the function of each parameter, especially the value range of the `-p` parameter. The content of the `-p` parameter is best to be enclosed in quotation marks, otherwise it may affect the parameter parsing.
* Third-party plug its ` application key / plug keyword ` as `-p` parameters. Such as: `-p'com.gliffy.integration.confluence'`
* In Atlassian when the service is installed you should see something like: `AAAA-BBBB-CCCC-DDDD` the Server the above mentioned id , please pay attention.
* Providing the correct parameters and running KeyGen will output the calculated activation code on the terminal.
* Copy the generated activation code to activate the service you want to use.
* For example: `java -jar atlassian-agent.jar -p conf -m aaa@bbb.com -n my_name -o https://zhile.io -s ABCD-1234-EFGH-5678`
 
### Statement
* This project is only for personal study and research purposes, and cannot be used for commercial purposes!
*For commercial use, please purchase the genuine version from [Atlassian](https://www.atlassian.com) , thank you for your cooperation!
* This project uses the `GNU General Public License v3.0` open source license!
*It is not allowed to say that my code is poorly written. For me, `PHP` is the best language in the world (to argue with dissatisfaction).
 
### Communication
* Send an issue to this project .
* You are welcome to improve this project together, please send a PR .
* You can join the QQ group: 30347511 and communicate with me in real time.
* Visit the website: [https://zhile.io](https://zhile.io) Leave me a message.
 
### Enthusiastic netizens tutorial (thanks to the original author, invaded and deleted!)
* [ One-click installation and configuration script for enthusiastic guys ](https://github.com/alues/atlassian_install_script)
* [confluence installation and cracking ](https://www.qinjj.tech/2019/01/04/confluence%20install/)
* [ [Black Technology] Atlassian product line full crack ](https://tech.cuixiangbin.com/?p=1248)
* [ Install JIRA and Confluence via Docker (cracked version) ](https://www.jianshu.com/p/b95ceabd3e9d)
* [ Install JIRA and Confluence via Docker (cracked version) ](https://my.oschina.net/wuweixiang/blog/3014644)