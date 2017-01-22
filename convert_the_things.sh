#!/usr/bin/env bash

for i in *; do
  echo "Passing in $i"
  java -jar target/GroupDocs-1.0-SNAPSHOT.jar "$i"
done
