Scala Native Nginx
------------------
>Scala native nginx unit server built on Apple M1 using Scala 3.

Install
-------
>See http://www.scala-native.org/en/latest/user/setup.html for details.
1. brew install llvm
2. brew install nginx/unit/unit

Start and Stop Nginx
--------------------
1. **start:** nohup unitd --no-daemon --log /dev/stdout --control unix:control.sock &
2. **verify:** ps ax | grep unitd
3. **stop:** Ctrl-C

Build and Deploy
----------------
>Deploy to/run on local nginx unit server:
1. sbt clean compile nativeLink
2. mv target/scala-3.3.1-RC6/scala-native-nginx-out target/scala-3.3.1-RC6/now
3. sudo cp target/scala-3.3.1-RC6/now /usr/local/bin
4. nohup unitd --no-daemon --log /dev/stdout --control unix:control.sock &
5. ./deploy.sh  ( chmod 755 deploy.sh )
6. curl http://localhost:7474/
7. kill -9 pid ( rm control.sock nohup.out )

Curl Test
---------
1. nohup unitd --no-daemon --log /dev/stdout --control unix:control.sock &
2. curl http://localhost:7474/
3. kill -9 pid ( rm control.sock nohup.out )

Sttp Curl Test
--------------
1. sbt clean compile run
```
Multiple main classes detected. Select one to run:
 [1] objektwerks.NowClient
 [2] objektwerks.NowServer

Enter number: 1
```

Resources
---------
1. [Scala Native Docs](http://www.scala-native.org/en/latest/index.html)
2. [Scala Native Intro Video](https://www.youtube.com/watch?v=u2CnE-sRdBw)
3. [NUnit](http://unit.nginx.org)
4. [SNUnit](https://github.com/lolgab/snunit)