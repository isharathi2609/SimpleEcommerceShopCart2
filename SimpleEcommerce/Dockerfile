FROM tomcat:9.0-jdk1.8-openjdk

# Purani files saaf karein
RUN rm -rf /usr/local/tomcat/webapps/*

# Step 1: Web pages copy karein (dot '.' ka matlab hai current folder)
COPY ./src/main/webapp /usr/local/tomcat/webapps/ROOT

# Step 2: Classes copy karein (Bina kisi extra slash ke)
COPY ./build/classes /usr/local/tomcat/webapps/ROOT/WEB-INF/classes

EXPOSE 8080
CMD ["catalina.sh", "run"]