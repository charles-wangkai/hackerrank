#!/bin/bash

awk '{if ($2 == "" || $3 == "" || $4 == "") {print "Not all scores are available for", $1;}}'