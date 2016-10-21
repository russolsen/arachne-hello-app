(require '[arachne.core.dsl :as core])
(require '[arachne.hello :as hello])


(core/runtime :arachne_hello_app/runtime [:arachne_hello_app/spanish :arachne_hello_app/informal])

(hello/greeter :arachne_hello_app/spanish "Hola")
(hello/greeter :arachne_hello_app/informal "Dude!")
