#!/bin/bash

sed -e "s/^\(.*\)&/ \1 /" -e "s/\([^[:alnum:]]\)the\([^[:alnum:]]\)/\1this\2/" -e "s/^ \(.*\) &/\1/"