#!/usr/bin/env python3

def main():
    K = int(input())
    room_numbers = input().split()
    
    unique_room_numbers = set()
    duplicated_room_numbers = set()
    for room_number in room_numbers:
        if room_number in unique_room_numbers:
            unique_room_numbers.remove(room_number)
            duplicated_room_numbers.add(room_number)
        elif room_number not in duplicated_room_numbers:
            unique_room_numbers.add(room_number)
    
    print(next(iter(unique_room_numbers)))

if __name__ == "__main__":
    main()
