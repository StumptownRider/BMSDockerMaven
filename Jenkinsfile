pipeline {
    agent any

    environment {
            DOCKERHUB_CREDENTIALS = credentials('stumptownrider-dockerhub')
    }

    stages {
        stage('buld test package') {
            steps {
                sh 'mvn --version'
                sh 'mvn clean package'
            }
        }

        stage('build dockerfile'){
            steps {
                sh 'docker build -t stumptownrider/bmsapp:latest .'
            }
            
        }

        stage('Login to DockerHub'){
            steps {
                sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
            }
        }    

        stage('Push image to dockerhub'){
            steps {
                sh 'docker push stumptownrider/bmsapp:latest'
            }
        }    

        stage('Cleanup files') {
            steps {
                sh 'echo docker images'
                sh 'docker rmi stumptownrider/bmsapp:latest'
            }     
        }

        stage('test ssh remote execution') {
            steps {
                sshagent(credentials:['docker-worker-key']) {
                    // some block
                    sh "ssh -o StrictHostKeyChecking=no -l ubuntu 172.31.93.15 'whoami'"
                    sh "ssh -o StrictHostKeyChecking=no -l ubuntu 172.31.93.15 \
                    'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'"
                    sh "ssh -o StrictHostKeyChecking=no -l ubuntu 172.31.93.15 'docker run --name tomcat --rm -d -p 8080:8080 stumptownrider/bmsapp:latest'"
                }
            }
        }
    }
    
    
    post {
        always {
            sh 'docker logout'
        }     
    }
    
}
