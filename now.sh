#!/bin/zsh

curl -X PUT --verbose --data-binary @config \
   --unix-socket /opt/homebrew/var/run/unit/control.sock \
   http://localhost/config