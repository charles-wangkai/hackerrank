#!/bin/bash

awk '
{avg = ($2 + $3 + $4) / 3;
 if (avg >= 80) {
    result = "A";
 } else if (avg >= 60) {
    result = "B";
 } else if (avg >= 50) {
    result = "C";
 } else {
    result = "FAIL";
 }
 print $0, ":", result;
}
'