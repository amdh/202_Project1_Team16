FROM openjdk

EXPOSE 8080

ADD ./app.jar /srv/app.jar
ADD ./app_lib/restlet.jar /srv/app_lib/restlet.jar
ADD ./app_lib/restlet-json.jar /srv/app_lib/restlet-json.jar
ADD ./app_lib/json.jar /srv/app_lib/json.jar

CMD cd srv ; java -jar app.jar