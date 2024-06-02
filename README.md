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
11. There are two types of probes - liveliness and rediness probe. (Need to study it first and then I will comment here). But basically the port we setup at service.yaml, they try to hit the port of that respective pods for health check and whether or not the program is up. We can provide our custom endpoint for the same. We should adjust initialDelayinSeconds parameter, just to make sure that our pods are up and running and then these health checks should begin.
12. To package the helm, go to location where we have created the helm. Make sure folder should contain Chart.yaml. Command to package-> (helm package .) , this wil create .tgz file if we have created correct helm chart. In case of error try to read error and retry.
13. Now create a release for helm. It means under one release helm will deploy our different yaml files in our cluster. Before creating, go to folder which contains .tgz file.
    Command to create release, example- helm install {relase-name} .\kubernetes-basics-chart-0.1.1.tgz
14.  Now we need to check pod status to see if our pods are in ready state. It should be 1/1 (Ready/Running). It might take some time. Command to get pods- (kubectl get pods) . Commands to see spring-boot logs inside pod- (kubectl logs {pod-name}).
    Command to see logs of pod lifecycle (Essential for konwing pod health and debugging) - (kubectl describe {pod-name})
15. If pod enters the ready state, get the url from minikube to hit it from postman or browser. Command- (minikube service --url kubernetes-basics).
16. If things go wrong, delete the release and try again. Command to delete the releae- (helm uninstall {release-name}).
17. ToDo-- Read about helm upgrade, ingress, egress, node affinity
18. Some useful kubectl coammnds -
    1. kubectl get deployments
    2. kubectl get services
    3. kubectl delete pod {pod-name}
    4. kubectl exec -it {pod-name} -- {your command}
