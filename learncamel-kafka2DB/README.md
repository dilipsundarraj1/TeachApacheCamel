## LearnCamel  Kafka + DB Integration

In this project we develop a stand alone Java project that reads from a Kafka topic and persist in to DB(Postgres).

## How to start a zookeeper ?

**Windows:**

```
zookeeper-server-start.bat ..\..\config\zookeeper.properties
```

**MAC/Unix:**

```
./zookeeper-server-start.sh ../config/zookeeper.properties
```
## How to start a Kafka Broker ?

**Windows:**

```
kafka-server-start.bat ..\..\config\server.properties
```

**MAC/Unix :**

```
./kafka-server-start.sh ../config/server.properties
```

## How to check the configuration of all the topics in a broker ?
**Windows**

```
kafka-topics.bat --describe --zookeeper localhost:2181
```

**MAC:**
```
./kafka-topics.sh --describe --zookeeper localhost:2181
```

## How to create a topic ?
**Windows**
```
kafka-topics.bat --create --topic <topic-name> -zookeeper localhost:2181 --replication-factor 1 --partitions 1.
```
Example:  

```
kafka-topics.bat --create --topic my-topic -zookeeper localhost:2181 --replication-factor 1 --partitions 1.
```

**MAC:**  
```
./kafka-topics.sh --create --topic <topic-name> -zookeeper localhost:2181 --replication-factor 1 --partitions 1

```

Example:  
The below command creates a topic called **my-topic**.
```
./kafka-topics.sh --create --topic my-topic -zookeeper localhost:2181 --replication-factor 1 --partitions 1
```

## How to check the configuration of a particular topic?
**Windows**

```
kafka-topics.bat --describe --topic my-topic --zookeeper localhost:2181
```
**MAC:**  
```
./kafka-topics.sh --describe --topic my-topic --zookeeper localhost:2181
```

## How to instantiate a Console Producer?

**Windows:**
```
kafka-console-producer.bat --broker-list localhost:9092 --topic <topic-name>
```

Example:  
```
kafka-console-producer.bat --broker-list localhost:9092 --topic my-topic
```

**MAC:**  
```
./kafka-console-producer.sh --broker-list localhost:9092 --topic <topic-name>
```

Example :

```
./kafka-console-producer.sh --broker-list localhost:9092 --topic my-topic
```

## How to instantiate a Console Consumer?

**Windows:**
```
kafka-console-producer.bat --broker-list localhost:9092 --topic <topic-name>
```

Example:  
```
kafka-console-consumer.bat --zookeeper localhost:2181 --topic my-topic --from-beginning.

```

**MAC**  
```
./kafka-console-consumer.sh --zookeeper localhost:2181 --topic <topic-name> --from-beginning
```

Example:  
```
./kafka-console-consumer.sh --zookeeper localhost:2181 --topic my-topic --from-beginning
```
