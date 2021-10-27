#!/bin/bash
curl -X PUT --data-binary @config.json \
   --unix-socket unix:/opt/homebrew/var/run/unit/control.sock \
   http://localhost/config