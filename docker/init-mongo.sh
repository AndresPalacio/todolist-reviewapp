#!/bin/bash
set -e

# provision mongodb from environment variables

SATOSA_DATABASE=${SATOSA_DATABASE:="satosa"}
SATOSA_USERNAME=${SATOSA_USERNAME:="satosa"}
SATOSA_PASSWORD=${SATOSA_PASSWORD:="satosa"}
SATOSA_FRONTEND=${SATOSA_FRONTEND:="https://crust-docker.daasi.de"}

# echo "DATABASE" $SATOSA_DATABASE
# echo "USERNAME" $SATOSA_USERNAME
# echo "PASSWORD" $SATOSA_PASSWORD
# echo "FRONTEND" $SATOSA_FRONTEND
# exit

mongo <<EOF
db = db.getSiblingDB('${SATOSA_DATABASE}')

db.createCollection('clients')

db.clients.insertOne(
  {
    'lookup_key': '405533',
    'data': {
        'application_type': 'web',
        'client_name': 'didmos2 lui client',
        'initiate_login_uri': '${SATOSA_FRONTEND}',
        'frontchannel_logout_uri': '${SATOSA_FRONTEND}',
        'redirect_uris': [
            '${SATOSA_FRONTEND}'
        ],
        'response_types': [
            'token id_token'
        ],
        'client_id': '405533'
    }
  }
)

db.createUser(
  {
    user: '${SATOSA_USERNAME}',
    pwd: '${SATOSA_PASSWORD}',
    roles: [
       { role: 'readWrite', db: '${SATOSA_DATABASE}' }
    ]
  }
)
EOF
