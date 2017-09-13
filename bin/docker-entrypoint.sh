#!/bin/bash
#++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++#
##
##   @DESCRIPTION : Microservice For crawlserver
##   @NAME        : docker-entrypoint.sh
##   @VERSION     : 1.0.0
##   @CREATE      : 2017-01-16 17:39:11
##   @UPDATE      : 2017-02-08 15:15:37
##   @MAINTAINER  : colin.lee<likunyao@rongshutong.com>
##
#++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++#
set -e
### constant
WORKDIR=/app
OK="\033[32m [OK] \033[0m"
ERROR="\033[31m [ERROR] \033[0m"

gen_config() {
    # suppervisor
    echo -e " - configurating: supervisor"
    cp $WORKDIR/conf/supervisord.conf /etc
    chmod 644 /etc/supervisord.conf
    echo -e " - configurating: config.template"
    envsubst > $WORKDIR/conf/application.properties.ctmpl <  $WORKDIR/conf/application.properties.ctmpl.template

    # consul
    echo -e " - configurating: consul.hcl"
    envsubst > $WORKDIR/conf/consul.hcl < $WORKDIR/conf/consul.hcl.template

    # permission
    echo -e " - configurating: permission"
    mkdir /data/logs -p
    chown -R worker:worker /app /data
}

init() {
    echo -e "*** STEP: generate config file..."
    gen_config
}

## run command
# check for the expected command
if [ "$1" = 'supervisord' ]; then
    # run command
    init
    # use gosu to drop to a non-root user
    echo -e "*** STEP: running supervisor..."
    exec gosu worker "$@"
fi

# else default to run whatever the user wanted like "bash"
exec "$@"
