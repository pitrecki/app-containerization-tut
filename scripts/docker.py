#!/usr/bin/python3

import argparse
from subprocess import Popen, PIPE


def parse_args():
    parser = argparse.ArgumentParser()
    parser.add_argument('--name', help='set name for docker container', default='tut')
    parser.add_argument('--tag', help='set tag', default='tut:latest')
    parser.add_argument('--type', help='multistage or default', default='multistage')
    return parser.parse_args()


def convert_docker_type(type):
    dict = {'multistage': './Dockerfile-multi-stage', 'default': './Dockerfile'}
    if type in dict:
        return dict.get(type)


def execute(name, tag, type):
    print('docker build')
    print_output(Popen(["docker", "build", "-t", tag, "-f", type, "."],
                       stdout=PIPE, bufsize=1, universal_newlines=True))
    print('docker run container ', name)
    print_output(Popen(["docker", "run", "-d", "-it", "--name", name, "-p", "8080:8080", "-m", "1GB", tag],
                       stdout=PIPE, bufsize=1, universal_newlines=True))


def cleanup(name, tag):
     print('Remove container')
     Popen(["docker", "rm", "-f", name], stdout=PIPE)
     print('Remove image')
     Popen(["docker", "rmi", "-f", tag], stdout=PIPE)

def print_output(proc):
    for line in proc.stdout:
        print(line, end='')

if __name__ == '__main__':
    args = parse_args()
    converted_type = convert_docker_type(args.type)
    cleanup(args.name, args.tag)
    execute(args.name, args.tag, converted_type)
