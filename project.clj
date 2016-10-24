(defproject arachne-hello-app "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.9.0-alpha13"]
                 [org.arachne-framework/hello-module "0.1.0"]
                 [com.datomic/datomic-free "0.9.5404"
                  :exclusions [org.slf4j/slf4j-log4j12
                               org.slf4j/slf4j-nop
                               org.slf4j/slf4j-api
                               org.slf4j/log4j-over-slf4j]]

                 ;; Logging stuff...
                 [ch.qos.logback/logback-classic "1.1.3"]
                 [org.slf4j/jul-to-slf4j "1.7.12" :exclusions [org.slf4j/slf4j-api]]
                 [org.slf4j/jcl-over-slf4j "1.7.12"]
                 [org.slf4j/log4j-over-slf4j "1.7.12"]
                 ]

  :main arachne-hello-app

  :repositories [["arachne-dev" "http://maven.arachne-framework.org/artifactory/arachne-dev"]])
