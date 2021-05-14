pipeline {
    agent {
        docker {
            image 'maven:3.8.1-adoptopenjdk-11' 
            args '-v /root/.m2:/root/.m2' 
        }
    }
    options{
        skipStagesAfterUnstable()
    }
    stages {
        stage('Build') { 
            steps {
                dir('lab4/exercicio2_3/'){
                    sh 'mvn -B -DskipTests clean package' 
                }
            }
        }
        stage('Test') {
            steps {
                dir('lab4/exercicio2_3/'){
                    sh 'mvn test'
                }
            }
            post {
                always {
                    dir('lab4/exercicio2_3/'){
                    junit 'target/surefire-reports/*.xml'
                    }
                }
            }
        }
        stage('Deliver') {
            steps {

                sh './jenkins/scripts/deliver.sh'
                
            }
        }
    }
}