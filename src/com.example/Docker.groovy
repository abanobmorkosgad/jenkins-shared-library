#!/usr/bin/env groovy
package com.example

class Docker implements Serializable {

    def script

    Docker(script){
       this.script = script 
    }
    def buildImage(String imageName) {
        script.echo "Building docker image.."
        script.sh "docker build -t $imageName ."
    }

    def dockerLogin(){
        script.withCredentials([script.usernamePassword(credentialsId: 'DockerCred', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
            script.sh "docker login -u $script.USER -p $script.PASS"
        }
    }

    def pushImage(String imageName){
        script.sh "docker push $imageName"
    }
}