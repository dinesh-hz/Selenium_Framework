pipeline {
    agent any
    tools {
        jdk 'JDK21'
        maven 'Maven3.9'
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/dinesh-hz/runover.git'
            }
        }
        stage('Build and Test') {
            steps {
                bat 'mvn clean verify'
            }
        }
        stage('Publish Reports') {
            steps {
                publishHTML(target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/cucumber-reports',
                    reportFiles: 'report.html',
                    reportName: 'Cucumber HTML Report'
                ])
            }
        }
    }
}
