def call(String imageName){
    echo "Building docker image.."
    withCredentials([usernamePassword(credentialsId: 'DockerCred', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        sh "docker build -t  $imageName ."
        sh "docker login -u $USER -p $PASS"
        sh "docker push $imageName"
    }
}

