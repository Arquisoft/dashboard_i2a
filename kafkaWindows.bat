robocopy kafka_2.11-0.10.2.0 %TEMP%\kafka /s
C:
cd %TEMP%\kafka

echo Waiting for robocopy to end cloning kafka
TIMEOUT 7

start bin\windows\zookeeper-server-start.bat config\zookeeper.properties

echo Waiting for zookeeper to start
TIMEOUT 7

bin\windows\kafka-server-start.bat config\server.properties
