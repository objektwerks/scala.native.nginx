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
* **start:** unitd --no-daemon --log /dev/stdout --control unix:control.sock
* **verify:** ps ax | grep unitd
* **stop:** Ctrl-C

Deploy
------
>Deploy to local nginx unit server:
1. sbt clean compile nativeLink
2. mv target/scala-2.13/scala-native-nginx-out target/scala-2.13/now
3. sudo cp target/scala-2.13/now /usr/local/bin
4. unitd
5. ./deploy.sh  ( chmod 755 deploy.sh )
6. curl http://localhost:7474/now
7. Ctrl-C

Test
----
1. unitd --no-daemon --log /dev/stdout --control unix:control.sock
2. curl http://localhost:7474/now
3. Ctrl-C

Resources
---------
1. Scala Native Docs - http://www.scala-native.org/en/latest/index.html
2. Scala Native Intro Video - https://www.youtube.com/watch?v=u2CnE-sRdBw
