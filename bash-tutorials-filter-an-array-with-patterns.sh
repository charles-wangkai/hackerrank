#!/bin/bash

countries=(`cat -`)
echo ${countries[@]/*[aA]*/}