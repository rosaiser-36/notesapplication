pipeline {
    agent any

    stages {

        stage('clone and build'){
            steps {
                echo 'cloning'
                git url: 'https://github.com/rosaiser-36/notesapplication.git' , branch: 'main'
                sh 'docker build -t jenkinsappimage .'             
            }
     
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}