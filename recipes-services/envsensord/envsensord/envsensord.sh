#!/bin/sh
### BEGIN INIT INFO
# Provides:          envsensord
# Required-Start:    $network
# Required-Stop:     $network
# Default-Start:     2 3 4 5
# Default-Stop:      0 1 6
# Short-Description: Environment Sensor Daemon
### END INIT INFO

DAEMON=/usr/bin/envsensord
NAME=envsensord
PIDFILE=/var/run/$NAME.pid

case "$1" in
    start)
        echo "Starting $NAME"
        start-stop-daemon --start --background --make-pidfile \
            --pidfile $PIDFILE --exec $DAEMON
        ;;
    stop)
        echo "Stopping $NAME"
        start-stop-daemon --stop --pidfile $PIDFILE
        rm -f $PIDFILE
        ;;
    restart)
        $0 stop
        sleep 1
        $0 start
        ;;
    status)
        if [ -f $PIDFILE ] && kill -0 $(cat $PIDFILE) 2>/dev/null; then
            echo "$NAME is running (PID $(cat $PIDFILE))"
        else
            echo "$NAME is not running"
            exit 1
        fi
        ;;
    *)
        echo "Usage: $0 {start|stop|restart|status}"
        exit 1
        ;;
esac

exit 0
