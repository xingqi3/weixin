#! /bin/bash

mvn install

cd cangk
mvn spring-boot:start

cd ../subscribe
mvn spring-boot:start

cd ../unsubscribe
mvn spring-boot:start

cd ../self-menu
mvn spring-boot:start

