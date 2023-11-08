#!/bin/sh
set -e

echo;echo "### Parando....";echo
docker-compose -f docker-compose.yaml down