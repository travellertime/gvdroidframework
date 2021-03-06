@echo compile gvdroid-base
cd ./gvdroid-base
call mvn clean install -Dmaven.test.skip=true

@echo compile gvdroid-boot-dependencies
cd ../gvdroid-boot-dependencies
call mvn clean install -Dmaven.test.skip=true

@echo compile gvdroid-boot-parent
cd ../gvdroid-boot-parent
call mvn clean install -Dmaven.test.skip=true

@echo compile gvdroid-boot-starters
cd ../gvdroid-boot-starters
call mvn clean install -Dmaven.test.skip=true


@echo compile gvdroid-boot-starter-autoconfigure
cd ../gvdroid-boot-starter-autoconfigure
call mvn clean install -Dmaven.test.skip=true

@echo compile gvdroid-boot-starter-desire
cd ../gvdroid-boot-starter-desire
call mvn clean install -Dmaven.test.skip=true

@echo compile gvdroid-boot-starter-helper
cd ../gvdroid-boot-starter-helper
call mvn clean install -Dmaven.test.skip=true

@echo compile gvdroid-boot-starter-logging
cd ../gvdroid-boot-starter-logging
call mvn clean install -Dmaven.test.skip=true

@echo compile gvdroid-boot-starter-mybatis
cd ../gvdroid-boot-starter-mybatis
call mvn clean install -Dmaven.test.skip=true

@echo compile gvdroid-boot-starter-redis
cd ../gvdroid-boot-starter-redis
call mvn clean install -Dmaven.test.skip=true

@echo compile gvdroid-boot-starter-security
cd ../gvdroid-boot-starter-security
call mvn clean install -Dmaven.test.skip=true

@echo compile gvdroid-boot-starter-util
cd ../gvdroid-boot-starter-util
call mvn clean install -Dmaven.test.skip=true

@echo compile gvdroid-boot-starter-validation
cd ../gvdroid-boot-starter-validation
call mvn clean install -Dmaven.test.skip=true

@echo compile gvdroid-boot-starter-desire
cd ../gvdroid-boot-starter-desire
call mvn clean install -Dmaven.test.skip=true

@echo compile completed.
cd ..
