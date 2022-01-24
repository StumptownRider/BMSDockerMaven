pipeline {
    agent { docker { 
                label 'docker'
                image 'maven:3.3.3' 
             }
          }
    stages {
        stage('log mvn version') {
            steps {
                sh 'mvn --version'
                sh 'mvn clean package'
            }
        }
    }
}