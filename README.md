# Containerization example project

Simple project to show how to deal with docker containers and images.

# Prerequisites
- docker 17.05 and above
- gradle 4.6 and above
- python 3

# How to run

First of you need to build java project.
Run python script by typing in your terminal
```bash
python3 scripts/docker.py --name [name-for-docker-cont] --tag [tag-for-docker-img] --type [default or multistage]
```

If you not enter any of script parameters it will overide by default values --name tut --tag tut:latest --type multistage.
If you have any problem with running multistage build you should run gradle script on you local machine before that.
```bash
gradle -b backend/build.gradle clean build
```

After that docker container with simple person data generator should start. As result you should obtain JSON.
In terminal type
```bash
curl -XGET localhost:8080/api/people_data?amount=<desired_number_less_than_100>
```
