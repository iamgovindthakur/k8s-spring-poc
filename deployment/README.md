### Repository for the k8s-spring-poc

#### K8s manifest files 
* postgres-config.yaml
* postgres-secret.yaml
* postgres.yaml
* backend-app.yaml

#### K8s commands

##### start Minikube and check status
    minikube start --vm-driver=hyperkit 
    minikube status

##### get minikube node's ip address
    minikube ip

##### get basic info about k8s components
    kubectl get node
    kubectl get pod
    kubectl get svc
    kubectl get all

##### get extended info about components
    kubectl get pod -o wide
    kubectl get node -o wide

##### get detailed info about a specific component
    kubectl describe svc {svc-name}
    kubectl describe pod {pod-name}

##### get application logs
    kubectl logs {pod-name}
    
##### stop your Minikube cluster
    minikube stop

<br />

> :warning: **Known issue - Minikube IP not accessible** 

If you can't access the NodePort service backend-app with `MinikubeIP:NodePort`, execute the following command:
    
    minikube service backend-app-service

<br />

#### Links
* postgres db image on Docker Hub: https://hub.docker.com/_/postgres
* backend-app image on Docker Hub: https://hub.docker.com/repository/docker/iamgovindthakur/k8s-spring-poc
* k8s official documentation: https://kubernetes.io/docs/home/
* backend-app code repo: https://github.com/iamgovindthakur/k8s-spring-poc
