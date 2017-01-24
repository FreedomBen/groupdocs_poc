#!/usr/bin/env bash

SUCCESSES=successes.log
FAILURES=failures.log

rm $SUCCESSES $FAILURES

for i in input/*; do
  echo "Passing in $i"
  if java -Xms3072m -Xmx4096m -jar target/GroupDocs-1.0-SNAPSHOT.jar "$i"; then
    echo "$i" >> $SUCCESSES
  else
    echo "$i" >> $FAILURES
  fi
done
