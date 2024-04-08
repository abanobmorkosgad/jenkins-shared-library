#!/usr/bin/env groovy

def call() {
    echo "Building app from branch $BRANCH_NAME"
    sh "mvn package"
}