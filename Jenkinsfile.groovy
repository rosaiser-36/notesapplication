pipeline {
    agent any

    stages {

        stage('Clone the source code'){
            steps {
                echo 'cloning'
                git url: 'https://github.com/rosaiser-36/notesapplication.git' , branch: 'main'
                            
            }
        }
         stage('Building the images') {
            steps {
                echo 'Building docker image'
                sh 'docker build -t jenkinsappimage .'
            }
        }
        stage('pushing the image to docker hub') {
            steps {
                echo 'Authenticating Docker hub'
                withCredentials([usernamePassword(credentialsId: 'DockerHub', passwordVariable: 'dockerHubpass', usernameVariable: 'dockerHubuser')]) {
                    sh "docker tag jenkinsappimage ${env.dockerHubuser}/jenkinsappimage:latest"
                    sh "docker login -u ${env.dockerHubuser} -p ${env.dockerHubpass}" // some block
                    sh "docker push ${env.dockerHubuser}/jenkinsappimage:latest"
                }
            }
        }
        
        stage('Deploy') {
            steps {
                echo 'Deploying with docker compose'
                sh 'docker-compose down && docker-compose up -d'
            }
        }
    }
}

