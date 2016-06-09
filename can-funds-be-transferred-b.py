#!/usr/bin/env python3

import functools
import itertools

# # Use this function to write data to socket
# # write_string_to_socket(connection, message) where connection is the socket object and message is string

# # Use this function to read data from socket
# # def read_string_from_socket(connection) where connection is the socket object

# # All global declarations go here
parents = None
parent_probs = None

# # This function is called only once before any client connection is accepted by the server.
# # Read any global datasets or configurations here
def init_server():
    global parents, parent_probs
    
    print("Reading training set")
    
    f = open("training.txt")
    N = int(f.readline())
    parents = [None] * (N + 1)
    parent_probs = [None] * (N + 1)
    for _ in range(N - 1):
        u, v, p = map(int, f.readline().split(","))
        parents[v] = u
        parent_probs[v] = p / 100

# # This function is called everytime a new connection is accepted by the server.
# # Service the client here
def process_client_connection(connection):
    while True:
        # read message 
        message = read_string_from_socket(connection).decode()

        print ("Message received = ", message)
        
        if message == "END":
            result = message
        else:
            fields = message.split(",")
            a, b = map(int, fields[:2])
            q1 = float(fields[2])
            q = pow(10, q1)
            
            result = "YES" if compute_distance(a, b) > q else "NO"

        # write message
        write_string_to_socket(connection, result.encode())

        if message == "END":
            break

def compute_distance(a, b):
    path_a = find_path(a)
    path_b = find_path(b)
    
    while path_a and path_b and path_a[-1] == path_b[-1]:
        del path_a[-1]
        del path_b[-1]
    
    return functools.reduce(lambda x, y: x * y, map(lambda n:parent_probs[n], itertools.chain(path_a, path_b)))
    
def find_path(n):
    path = [n]
    while parents[n]:
        path.append(parents[n])
        n = parents[n]
    return path

# # Main structure
import socket
import threading

# NOTE: Use this path to create the UDS Server socket
SERVER_SOCKET_PATH = "./socket"

BUF_SIZE = 4096
BACKLOG = 10

def read_string_from_socket(connection):
    return connection.recv(BUF_SIZE)

def write_string_to_socket(connection, message):
    connection.send(message)

def main():
    init_server()
    
    sock = socket.socket(socket.AF_UNIX)
    sock.bind(SERVER_SOCKET_PATH)
    sock.listen(BACKLOG)
    while True:
        connection = sock.accept()[0]
        t = threading.Thread(target=process_client_connection, args=(connection,))
        t.start()
    sock.close()

if __name__ == "__main__":
    main()
