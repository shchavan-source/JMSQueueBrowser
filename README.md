# JMS Queue Browser Example
This is a sample code to connect to the amq broker and fetch the timestamp of the messages.
The timestamp is displayed in milliseconds.

## Prerequisite
Following must be present to execute the code on any system
- Java 8
- maven

## Execution
1. Clone or download the code.
2. Navigate to the JMSQueuBrowser directory
3. Creating the jar file
```shell
$ mvn clean package
```
4. Navigate to target directory
5. Run the following command to execute the code
```shell
$ java -cp JMSQueuBrowser-1.0-SNAPSHOT-jar-with-dependencies.jar org.jms.browser.JMSBrowser "{{broker url}}" "{{user}}" "{{password}}" "{{QueueName}}"
```
The timestamp for all the messages will be displayed in the milliseconds