# Wildfly is giving errors with the CSV files
# 12:29:36,348 ERROR [io.undertow.request] (default task-1) UT005023:
# Exception handling request to /alpacashow-admin-backend/webservice/showevent:
# javax.servlet.ServletException: java.io.FileNotFoundException:
# /content/alpacashow-admin-backend.war/WEB-INF/classes/csv/SHOWEVENTS.csv (No such file or directory)
# FROM jboss/wildfly
# ADD target/alpacashow-admin-backend.war /opt/jboss/wildfly/standalone/deployments/
FROM tomcat:8.0.20-jre8
COPY target/alpacashow-admin-backend.war /usr/local/tomcat/webapps/


