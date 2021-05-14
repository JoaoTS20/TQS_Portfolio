pipeline {
    agent any
    tools {
        jdk 'jdk11'
        maven 'maven'
}
stages {
    stage('test java installation') {
        steps {
            sh 'java -version'
        }
    }
    stage('test maven installation') {
        steps {
            dir('lab4/exercicio2_3/'){
                sh 'mvn -version'
            }
        }
    }
    }
}
