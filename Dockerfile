FROM tomcat:9.0.58-jre8-openjdk
LABEL Author = "Chris Iverson"
RUN chmod +x $CATALINA_HOME/bin
COPY ./target/BookMyShow.war /usr/local/tomcat/webapps
EXPOSE 8080
ENV CATALINA_OPS="-Xms256M -Xmx512M"
CMD ["catalina.sh","run"]              