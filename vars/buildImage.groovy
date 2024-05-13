#!/usr/bin/env groovy 

def call() {
        echo "building docker image ..."
    withCredentials([
        usernamePassword(credentialsId: 'docker-credentials', usernameVariable: 'USER', passwordVariable: 'PASS')
    ]){
        sh "docker build -t abanobmorkos10/java-maven:1.0.0 ."
        sh "echo ${PASS} | docker login -u ${USER} --password-stdin"
        sh "docker push abanobmorkos10/java-maven:1.0.0"
    }
}