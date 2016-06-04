#!/bin/bash

result=0

read N
read line
for Ai in $line; do
    result=$((result ^ Ai))
done

echo $result