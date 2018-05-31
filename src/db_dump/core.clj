(ns db-dump.core
  (:gen-class)
  (use [clojure.java.shell :only [sh]]))

Setup the DB connection details
(def connection {
  :username "peter"
  :password ""
  :host "localhost"
  :DB "pinger"})


(defn -main
  "Dumps the DB"
  [& args]
  (def user (str "--user="(connection :username)))
  (def password (str "--password="(connection :password)))
  (def host (str "--host="(connection :host)))

  (sh "mysqldump" user password host (connection :DB) > "/path/to/dump/file.sql"))
