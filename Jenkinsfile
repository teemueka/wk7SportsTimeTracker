pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS_ID = 'docker_credentials'
        DOCKERHUB_REPO = 'teemukallio/wk7sportstimetracker'
        DOCKER_IMAGE_TAG = 'latest'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/teemueka/wk7SportsTimeTracker.git'
            }
        }
        stage('Run Tests') {
            steps {
                bat 'mvn clean test'
            }
        }
        stage('Code Coverage') {
            steps {
                bat 'mvn jacoco:report'
            }
        }
        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }
        stage('Publish Coverage Report') {
            steps {
                jacoco()
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${env.DOCKERHUB_REPO}:${env.DOCKER_IMAGE_TAG}")
                }
            }
        }
        stage('Push Docker Image to Docker Hub') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: "${DOCKERHUB_CREDENTIALS_ID}",
                                                     usernameVariable: 'DOCKER_USER',
                                                     passwordVariable: 'DOCKER_PASS')]) {
                        bat """
                            docker login -u %DOCKER_USER% -p %DOCKER_PASS%
                            docker push %DOCKERHUB_REPO%:%DOCKER_IMAGE_TAG%
                            docker logout
                        """
                    }
                }
            }
        }
    }
}
