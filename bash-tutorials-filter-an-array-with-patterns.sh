#!/bin/bash

countries=(`cat -`)
countries=(${countries[@]/*[aA]*/})
echo "${countries[@]}"