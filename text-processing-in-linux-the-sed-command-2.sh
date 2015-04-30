#!/bin/bash

sed -e "s/^\(.*\)$/ \1 /" -e "s/\([^[:alnum:]]\)[tT][hH][yY]\([^[:alnum:]]\)/\1your\2/g" -e "s/^ \(.*\) $/\1/"