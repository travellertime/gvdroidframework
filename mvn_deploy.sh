echo deploy gvdroid-base
cd ./gvdroid-base
mvn deploy -f pom.xml

echo deploy gvdroid-boot-dependencies
cd ./gvdroid-boot-dependencies
mvn deploy -f pom.xml

echo deploy gvdroid-boot-parent
cd ./gvdroid-boot-parent
mvn deploy -f pom.xml

echo deploy gvdroid-boot-starter-parent
cd ./gvdroid-boot-starter-parent
mvn deploy -f pom.xml

echo deploy gvdroid-boot-starters
cd ./gvdroid-boot-starters
mvn deploy -f pom.xml

echo deploy gvdroid-boot-starter-util
cd ./gvdroid-boot-starter-util
mvn deploy -f pom.xml

echo deploy gvdroid-boot-starter-validation
cd ./gvdroid-boot-starter-validation
mvn deploy -f pom.xml

echo deploy gvdroid-boot-starter-redis
cd ./gvdroid-boot-starter-redis
mvn deploy -f pom.xml

echo deploy gvdroid-boot-starter-logging
cd ./gvdroid-boot-starter-logging
mvn deploy -f pom.xml

echo deploy gvdroid-boot-starter-mybatis
cd ./gvdroid-boot-starter-mybatis
mvn deploy -f pom.xml

echo deploy gvdroid-boot-starter-security
cd ./gvdroid-boot-starter-security
mvn deploy -f pom.xml

echo deploy gvdroid-boot-starter-helper
cd ./gvdroid-boot-starter-helper
mvn deploy -f pom.xml

echo deploy gvdroid-boot-starter-autoconfigure
cd ./gvdroid-boot-starter-autoconfigure
mvn deploy -f pom.xml

echo deploy gvdroid-boot-starter-desire
cd ./gvdroid-boot-starter-desire
mvn deploy -f pom.xml

echo deploy gvdroid-boot-starter
cd ./gvdroid-boot-starter
mvn deploy -f pom.xml

echo deploy gvdroid-cloud-dependencies
cd ./gvdroid-cloud-dependencies
mvn deploy -f pom.xml

echo deploy gvdroid-cloud-parent
cd ./gvdroid-cloud-parent
mvn deploy -f pom.xml

echo deploy gvdroid-cloud-starters
cd ./gvdroid-cloud-starters
mvn deploy -f pom.xml

echo deploy gvdroid-cloud-starter-autoconfigure
cd ./gvdroid-cloud-starter-autoconfigure
mvn deploy -f pom.xml

echo deploy gvdroid-cloud-starter
cd ./gvdroid-cloud-starter
mvn deploy -f pom.xml


echo deploy completed.
cd ..
