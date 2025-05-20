FROM bellsoft/liberica-openjdk-alpine:17.0.8

#install curl and jq
RUN apk add curl jq
# workspace
WORKDIR /home/selenium-docker

#Add the required files
ADD target/docker-resources ./
ADD runner.sh runner.sh
#we can add any files,like below
#ADD pom.xml pom.xml

#start the runner.sh
ENTRYPOINT sh runner.sh





#ENTRYPOINT java -cp 'libs/*' \
#           -Dselenium.grid.enabled=true \
#           -Dselenium.grid.hubHost=${HUB_HOST} \
#           -Dbrowser=${BROWSER} \
#           org.testng.TestNG \
#           -threadcount ${THREAD_COUNT} \
#           test-suites/${TEST_SUITE}