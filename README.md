Points helpful for making Docker / Kubernetes / Helm charts - 
1. Use CMD command instead of RUN. RUN tries to run the command during docker build, where as cmd command only runs when container is starting.Kubernetes
2. Commamnd to docker build image = docker build -t armun/kubernetes:v1 . (This is important to note armun/{yourimagename}. here armun refers to my remote repo username, otherwise my push will fail)
3. Command to run docker image = docker run -p 8080:8080 kubernetes:v1
4. Command to push to remote directory - docker push armun/kubernetes-basics:v1
5. Start minikube -  minkube start
6. Write your helm charts, update feilds in Values.yaml. Other yaml files in helm template refer Values.yaml to replace the placeholder.
7. Make sure to keep all naming convention small-case in kubernetes or helm, otherwise it gives error.
8. We can other yaml also which is not by default provided by helm chart, e.g. - ConfigMap.yaml
9. If we are config map as file to store key:value pairs, make sure to load is using @PropertySource in spring boot application. Also mount a volume and attach that volume with configMap in deployment.yaml.
10. Generally keep image pull-policy as 'Always'. What it does is, it takes fresh image from docker hub even though it is present locally. (maybe we have made some changes to docker image and pushed it with same name. Now kubernetes find it pull it from dockerhub, even though older image is present with same name).
11. There are two types of probes - liveliness and rediness probe. (Need to study it first and then I will my comment here).
