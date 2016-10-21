(require '[arachne.core.dsl :as core])
(require '[arachne.hello :as hello])


(core/runtime :arachne-hello-app/runtime [:arachne-hello-app/spanish :arachne-hello-app/informal])

(hello/greeter :arachne-hello-app/spanish "Hola")
(hello/greeter :arachne-hello-app/informal "Dude!")
