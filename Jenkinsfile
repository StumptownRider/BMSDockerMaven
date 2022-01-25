pipeline {
    agent { label 'docker1' }

    environment {
            DOCKERHUB_CREDENTIALS = credentials('stumptownrider-dockerhub')
    }

    stages {
        stage('log mvn version') {
            }
            steps {
                sh 'mvn --version'
                sh 'mvn clean package'
            }
        }

        stage('build dockerfile'){
            steps {
                sh 'docker build -t stumptownRider/BMSApp:latest .'
            }
            
        }

        stage('Login to DockerHub'){
            steps {
                sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
            }
        }    

        stage('Push image to dockerhub'){
            steps {
                sh 'docker push stumptownRider/BMSApp:latest'
            }
        }    

        stage('Cleanup files') {
            steps {
                sh 'echo docker images'
                sh 'docker rmi stumptownRider/BMSApp:latest'
            }     
        }
    
    
    post {
        always {
            sh 'docker logout'
        }     
    }
    
}
