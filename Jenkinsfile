pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/bouthik4649-lgtm/jenkins-docker-demo.git'
            }
        }

        stage('Maven Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Unit Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    bat 'mvn verify org.sonarsource.scanner.maven:sonar-maven-plugin:sonar -Dsonar.projectKey=CloudOps-dashboard -Dsonar.projectName=CloudOps-dashboard'
                }
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t jenkins-docker-demo .'
            }
        }

        stage('Docker Run') {
            steps {
                bat 'docker stop jenkins-demo 2>NUL || exit 0'
                bat 'docker rm jenkins-demo 2>NUL || exit 0'
                bat 'docker run -d --name jenkins-demo -p 8081:8080 jenkins-docker-demo'
            }
        }
    }
}
