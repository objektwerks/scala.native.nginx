#!/bin/zsh

curl -X PUT --verbose --data-binary @config.json \
   --unix-socket /opt/homebrew/var/run/unit/control.sock \
   http://localhost/config