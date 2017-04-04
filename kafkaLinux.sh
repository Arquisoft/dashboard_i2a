#!/bin/bash
/bin/zookeeper-server-start.sh /config/zookeeper.properties;

echo "Waiting for zookeeper to start";

/bin/kafka-server-start.bat /config/server.properties;
