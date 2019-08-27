(defproject hello-world "0.1.0"

  :dependencies [[org.clojure/clojure "1.10.1"]
                 [aleph "0.4.7-alpha5"]]

  ;; You must specify `:main` so that Leiningen can generate the correct
  ;; `Main-Class` MANIFEST.MF entry.
  :main hello-world.core

  ;; Enable AOT-compilation for uberjar only.
  :profiles {:uberjar {:aot :all}}

  :uberjar-name "hello-world.jar")
