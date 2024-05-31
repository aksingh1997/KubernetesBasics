FROM openjdk:17-alpine
WORKDIR /app
COPY target/Kubernetes-0.0.2.jar /app/Kubernetes.jar
CMD ["java","-jar","-Dmaven.test.skip=true","-Dspring.config.location=/etc/bookUtil/application.yaml" ,"/app/Kubernetes.jar"]
#Use CMD command instead of RUN. RUN tries to run the command during docker build, where as cmd command only runs when container is starting.Kubernetes
#Commamnd to docker build image = docker build -t armun/kubernetes:v1 . (This is important to note armun/{yourimagename}. here armun refers to my remote repo username, otherwise my push will fail)
#Command to run docker image = docker run -p 8080:8080 kubernetes:v1
#Command to push to remote directory - docker push armun/kubernetes-basics:v1