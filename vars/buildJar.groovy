#!/usr/bin/env groovy

def call() {
    echo "Building app.."
    sh "mvn package"
}