echo deploy gvdroid-base
cd ./gvdroid-base

mvn clean install org.apache.maven.plugins:maven-deploy-plugin:2.8:deploy -Dmaven.test.skip=true

echo deploy gvdroid-boot-dependencies
cd ../gvdroid-boot-dependencies

mvn clean install org.apache.maven.plugins:maven-deploy-plugin:2.8:deploy -Dmaven.test.skip=true

echo deploy gvdroid-boot-parent
cd ../gvdroid-boot-parent

mvn clean install org.apache.maven.plugins:maven-deploy-plugin:2.8:deploy -Dmaven.test.skip=true

echo deploy gvdroid-boot-starter-parent
cd ../gvdroid-boot-starter-parent

mvn clean install org.apache.maven.plugins:maven-deploy-plugin:2.8:deploy -Dmaven.test.skip=true

echo deploy gvdroid-boot-starters
cd ../gvdroid-boot-starters

mvn clean install org.apache.maven.plugins:maven-deploy-plugin:2.8:deploy -Dmaven.test.skip=true

echo deploy gvdroid-boot-starter-util
cd ../gvdroid-boot-starter-util

mvn clean install org.apache.maven.plugins:maven-deploy-plugin:2.8:deploy -Dmaven.test.skip=true

echo deploy gvdroid-boot-starter-validation
cd ../gvdroid-boot-starter-validation

mvn clean install org.apache.maven.plugins:maven-deploy-plugin:2.8:deploy -Dmaven.test.skip=true

echo deploy gvdroid-boot-starter-redis
cd ../gvdroid-boot-starter-redis

mvn clean install org.apache.maven.plugins:maven-deploy-plugin:2.8:deploy -Dmaven.test.skip=true

echo deploy gvdroid-boot-starter-logging
cd ../gvdroid-boot-starter-logging

mvn clean install org.apache.maven.plugins:maven-deploy-plugin:2.8:deploy -Dmaven.test.skip=true

echo deploy gvdroid-boot-starter-mybatis
cd ../gvdroid-boot-starter-mybatis

mvn clean install org.apache.maven.plugins:maven-deploy-plugin:2.8:deploy -Dmaven.test.skip=true

echo deploy gvdroid-boot-starter-security
cd ../gvdroid-boot-starter-security

mvn clean install org.apache.maven.plugins:maven-deploy-plugin:2.8:deploy -Dmaven.test.skip=true

echo deploy gvdroid-boot-starter-helper
cd ../gvdroid-boot-starter-helper

mvn clean install org.apache.maven.plugins:maven-deploy-plugin:2.8:deploy -Dmaven.test.skip=true

echo deploy gvdroid-boot-starter-autoconfigure
cd ../gvdroid-boot-starter-autoconfigure

mvn clean install org.apache.maven.plugins:maven-deploy-plugin:2.8:deploy -Dmaven.test.skip=true

echo deploy gvdroid-boot-starter-desire
cd ../gvdroid-boot-starter-desire

mvn clean install org.apache.maven.plugins:maven-deploy-plugin:2.8:deploy -Dmaven.test.skip=true

echo deploy gvdroid-boot-starter
cd ../gvdroid-boot-starter

mvn clean install org.apache.maven.plugins:maven-deploy-plugin:2.8:deploy -Dmaven.test.skip=true

echo deploy gvdroid-cloud-dependencies
cd ../gvdroid-cloud-dependencies

mvn clean install org.apache.maven.plugins:maven-deploy-plugin:2.8:deploy -Dmaven.test.skip=true

echo deploy gvdroid-cloud-parent
cd ../gvdroid-cloud-parent

mvn clean install org.apache.maven.plugins:maven-deploy-plugin:2.8:deploy -Dmaven.test.skip=true

echo deploy gvdroid-cloud-starters
cd ../gvdroid-cloud-starters

mvn clean install org.apache.maven.plugins:maven-deploy-plugin:2.8:deploy -Dmaven.test.skip=true

echo deploy gvdroid-cloud-starter-autoconfigure
cd ../gvdroid-cloud-starter-autoconfigure

mvn clean install org.apache.maven.plugins:maven-deploy-plugin:2.8:deploy -Dmaven.test.skip=true

echo deploy gvdroid-cloud-starter
cd ../gvdroid-cloud-starter

mvn clean install org.apache.maven.plugins:maven-deploy-plugin:2.8:deploy -Dmaven.test.skip=true


echo deploy completed.
cd ..
