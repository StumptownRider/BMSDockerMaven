pipeline {
    agent { 
        docker { 
                label 'docker'
                image 'maven:3.3.3' 
             }
          }

    environment {
        app
    }

    stages {
        stage('log mvn version') {
            steps {
                sh 'mvn --version'
                sh 'mvn clean package'
            }
        }

        stage('build dockerfile'){
            app = docker.build("stumptownRider/BMSApp")
        }

        stage('Push image to docker'){
            docker.withRegistry('https://registry.hub.docker.com', 'dockerHubCredentials'){
                app.push("latest")
            }
        }        
    
    }
}