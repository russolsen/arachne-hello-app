# Arachne Hello Module App

This application is a simple demo of using an Arachne module, namely the Arachne hello module
found at https://github.com/arachne-framework/hello-module.

To get started, look at the `src/arachne_hello_app.clj` file. The `-main` function does all that is necessary to load an Arachne config, and start the Arachne runtime. For interactive exploration at the REPL, you can also use the code in the comment block below the `-main` function.


## Using a module in your app

To add a new module -- `hello-module` for example -- to your application you need to do three basic things:
* Add the module as a dependancy to your application.
* Configure the module.
* Write the code to start your application with the module.


### Add a Dependancy

Add a reference to the module in your `project.clj`. This just an ordinary lein dependancy:

    (defproject arachne-hello-app "0.1.0-SNAPSHOT"
      :dependencies [[org.clojure/clojure "1.9.0-alpha13"]
                     [org.arachne-framework/hello-module "0.1.0"]
    ;; etc..

### Configure the Module

Go into your application configuration file -- `config/hello.clj` in this example app
and add the configuration for your module. The `hello-module` configuration is pretty
simple:

    (require '[arachne.core.dsl :as core])
    (require '[arachne.hello :as hello])

    (core/runtime :arachne-hello-app/runtime [:arachne-hello-app/spanish :arachne-hello-app/informal])

    (hello/greeter :arachne-hello-app/spanish "Hola")
    (hello/greeter :arachne-hello-app/informal "Dude!")

In the code above we are setting up a runtime called `:arachne-hello-app/runtime` that uses
two components, `:arachne-hello-app/spanish` and `:arachne-hello-app/informal`.

### Write the Code to Start Your Application With the Module

Finally you need to start up your application in your main program:

    (ns arachne-hello-app
      (:require [arachne.core :as arachne]
                [com.stuartsierra.component :as component]))
    
    (defn -main
      "Application entry point"
      [config-file & _]
      (let [cfg (arachne/build-config [:org.arachne-framework/hello-module] config-file)
            rt (arachne/runtime cfg :arachne-hello-app/runtime)]
        (component/start rt)))

There are a couple things to note about the code above:

 * The first argument to `arachne/build-config` 
is a vector of module ids used by the application -- `:org.arachne-framework/hello-module` in the example.
This is the id of the _module_ not the id you gave the components in your config file.

* In contrast, when you build the runtime with `arachne/runtime` you pass in the component id -- the
one you configured in your application config -- of your runtime component.


### Finally, Actually Run Your Application

Notice that the `-main` function you wrote above requires an Arachne Config File as an argument. You can call main from the REPL, passing in the String `"config/hello.clj"` to run your application. Or you can run your application using Leiningen from the command line:

`lein run "config/hello.clj"`

You should see the following output print to `stdout`:

`Dude!
Hola`
