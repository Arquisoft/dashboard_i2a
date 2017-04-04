#!/bin/bash
/binaries/zookeeper-server-start.sh /config/zookeeper.properties;

echo "Waiting for zookeeper to start";
sleep 7

/binaries/kafka-server-start.bat /config/server.properties;
