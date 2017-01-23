#!/usr/bin/env bash

SUCCESSES=successes.log
FAILURES=failures.log

rm $SUCCESSES $FAILURES

for i in inputs/*; do
  echo "Passing in $i"
  if java -jar target/GroupDocs-1.0-SNAPSHOT.jar "$i"; then
    echo "$i" >> $SUCCESSES
  else
    echo "$i" >> $FAILURES
  fi
done
