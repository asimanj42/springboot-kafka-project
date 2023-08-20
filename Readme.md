### Proyekt haqqında:
Proyektin əsas məqsədi wikimedia'da baş verən data dəyişikliyini qeydə almaq,producer tərəfindən kafka topic'ə yazmaq,consumer tərəfindən isə bu dataları database'ə save etməkdir.
Http üzərindən event handling üçün OkHttp kitabxanasından istifadə edilib.
Qeyd:Wikimedianı internet üzərindəki ensiklopediay kimi düşünmək olar.Wikimedia'dakı data dəyişikliyini(event streaming) https://stream.wikimedia.org/v2/stream/recentchange linkindən izləmək olar.










### Əlavələr:
Zookeper'i docker üzərindən qaldırmaq üçün:
docker run --name zookeeper -p 2181:2181 zookeeper

Apache Kafka'nı docker üzərindən qaldırmaq üçün:
docker run --name kafka -p 9092:9092 ^ -e KAFKA_ZOOKEEPER_CONNECT=(local ip):2181 ^ -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://(local ip):9092 ^ -e KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR=1 ^ confluentinc/cp-kafka

Produce olunan message'ları görmək üçün:
docker exec -it {kafka container name} kafka-console-consumer --bootstrap-server {kafka server port} --topic {topic name} --from-beginning