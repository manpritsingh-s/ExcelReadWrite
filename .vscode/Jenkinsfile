pipeline {
    agent any
    stages {
        stage('Clone Repo') {
            steps {
                git 'https://github.com/manpritsingh-s/ExcelReadWrite.git'
            }
        }
        stage('Build with Maven') {
            steps {
                bat 'mvn clean install'
                
            }
        }
        stage('Run Tests') {
            steps {
                bat 'mvn test'
            }
        }
    }
    post {
        success {
            echo 'Successfully Build'
        }
        failure {
            echo 'Build Failed'
        }
    }
}