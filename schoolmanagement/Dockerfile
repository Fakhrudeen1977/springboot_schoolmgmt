FROM openjdk8:latest           
VOLUME /tmp                
EXPOSE 8000                
ADD target/schoolmanagement.jar schoolmanagement.jar 
ENTRYPOINT ["java","-jar","/schoolmanagement.jar"]  

