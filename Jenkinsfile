pipeline {
    agent any

    tools {
        maven 'my-maven'
    }
    
    environment {
        DOCKERHUB_CREDENTIALS = 'dockerhub'
    }

    stages {
        stage('Build with Maven') {
            steps {
                sh 'mvn --version'
                sh 'java -version'
                sh 'mvn clean package -Dmaven.test.failure.ignore=true'
            }
        }

        stage('Packaging/Pushing image') {
            steps {
                script {
                    def imageName = "thanhtungeric/service-book-review-jenkins"
                    def imageTag = "latest"

                    withDockerRegistry(credentialsId: DOCKERHUB_CREDENTIALS, url: 'https://index.docker.io/v1/') {
                        sh "docker build -t ${imageName}:${imageTag} ."
                        sh "docker push ${imageName}:${imageTag}"
                    }
                }
            }
        }

        stage('Deploy with Docker Compose') {
            steps {
                script {
                    sh 'docker-compose down -v || echo "No containers to stop"'
                    sh 'docker-compose pull'
                    sh 'docker-compose up -d'
                }
            }
        }
    }

    post {
        // Clean after build
        always {
            cleanWs()
        }
    }
}
