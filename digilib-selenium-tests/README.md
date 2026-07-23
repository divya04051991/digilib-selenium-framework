mvn clean test -U -Dapp.home=https://iahlvlcjf-dev.logistics.corp/cjf-template -Dbrowser=Chrome -Dtest=AllTests -DskipTests=false -Djunit.jupiter.execution.parallel.enabled=false -Djava.util.logging.config.file=src/test/resources/logging.properties

-U for updating snapshot - use it for the first run

-Dhttps.proxy=xyz.logistics.corp:3128  - if your environment has unauthenticated proxy.

-Dhttps.proxyHost=nadevproxy.logistics.corp -Dhttps.proxyPort=3128 -Dhttps.proxyUser=lastnamef -Dhttps.proxyPassword=yourADPassword