(ns hello-world.core
  (:require [aleph.http :as http])
  ;; :gen-class is required to instruct the Clojure compiler to generate Java
  ;; classes.
  (:gen-class))


(defn handler
  [_]
  {:status  200
   :headers {"Content-Type" "text/plain"}
   :body    "Hello, world!"})


(defn -main
  [& args]
  ;; You must set the HTTP server to read the port number from the PORT
  ;; environment variable.
  ;;
  ;; Hard-coding the port to 8080 might work for now, but will yield warnings in
  ;; the log, so I think it's better to be safe than sorry.
  (let [port (Integer/parseInt (.getOrDefault (System/getenv) "PORT" "8080"))]
    (http/start-server handler {:port port})))
