pipeline {
    agent any
    tools {
        jdk 'JAVA_HOME'
        maven 'Maven  3.10'
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


        stage('Publish Cucumber Report') {
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

        stage('Publish Extent Report') {
            steps {
                publishHTML(target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: '/HTML_Report',   // or target/extent-report (check actual folder)
                    reportFiles: 'Spark.html',          // or extent.html if that’s your file
                    reportName: 'Extent HTML Report'
                ])
            }
        }

    }
}
