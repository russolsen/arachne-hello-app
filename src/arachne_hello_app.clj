(ns arachne-hello-app
  (:require [arachne.core :as arachne]
            [com.stuartsierra.component :as component]))

;; In a main function
(defn -main
  "Application entry point"
  [config-file & _]
  (let [cfg (arachne/build-config
              [:org.arachne-framework/hello-module]
              config-file)
        rt (arachne/runtime cfg :arachne_hello_app/runtime)]

    (component/start rt)))


;; From the REPL
(comment

  (def cfg (arachne/build-config
             [:org.arachne-framework/hello-module]
             "config/hello.clj"))

  (def rt (atom
            (arachne/runtime cfg :arachne_hello_app/runtime)))

  (swap! rt component/start)
  (swap! rt component/stop)

  )


(comment
  ;; explore the config...

  (require '[datomic.api :as d])

  (d/q '[:find ?i ?c
         :in $
         :where
         [?i :arachne.hello.greeter/greeting ?r]
         [?i :arachne.component/constructor ?c]]
      (:db cfg))

  (use 'clojure.pprint)

  (pprint
    (d/pull (:db cfg) '[*] 17592186045462))

  )
