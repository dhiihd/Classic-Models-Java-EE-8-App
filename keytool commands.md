$ keytool -genkeypair -alias ulctest -keyalg RSA -keysize 2048 -validity 365 -keystore classicModelsKeyStore.server.keystore   -storepass ulctest -ext "SAN:c=DNS:localhost,IP:127.0.0.1" -deststoretype pkcs12

$ keytool -importkeystore -srckeystore classicModelsKeyStore.server.keystore -destkeystore classicModelsKeyStore.server.keystore -deststoretype pkcs12

$ keytool -genkeypair -keyalg RSA -keysize 2048 -alias ulctest -ext "SAN:c=DNS:localhost,IP:127.0.0.1" -validity 3650 -storepass ulctest  -keystore ssl/classicModelsKeyStore.client.keystore -deststoretype pkcs12


$ keytool -exportcert  -keystore classicModelsKeyStore.server.keystore -alias ulctest  -storepass ulctest -file classicModelsKeyStore.server.crt
 
$ keytool -exportcert  -keystore classicModelsKeyStore.client.keystore -alias ulctest  -storepass ulctest -file classicModelsKeyStore.client.crt

$ keytool -importcert -keystore classicModelsKeyStore.server.truststore -storepass ulctest -alias client -trustcacerts -file classicModelsKeyStore.server.crt -noprompt
 
$ keytool -importcert -keystore classicModelsKeyStore.client.truststore -storepass ulctest -alias ulctest -trustcacerts -file classicModelsKeyStore.client.crt -noprompt

batch
# Configure Server Keystore 
/subsystem=elytron/key-store=demoKeyStore:add(path=classicModelsKeyStore.server.keystore,relative-to=jboss.server.config.dir, credential-reference={clear-text=secret},type=JKS)
# Server Keystore credentials   
/subsystem=elytron/key-manager=demoKeyManager:add(key-store=demoKeyStore,credential-reference={clear-text=secret})
# Server keystore Protocols   
/subsystem=elytron/server-ssl-context=demoSSLContext:add(key-manager=demoKeyManager,protocols=["TLSv1.2"])  
# Store SSL Context information in undertow 
/subsystem=undertow/server=default-server/https-listener=https:write-attribute(name=ssl-context,value=demoSSLContext)
run-batch 

openssl s_client -connect host:8443

remote+http://localhost:9993

keytool -import -noprompt -trustcacerts -alias ulctest -file classicModelsKeyStore.server.crt -keystore classicModelsKeyStore.server.keystore -storepass ulctest

-Dhttps.protocols=TLSv1,TLSv1.1,TLSv1.2 -Dcom.sun.security.enableAIAcaIssuers=true -Djavax.net.ssl.trustStore=truststores/client.ts -Djavax.net.ssl.trustStore=/pathtosomeselfsignedstore/truststore.jks

sudo keytool -importcert -file ssl/classicModelsKeyStore.client.crt -alias ulctest -keystore /usr/lib/jvm/bellsoft-java22-full-amd64/lib/security/cacerts -storepass ulctest

keytool -genkeypair -keyalg RSA -keysize 2048 -alias ulctest -ext "SAN:c=DNS:localhost,IP:127.0.0.1" -validity 3650 -storepass ulctest  -keystore ssl/classicModelsKeyStore.client.keystore -deststoretype pkcs12

sudo keytool -delete -alias ulctest -keystore ${JAVA_HOME}/lib/security/cacerts -storepass ulctest

keytool -keystore cacerts -importcert -noprompt -trustcacerts -alias cloudsslkey -file cloudcertificate.cer

keytool -delete -alias ulctest -keystore /usr/lib/jvm/bellsoft-java22-full-amd64/lib/security/cacerts -storepass ulctest
