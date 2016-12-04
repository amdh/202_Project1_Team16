
1> Develop a server code in Eclipse using Restler

2> Test the code usign POstman

3> Export the runnable jar file from Eclipse usign Export functionality
  - add jars in external folder

4> Test the jar file using 'java -jar app.jar'

5> Create a docker file and run the command used in step 4 

6> Build a docker image using 'docker build -t pirates:v0 .'

7> Run docker using 'docker run --name pirates_v0 -p 80:8080 -td pirates:v0'

8> Test the running docker container

9> Login to docker hub by using 'docker login' Provide credentials.

10> Tag that container as 'docker tag pirates:v0 amrutadh/pirates_v0'

11> Push the docker tagged image using 'docker push amrutadh/pirates_v0'