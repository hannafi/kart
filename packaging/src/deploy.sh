#!/usr/bin/env bash

VERSION=1.0.0-SNAPSHOT

cd ../target/kart-delivery

echo "Version :" ${VERSION}

echo "Packaging Api"
cd api
zip -r api-${VERSION}.zip api-${VERSION}.jar

echo "Packaging Admin"
cd ../admin
zip -r admin-${VERSION}.zip dist/ package.json server.js