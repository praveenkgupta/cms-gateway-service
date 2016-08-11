#!/bin/bash
exec 2>&1
HOST=`hostname`
SERVICEPORT=_SERVICE_PORT_
HEALTHPORT=_HEALTH_PORT_
IP=` host $HOST | egrep "address|10"  | awk '{print $NF}' | head -1 `
SCRIPT="/usr/local/fk-ops-vip-health-check-module/port_check.pl"
if [ -f $SCRIPT ]; then
  exec $SCRIPT $IP $SERVICEPORT $HEALTHPORT
else
  echo "$SCRIPT does not exist, not starting the health checker, going to sleep instead"
  sleep 86400
fi
