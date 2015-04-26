#!/bin/bash

read expression

printf "%.3f\n" `echo "$expression" | bc -l`