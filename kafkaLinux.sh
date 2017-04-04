#!/bin/bash
sh /binaries/zookeeper-server-start.sh /config/zookeeper.properties;

echo "Waiting for zookeeper to start";
sleep 7

sh /binaries/kafka-server-start.sh /config/server.properties;
