pipeline {
        environment {
            dockerImage = ''
        }

    agent { 
        docker { 
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

        stage('build dockerfile'){
            steps {
                script {
                    docker.build("stumptownRider/BMSApp")
                }
            }
        }

        stage('Push image to docker'){
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerHubCredentials')
                    dockerImage.push()
                }  
            }
        }    

        stage('Cleanup files') {
            steps {
                sh "docker images"
                //sh "docker rmi stumptownRider/BMSApp"
            }     
        }
    
    }
}