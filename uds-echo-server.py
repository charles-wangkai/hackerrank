#!/usr/bin/env python2.7

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

def process_client_connection(connection):
    print "entered process_client_connection()"
    while True:
        # read message 
        message = read_string_from_socket(connection)

        print "Message received =", message

        # Your logic goes here
        # write message back to clinet
        write_string_to_socket(connection, message)

        if message == "END":
            break

def main():
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
