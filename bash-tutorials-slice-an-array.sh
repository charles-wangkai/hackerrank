#!/bin/bash

countries=(`cat -`)
echo "${countries[@]:3:5}"