Scala Native NGINX
------------------
>Scala native nginx unit app built on Apple M1.

Install
-------
>See http://www.scala-native.org/en/latest/user/setup.html for details.
1. brew install llvm
2. brew install nginx/unit/unit

NGINX Unit
----------
>See documentation at: http://unit.nginx.org
* **start:** unitd
* **verify:** ps aux | grep nginx
* **stop:** pkill unitd

Deploy
------
>Deploy to local nginx unit server:
1. sbt clean compile nativeLink
2. mv target/scala-2.13/scala-native-nginx-out target/scala-2.13/now
3. sudo cp target/scala-2.13/now /usr/local/bin
4. unitd
5. Run 1) curl command or 2) shell script:
   1. curl -X PUT --verbose --data-binary @config \
     --unix-socket /opt/homebrew/var/run/unit/control.sock \
     http://localhost/config
   2. ./now.sh  ( chmod 755 now.sh )
7. curl http://localhost:7474/now
8. pkill unitd

Test
----
1. unitd
2. curl http://localhost:7474/now
3. pkill unitd

Resources
---------
1. Scala Native Docs - http://www.scala-native.org/en/latest/index.html
2. Scala Native Intro Video - https://www.youtube.com/watch?v=u2CnE-sRdBw