#!/bin/sh
set -e

echo;echo "### Parando....";echo
docker-compose -f docker-compose.yaml down
echo;echo "### Iniciando....";echo
docker-compose -f docker-compose.yaml up --build -d