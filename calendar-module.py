#!/usr/bin/env python3

import calendar

def main():
    month, day, year = map(int, input().split())
    
    print(calendar.day_name[calendar.weekday(year, month, day)].upper())

if __name__ == '__main__':
    main()
