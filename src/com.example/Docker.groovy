#!/usr/bin/env groovy
package com.example

class Docker implements Serializable {

    def script

    Docker(script){
       this.script = script 
    }
    def script.buildImage(String imageName) {
        script.echo "Building docker image.."
        script.withCredentials([script.usernamePassword(credentialsId: 'DockerCred', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
            script.sh "docker build -t $imageName ."
            script.sh "docker login -u $script.USER -p $script.PASS"
            script.sh "docker push $imageName"
        }
    }
}