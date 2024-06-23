# Classic-Models-Java-EE-8-App

Classic Models Java EE 8 App

https://github.com/dhiihd/Classic-Models-Java-EE-8-App

For packaging the Java EE 8 enterprise archive EAR

$ mvn clean compile package install -Pwindows/-Plinux/-Pmac

Classic Models Java EE 8 App packed with features like Java 11 and Java EE 8,javafx and Java 21,rest api,xml,lombok,mapstruct,
log4j,java network launch protocol - jnlp,openwebstart,materialsfx,validatorfx

set/export system variable JDK_JAVA_OPTIONS = --illegal-access=warn --add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.lang.reflect=ALL-UNNAMED --add-opens java.base/java.text=ALL-UNNAMED --add-opens java.desktop/java.awt.font=ALL-UNNAMED

set/export JAVA_OPTS="-Xms1024m -Xmx4096m -Xss400m -Xmn1600m"

set/export MAVEN_OPTS="-Xms1024m -Xmx4096m -Xss400m -Xmn1600m"

Run the "Database Scripts\classic-models.sql" database script against your RDBMS

In this architecture, your business logic,business assets and IT infrastructure of any domain 
completely shielded to web