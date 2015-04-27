#!/bin/bash

countries=(`cat -`)
countries=("${countries[@]/#[A-Z]/.}")
echo "${countries[@]}"