FROM tomcat:8.0-alpine

LABEL maintainer="dev@bmsShop.com"
COPY target/bookzyWebApp.war /usr/local/tomcat/webapps/
COPY resources/setenv.sh /usr/local/tomcat/bin/
EXPOSE 8080
CMD ["catalina.sh","run"]                         
