#!/bin/zsh

curl -X PUT --unix-socket control.sock -d @config.json localhost/config