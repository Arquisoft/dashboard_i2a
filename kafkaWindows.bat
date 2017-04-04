C:
cd %TEMP%\kafka

echo Waiting for robocopy to end cloning kafka
TIMEOUT 7

start binaries\windows\zookeeper-server-start.bat config\zookeeper.properties

echo Waiting for zookeeper to start
TIMEOUT 7

binaries\windows\kafka-server-start.bat config\server.properties
