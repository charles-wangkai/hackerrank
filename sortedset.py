#!/usr/bin/env python3

import functools
import socket
import struct
import threading

# # Use this function to write data to socket
# # write_string_to_socket(connection, message) where connection is the socket object and message is string
# # Use this function to read data from socket
# # def read_string_from_socket(connection) where connection is the socket object
# # All global declarations go here
sets = {}

# # This function is called everytime a new connection is accepted by the server.
# # Service the client here
def process_client_connection(connection):
    while True:
        # read message
        value_num = read_number_from_socket(connection)
        
        values = []
        for _ in range(value_num):
            values.append(read_number_from_socket(connection))

        command = values[0]
        if command == 1:
            add_score(*values[1:])
            result = [0]
        elif command == 2:
            remove_key(*values[1:])
            result = [0]
        elif command == 3:
            size = get_size(*values[1:])
            result = [1, size]
        elif command == 4:
            score = get_score(*values[1:])
            result = [1, score]
        elif command == 5:
            set_ids = values[1:-3]
            lower, upper = values[-2:]
            elements = get_range(set_ids, lower, upper)
            
            result = functools.reduce(lambda x, y: x + y, elements, [len(elements) * 2])
        elif command == 6:
            connection.close()
            break

        # write message
        for number in result:
            write_number_to_socket(connection, number)

def add_score(set_id, key, score):
    if set_id not in sets:
        sets[set_id] = {}
    one_set = sets[set_id]
    
    one_set[key] = score
    
def remove_key(set_id, key):
    if set_id not in sets:
        return
    one_set = sets[set_id]
    
    if key in one_set:
        del one_set[key]
        
def get_size(set_id):
    if set_id in sets:
        return len(sets[set_id])
    else:
        return 0

def get_score(set_id, key):
    if set_id not in sets:
        return 0
    one_set = sets[set_id]
    
    if key in one_set:
        return one_set[key]
    else:
        return 0

def get_range(set_ids, lower, upper):
    elements = []
    for set_id in set_ids:
        if set_id in sets:
            one_set = sets[set_id]
            for key in one_set:
                score = one_set[key]
                if lower <= score <= upper:
                    elements.append([key, score])
                    
    elements.sort()
    return elements

# NOTE: Use this path to create the UDS Server socket
SERVER_SOCKET_PATH = "./socket"

FMT = "!L"
BACKLOG = 10

def read_number_from_socket(connection):
    return struct.unpack(FMT, connection.recv(4))[0]

def write_number_to_socket(connection, number):
    connection.send(struct.pack(FMT, number))

def main():
    sock = socket.socket(socket.AF_UNIX)
    sock.bind(SERVER_SOCKET_PATH)
    sock.listen(BACKLOG)
    while True:
        connection = sock.accept()[0]
        t = threading.Thread(target=process_client_connection, args=(connection,))
        t.start()
    sock.close()

if __name__ == '__main__':
    main()
