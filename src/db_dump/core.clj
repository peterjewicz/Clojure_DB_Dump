(ns db-dump.core
  (:gen-class)
  (use [clojure.java.shell :only [sh]]))

; (def sites ["http://www.totalwebconnections.com", "https://www.simpleleadtrackers.com", "https://www.lifting-buddys.com"])
(def connection {:username "peter" :password "" :host "localhost" :DB "pinger"})
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (def user (str "--user="(connection :username)))
  (def password (str "--password="(connection :password)))
  (def host (str "--host="(connection :host)))

  (sh "mysqldump" user password host (connection :DB) > "/Applications/server/dbtest/leadTracker.sql")
  )
