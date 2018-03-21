# Containerization example project

Simple project to show how to deal with docker containers and images.

# Prerequisites
- docker 17.05 and above
- gradle 4.6 and above
- python 3

# How to run

First of all you need to build java project. 

Run python script by typing in your terminal

```bash
python3 scripts/docker.py --name [name-for-docker-cont] --tag [tag-for-docker-img] --type [default or multistage]
```

If you don't enter any of script parameters it will override by default values --name tut --tag tut:latest --type multistage.

If you have any problem with running multistage build, you should run gradle script on you local machine before run python script.

```bash
gradle -b backend/build.gradle clean build
```

After that docker container with simple person data generator should start. As result of request you should obtain JSON.
In terminal type

```bash
curl -XGET localhost:8080/api/people_data?amount=<desired_number_less_than_100>
```

Usefull cheatsheets and other thigs

[docker cheatsheet](https://github.com/wsargent/docker-cheat-sheet)

[best practices for writing Dockerfiles](https://docs.docker.com/develop/develop-images/dockerfile_best-practices/)

