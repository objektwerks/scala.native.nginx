Scala Native Nginx
------------------
>Scala native nginx unit server and client built on **Apple M1** using Scala 3.

Install
-------
>See http://www.scala-native.org/en/latest/user/setup.html for details.
1. brew install llvm
2. brew install bdw-gc
3. brew install nginx/unit/unit

Start, Verify and Stop Nginx Unit
---------------------------------
1. **start:** nohup unitd --no-daemon --log /dev/stdout --control unix:control.sock &
2. **verify:** ps ax | grep unitd
3. **stop:** Ctrl-C

Build, Install and Deploy NowServer
-----------------------------------
1. sbt clean compile nativeLink
```
Multiple main classes detected. Select one to run:
 [1] objektwerks.NowClient
 [2] objektwerks.NowServer

Enter number: 2
```
2. mv target/scala-3.3.1-RC6/scala-native-nginx-out target/scala-3.3.1-RC6/now-server
3. sudo cp target/scala-3.3.1-RC6/now-server /usr/local/bin
4. nohup unitd --no-daemon --log /dev/stdout --control unix:control.sock & (***start nginx unit, if stopped***)
5. ./deploy.sh  ( chmod 755 deploy.sh )
>See **config.json** for Nginx Unit / NowServer configuration.

Build and Install NowClient
---------------------------
1. sbt clean compile nativeLink
```
Multiple main classes detected. Select one to run:
 [1] objektwerks.NowClient
 [2] objektwerks.NowServer

Enter number: 1
```
2. mv target/scala-3.3.1-RC6/scala-native-nginx-out target/scala-3.3.1-RC6/now-client
3. sudo cp target/scala-3.3.1-RC6/now-client /usr/local/bin

NowClient Test
--------------
1. nohup unitd --no-daemon --log /dev/stdout --control unix:control.sock & (***start nginx unit, if stopped***)
2. now-client [ url ] ( the default NowServer url is: http://localhost:7474/ )

Curl Test
---------
1. nohup unitd --no-daemon --log /dev/stdout --control unix:control.sock & (***start nginx unit, if stopped***)
2. curl http://localhost:7474/
3. kill -9 pid ( rm control.sock nohup.out )

Resources
---------
1. [Scala Native Docs](http://www.scala-native.org/en/latest/index.html)
2. [Scala Native Intro Video](https://www.youtube.com/watch?v=u2CnE-sRdBw)
3. [NUnit](http://unit.nginx.org)
4. [SNUnit](https://github.com/lolgab/snunit)
5. [Sttp Native](https://softwaremill.com/scala-native-sttp-toolkit/)