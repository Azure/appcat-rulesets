
# Azure Rules 
| ID  | Title | Category | Effort | Azure App Service | Azure Container Apps | Azure Kubernetes Service | Azure Spring Apps | Source file | 
| --- | ---   | ---      | ---    | ---               | ---                  | ---                      | ---               | ---         | 
| azure-aws-config-credential-01000 | AWS credential configuration | mandatory | 3 | X | X | X | X | azure-aws-config.windup.xml |
| azure-aws-config-region-02000 | AWS region configuration | mandatory | 3 | X | X | X | X | azure-aws-config.windup.xml |
| azure-aws-config-s3-03000 | AWS S3 configuration | mandatory | 3 | X | X | X | X | azure-aws-config.windup.xml |
| azure-aws-config-sqs-04000 | Amazon Simple Queue Service configuration | mandatory | 3 | X | X | X | X | azure-aws-config.windup.xml |
| azure-aws-config-secret-manager-05000 | AWS Secrets Manager configuration | mandatory | 3 | X | X | X | X | azure-aws-config.windup.xml |
| azure-cache-redis-01000 | Redis Cache connection string found | information | 0 | X | X | X | X | azure-cache.windup.xml |
| azure-database-config-jdbc-01000 | JDBC connection found in configuration file | information | 0 | X | X | X | X | azure-database-config.windup.xml |
| azure-database-config-mongodb-02000 | MongoDB connection found in configuration file | information | 0 | X | X | X | X | azure-database-config.windup.xml |
| azure-database-config-r2dbc-03000 | R2DBC connection found in configuration file | information | 0 | X | X | X | X | azure-database-config.windup.xml |
| azure-file-system-02000 | Relative path found | optional | 5 | X | X | X | X | azure-file-system.windup.xml |
| azure-file-system-03000 | Home path found | optional | 5 | X | X | X | X | azure-file-system.windup.xml |
| azure-java-version-01000 | Non-LTS version Java | mandatory | 3 | X | X | X | X | azure-java-version.windup.xml |
| azure-java-version-02000 | Java version found to be lower than JAVA_8 | mandatory | 3 | X | X | X | X | azure-java-version.windup.xml |
| azure-keystore-certificates-01000 | Java KeyStore file found | potential | 3 | X | X | X | X | azure-keystore-certificates.windup.xml |
| azure-keystore-certificates-02000 | The application loads certificates into a KeyStore | potential | 3 | X | X | X | X | azure-keystore-certificates.windup.xml |
| azure-mq-config-kafka-01000 | Kafka connection string, username or password found in configuration file | information | 0 | X | X | X | X | azure-mq-config.windup.xml |
| azure-mq-config-rabbitmq-01000 | RabbitMQ connection string, username or password found in configuration file | information | 0 | X | X | X | X | azure-mq-config.windup.xml |
| azure-mq-config-artemis-01000 | ActiveMQ Artemis connection string, username or password found in configuration file | information | 0 | X | X | X | X | azure-mq-config.windup.xml |
| azure-password-01000 | Password found in configuration file | potential | 3 | X | X | X | X | azure-password.windup.xml |
| azure-static-content-01000 | Static content found in the application | optional | 5 | X | X | X | X | azure-static-content.windup.xml |
| azure-system-config-01000 | Environment variables/system properties | optional | 1 | X | X | X | X | azure-system-config.windup.xml |
| azure-tas-binding-01000 | Tanzu Application Service service bindings | potential | 3 | X | X | X | X | azure-tas-binding.windup.xml |
| eap-to-azure-appservice-datasource-driver-01000 | Datasource driver found in configuration file | potential | 3 | X |  | X |  | eap-to-azure-appservice-datasource-driver.windup.xml |
| eap-to-azure-appservice-pom-001 | Get started with JBoss EAP on App Service | optional | 1 | X |  |  |  | eap-to-azure-appservice-pom.windup.xml |
| jetty-to-azure-external-resources-01000 | External resources found in configuration file | optional | 5 | X | X | X | X | jetty-to-azure-external-resources.windup.xml |
| spring-boot-to-azure-config-server-01000 | Explicit Config Server connection info found in configuration file | information | 0 | X | X | X | X | spring-boot-to-azure-config-server.windup.xml |
| spring-boot-to-azure-config-server-02000 | Spring Cloud Config Server found | information | 0 | X | X | X | X | spring-boot-to-azure-config-server.windup.xml |
| spring-boot-to-azure-eureka-01000 | Explicit eureka connection info found in configuration file | information | 0 | X | X | X | X | spring-boot-to-azure-eureka.windup.xml |
| spring-boot-to-azure-port-01000 | Server port configuration found | information | 0 | X | X | X | X | spring-boot-to-azure-port.windup.xml |
| spring-boot-to-azure-restricted-config-01000 | Restricted configurations found | information | 0 |  |  |  | X | spring-boot-to-azure-restricted-config.windup.xml |
| spring-boot-to-azure-schedule-job-01000 | The application uses Quartz to scheduled jobs | mandatory | 7 | X | X | X | X | spring-boot-to-azure-schedule-job.windup.xml |
| spring-boot-to-azure-spring-boot-version-01000 | Spring Boot version too low | potential | 5 | X | X | X | X | spring-boot-to-azure-spring-boot-version.windup.xml |
| spring-boot-to-azure-spring-boot-version-02000 | Spring Boot version out of support | information | 2 | X | X | X | X | spring-boot-to-azure-spring-boot-version.windup.xml |
| spring-boot-to-azure-spring-boot-version-03000 | Spring Boot version out of OSS support | information | 1 | X | X | X | X | spring-boot-to-azure-spring-boot-version.windup.xml |
| spring-boot-to-azure-spring-cloud-version-01000 | Spring Cloud version too low | potential | 5 | X | X | X | X | spring-boot-to-azure-spring-cloud-version.windup.xml |
| spring-boot-to-azure-spring-cloud-version-02000 | spring cloud version out of support | information | 2 | X | X | X | X | spring-boot-to-azure-spring-cloud-version.windup.xml |
| tomcat-to-azure-external-resources-01000 | External resources found in configuration file | optional | 5 | X | X | X | X | tomcat-to-azure-external-resources.windup.xml |

# OpenJDK 11 Rules 
| ID  | Title | Category | Effort | Source file | 
| --- | ---   | ---      | ---    | ---         | 
| java-removals-00000 | Methods in `java.lang.Thread` have been removed | mandatory | 3 | java-removals.windup.xml | 
| java-removals-00010 | sun.reflect.Reflection class was deprecated in Java 9 | mandatory | 1 | java-removals.windup.xml | 
| java-removals-00020 | sun.reflect.CallerSensitive annotation was deprecated in Java 9 | mandatory | 1 | java-removals.windup.xml | 
| java-removals-00030 | The `javax.security.auth.Policy` class has been removed | mandatory | 3 | java-removals.windup.xml | 
| java-removals-00040 | AWT SecurityManager method java.lang.SecurityManager.{method-name} has been removed in Java 11 | mandatory | 1 | java-removals.windup.xml | 
| java-removals-00041 | SecurityManager method java.lang.SecurityManager.checkMemberAccess has been removed | mandatory | 1 | java-removals.windup.xml | 
| java-removals-00050 | The java.util.logging.LogManager.addPropertyChangeListener() method was removed in Java 9 | mandatory | 1 | java-removals.windup.xml | 
| java-removals-00060 | The java.util.logging.LogManager.removePropertyChangeListener() method was removed in Java 9 | mandatory | 1 | java-removals.windup.xml | 
| java-removals-00100 | Property listener methods on `Pack200.Packer` and `Pack200.Unpacker` have been removed | mandatory | 3 | java-removals.windup.xml | 
| java-removals-00110 | Methods in `sun.misc.Unsafe` have been removed | mandatory | 1 | java-removals.windup.xml | 
| java-removals-00120 | The `sun.misc.BASE64{encoder-decoder}` class has been removed | mandatory | 1 | java-removals.windup.xml | 
| java-removals-00130 | The `runFinalizersOnExit` methods have been removed | mandatory | 1 | java-removals.windup.xml | 
| java-removals-00140 | The `java.awt.Font.getPeer()` and `java.awt.Component.getPeer()` methods have been removed | mandatory | 3 | java-removals.windup.xml | 
| java-removals-00150 | Changes in ClassLoader hierarchy in JDK 11 may impact code | potential | 1 | java-removals.windup.xml | 
| removed-javaee-modules-00000 | The java.activation (JAF) module has been removed from OpenJDK 11 | mandatory | 1 | removed-javaee-modules.windup.xml | 
| removed-javaee-modules-00010 | The java.corba module has been removed from OpenJDK 11 | mandatory | 1 | removed-javaee-modules.windup.xml | 
| removed-javaee-modules-00020 | The java.annotation (Common Annotations) module has been removed from OpenJDK 11 | mandatory | 1 | removed-javaee-modules.windup.xml | 

# OpenJDK 17 Rules 
| ID  | Title | Category | Effort | Source file | 
| --- | ---   | ---      | ---    | ---         | 
| applet-api-deprecation-00000 | The Java Applet API has been deprecated | mandatory | 3 | applet-api-deprecation.windup.xml | 
| lombok-incompatibility-00001 | The Lombok version is incompatible with Open JDK 17 | mandatory | 3 | lombok.windup.xml | 
| removed-classes-00000 | The java.util.jar.{class-name} class has been removed | mandatory | 3 | removed-classes.windup.xml | 
| removed-packages-00000 | The java.rmi.activation detected | mandatory | 3 | removed-packages.windup.xml | 
| removed-packages-00010 | The jdk.nashorn.api.scripting and jdk.nashorn.api.tree packages have been removed | mandatory | 3 | removed-packages.windup.xml | 
| security-manager-deprecation-00000 | The java.security.{class-name} class has been deprecated | mandatory | 5 | security-manager-deprecation.windup.xml | 
| security-manager-deprecation-00010 | The {fqcn} class has been deprecated | mandatory | 5 | security-manager-deprecation.windup.xml | 
| security-manager-deprecation-00020 | The java.lang.System.{method-name} method has been deprecated | mandatory | 5 | security-manager-deprecation.windup.xml | 
| security-manager-deprecation-00030 | java.lang.Thread.checkAccess method has been deprecated | mandatory | 5 | security-manager-deprecation.windup.xml | 
| security-manager-deprecation-00040 | java.lang.ThreadGroup.checkAccess method has been deprecated | mandatory | 5 | security-manager-deprecation.windup.xml | 
| security-manager-deprecation-00050 | java.util.logging.LogManager.checkAccess method has been deprecated | mandatory | 5 | security-manager-deprecation.windup.xml | 
| security-manager-deprecation-00060 | The java.util.concurrent.Executors.{method-names} method has been deprecated | mandatory | 5 | security-manager-deprecation.windup.xml | 
| security-manager-deprecation-00070 | javax.security.auth.Subject.{meth-name} method has been deprecated | mandatory | 5 | security-manager-deprecation.windup.xml | 

# OpenJDK 21 Rules 
| ID  | Title | Category | Effort | Source file | 
| --- | ---   | ---      | ---    | ---         | 
| deprecation-00000 | Deprecated method in JDK 18 for removal in future release | potential | 3 | deprecation-openjdk18.windup.xml | 
| deprecation-00005 | Deprecated method in JDK 18 for removal in future release | mandatory | 3 | deprecation-openjdk18.windup.xml | 
| deprecation-00010 | Deprecated class in JDK 19 for removal in future release | mandatory | 3 | deprecation-openjdk19.windup.xml | 
| deprecation-00020 | Deprecated class in JDK 20 for removal in future release | mandatory | 3 | deprecation-openjdk20.windup.xml | 
| deprecation-00030 | Deprecated class in JDK 21 for removal in future release | mandatory | 3 | deprecation-openjdk21.windup.xml | 
| dynamic-agents-00000 | Dynamic loading of agents will be removed at a later JDK release | potential | 3 | dynamic-agents.windup.xml | 
| finalization-deprecation-00000 | Finalization has been deprecated for removal in a future release by JDK18. | potential | 3 | finalization-deprecation.windup.xml | 
| finalization-deprecation-00010 | Finalization has been deprecated for removal in a future release by JDK18. | mandatory | 3 | finalization-deprecation.windup.xml | 
| removed-apis-00000 | These finalization methods have been removed | mandatory | 3 | removed-apis.windup.xml | 
| removed-apis-00005 | Method java.lang.ThreadGroup.allowThreadSuspension() has been removed | mandatory | 1 | removed-apis.windup.xml | 
| removed-apis-00010 | Method java.lang.Compiler has been removed | mandatory | 3 | removed-apis.windup.xml | 
| removed-apis-00015 | javax.management.remote.rmi.RMIIIOPServerImpl | mandatory | 3 | removed-apis.windup.xml | 
| utf-8-by-default-00000 | The java.io.{class-name} constructor uses UTF-8 by default | potential | 1 | utf-8-by-default.windup.xml | 
| utf-8-by-default-00010 | The java.util.{class-names} constructor uses UTF-8 by default | potential | 1 | utf-8-by-default.windup.xml | 
| utf-8-by-default-00020 | The java.net.URLEncoder.encode method uses UTF-8 by default | potential | 1 | utf-8-by-default.windup.xml | 
| utf-8-by-default-00030 | The java.net.URLDecoder.decode method uses UTF-8 by default | potential | 1 | utf-8-by-default.windup.xml | 

# Cloud Readiness Rules 
| ID  | Title | Category | Effort | Source file | 
| --- | ---   | ---      | ---    | ---         | 
| embedded-cache-01000 | Caching - Ehcache embedded library | cloud-mandatory | 5 | embedded-cache.windup.xml | 
| embedded-cache-02000 | Caching - Coherence embedded library | cloud-mandatory | 5 | embedded-cache.windup.xml | 
| embedded-cache-03000 | Caching - Apache Commons JCS embedded library | cloud-mandatory | 5 | embedded-cache.windup.xml | 
| embedded-cache-04000 | Caching - Dynacache embedded library | cloud-mandatory | 5 | embedded-cache.windup.xml | 
| embedded-cache-05000 | Caching - Embedded library | cloud-mandatory | 5 | embedded-cache.windup.xml | 
| embedded-cache-06000 | Caching - Hazelcast embedded library | cloud-mandatory | 5 | embedded-cache.windup.xml | 
| embedded-cache-07000 | Caching - Apache Ignite embedded library | cloud-mandatory | 5 | embedded-cache.windup.xml | 
| embedded-cache-08000 | Caching - Infinispan embedded library | cloud-mandatory | 5 | embedded-cache.windup.xml | 
| embedded-cache-09000 | Caching - JBoss Cache embedded library | cloud-mandatory | 5 | embedded-cache.windup.xml | 
| embedded-cache-10000 | Caching - JCache embedded library | cloud-mandatory | 5 | embedded-cache.windup.xml | 
| embedded-cache-11000 | Caching - Memcached client embedded library | cloud-mandatory | 5 | embedded-cache.windup.xml | 
| embedded-cache-12000 | Caching - Oscache embedded library | cloud-mandatory | 5 | embedded-cache.windup.xml | 
| embedded-cache-13000 | Caching - ShiftOne (Java Object Cache) embedded library | cloud-mandatory | 5 | embedded-cache.windup.xml | 
| embedded-cache-14000 | Caching - SwarmCache embedded library | cloud-mandatory | 5 | embedded-cache.windup.xml | 
| embedded-cache-15000 | Caching - Spring Boot Cache library | cloud-mandatory | 5 | embedded-cache.windup.xml | 
| embedded-cache-16000 | Caching - Redis Cache library | cloud-readiness | 5 | embedded-cache.windup.xml | 
| java-corba-00000 | CORBA | cloud-optional | 5 | java-corba.windup.xml | 
| java-rmi-00000 | Java Remote Method Invocation (RMI) service | cloud-mandatory | 7 | java-rmi.windup.xml | 
| java-rmi-00001 | Java Remote Method Invocation (RMI) API | cloud-mandatory | 7 | java-rmi.windup.xml | 
| java-rpc-00000 | Java API for XML-based RPC (JAX-RPC) | cloud-optional | 5 | java-rpc.windup.xml | 
| jca-00000 | Resource adapter descriptor (ra.xml) | cloud-optional | 1 | jca.windup.xml | 
| jni-native-code-00000 | Java native libraries (JNI, JNA) | cloud-mandatory | 7 | jni-native-code.windup.xml | 
| jni-native-code-00001 | Java Native Processes | cloud-mandatory | 7 | jni-native-code.windup.xml | 
| local-storage-00001 | File system - Java IO | cloud-mandatory | 3 | local-storage.windup.xml | 
| local-storage-00002 | File system - java.net.URL/URI | cloud-mandatory | 3 | local-storage.windup.xml | 
| local-storage-00003 | File system - File path URL | cloud-mandatory | 3 | local-storage.windup.xml | 
| local-storage-00004 | File system - 'file://' scheme | cloud-mandatory | 3 | local-storage.windup.xml | 
| local-storage-00005 | File system - Java NIO | cloud-mandatory | 3 | local-storage.windup.xml | 
| local-storage-00006 | Apache Commons I/O | cloud-mandatory | 3 | local-storage.windup.xml | 
| localhost-http-00001 | Local HTTP Calls | mandatory | 7 | localhost.windup.xml | 
| localhost-jdbc-00002 | Local JDBC Calls | mandatory | 7 | localhost.windup.xml | 
| localhost-ws-00003 | Local WebSocket Calls | mandatory | 7 | localhost.windup.xml | 
| logging-0000 | Don't log to file system | cloud-mandatory | 1 | logging.windup.xml | 
| logging-0001 | Logging to Socket Handler | cloud-mandatory | 3 | logging.windup.xml | 
| mail-00000 | Java Mail API | potential | 3 | mail.windup.xml | 
| session-00000 | HTTP session replication (distributable web.xml) | cloud-mandatory | 3 | session.windup.xml | 
| session-00001 | HTTP Session data storage | potential | 5 | session.windup.xml | 
| socket-communication-00000 | Socket communication | cloud-optional | 5 | socket-communication.windup.xml | 
| socket-communication-00001 | Java NIO channel | cloud-optional | 5 | socket-communication.windup.xml | 

# Linux Rules 
| ID  | Title | Category | Effort | Source file | 
| --- | ---   | ---      | ---    | ---         | 
| os-specific-00001 | Windows file system path | mandatory | 3 | os-specific.windup.xml | 
| os-specific-00002 | Dynamic-Link Library (DLL) | mandatory | 5 | os-specific.windup.xml | 

# Azure (overridden rules) Rules 
| ID  | Title | Category | Effort | Azure App Service | Azure Container Apps | Azure Kubernetes Service | Azure Spring Apps | Source file | 
| --- | ---   | ---      | ---    | ---               | ---                  | ---                      | ---               | ---         | 
| java-rmi-00000 | Java Remote Method Invocation (RMI) service | cloud-mandatory | 7 | X | X | X | X | java-rmi.windup.xml |
| java-rmi-00001 |  |  |  | X | X | X | X | java-rmi.windup.xml |
| jni-native-code-00000 | Java native libraries (JNI, JNA) | cloud-mandatory | 7 | X | X | X | X | jni-native-code.windup.xml |
| jni-native-code-00001 | Java Native Processes | cloud-mandatory | 7 | X | X | X | X | jni-native-code.windup.xml |
| local-storage-00001 | File system - Java IO | cloud-mandatory | 3 | X | X | X | X | local-storage.windup.xml |
| local-storage-00002 | File system - java.net.URL/URI | cloud-mandatory | 3 | X | X | X | X | local-storage.windup.xml |
| local-storage-00003 | File system - File path URL | cloud-mandatory | 3 | X | X | X | X | local-storage.windup.xml |
| local-storage-00004 | File system - 'file://' scheme | cloud-mandatory | 3 | X | X | X | X | local-storage.windup.xml |
| local-storage-00005 | File system - Java NIO | cloud-mandatory | 3 | X | X | X | X | local-storage.windup.xml |
| local-storage-00006 | Apache Commons I/O | cloud-mandatory | 3 | X | X | X | X | local-storage.windup.xml |
| logging-0000 | Don't log to file system | cloud-mandatory | 1 | X | X | X | X | logging.windup.xml |
| mail-00000 | Java Mail API | potential | 3 | X | X | X | X | mail.windup.xml |
| session-00001 | HTTP Session data storage | potential | 5 | X | X | X | X | session.windup.xml |
| os-specific-00001 | Windows file system path | mandatory | 3 | X | X | X | X | os-specific.windup.xml |
| os-specific-00002 | Dynamic-Link Library (DLL) | mandatory | 5 | X | X | X | X | os-specific.windup.xml |
| 3rd-party-05000 | Embedded library - Logstash | potential | 3 | X | X | X | X | 3rd-party.windup.xml |
| 3rd-party-20000 | Embedded library - Splunk | potential | 3 | X | X | X | X | 3rd-party.windup.xml |
| apm-00000 | Application Performance Management (APM) tool - Application Insights | mandatory | 1 | X | X | X | X | apm.windup.xml |
| apm-00001 | Application Performance Management (APM) tool - New Relic | mandatory | 1 | X | X | X | X | apm.windup.xml |
| apm-00002 | Application Performance Management (APM) tool - Elastic APM | mandatory | 3 | X | X | X | X | apm.windup.xml |
| apm-00003 | Application Performance Management (APM) tool - Dynatrace | mandatory | 3 | X | X | X | X | apm.windup.xml |
| clustering-00000 | Distributed Environments found | mandatory | 5 | X |  |  |  | clustering.windup.xml |
| configuration-management-0100 | Embedded library - Spring Cloud Config | information | 0 | X | X | X | X | configuration-management.windup.xml |
| configuration-management-0600 | Embedded library - Spring Cloud Vault | information | 0 | X | X | X | X | configuration-management.windup.xml |
| connect-01500 | ActiveMQ found | potential | 3 |  |  |  |  | connect.windup.xml |
| database-01500 | MySQL database found | potential | 3 |  |  |  |  | database.windup.xml |
| database-01700 | PostgreSQL database found | potential | 3 |  |  |  |  | database.windup.xml |
| database-01900 | Microsoft SQL database found | potential | 3 |  |  |  |  | database.windup.xml |
| database-02200 | Cassandra database found | potential | 3 |  |  |  |  | database.windup.xml |
| database-02500 | MongoDB database found | potential | 3 |  |  |  |  | database.windup.xml |
| database-03200 | MariaDB database found | potential | 3 |  |  |  |  | database.windup.xml |
| embedded-cache-libraries-01000 | EHCache library | potential | 5 | X | X | X | X | embedded-cache-libraries.windup.xml |
| embedded-cache-libraries-16000 | Redis Cache library | potential | 3 | X | X | X | X | embedded-cache-libraries.windup.xml |
| embedded-framework-09000 | Embedded framework - Feign | information | 0 | X | X | X | X | embedded-framework.windup.xml |
| embedded-framework-09100 | Embedded framework - Zipkin | information | 0 | X | X | X | X | embedded-framework.windup.xml |
| embedded-framework-09300 | Embedded framework - Eureka Client | information | 0 | X | X | X | X | embedded-framework.windup.xml |
| embedded-framework-09400 | Embedded framework - Eureka Server | information | 0 | X | X | X | X | embedded-framework.windup.xml |
| security-01900 | Embedded library - SAML | information | 0 | X | X | X | X | security.windup.xml |
| security-02800 | Embedded library - OpenSAML | information | 0 | X | X | X | X | security.windup.xml |
| security-03600 | Embedded framework - Spring Security | information | 0 | X | X | X | X | security.windup.xml |
| security-03700 | Embedded library - OAuth 2.0 | information | 0 | X | X | X | X | security.windup.xml |
| security-03800 | Embedded library - OpenID | information | 0 | X | X | X | X | security.windup.xml |
| technology-usage-web-01700 | Java Swing usage | potential | 3 | X | X | X | X | web.windup.xml |
| technology-usage-web-02300 | JavaFX usage | potential | 3 | X | X | X | X | web.windup.xml |
