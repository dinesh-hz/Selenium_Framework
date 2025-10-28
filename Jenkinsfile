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


        stage('Publish Reports') {   // 👇 Cucumber JVM Report
            steps {
                publishHTML(target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/cucumber-html-reports',
                    reportFiles: 'overview-features.html',
                    reportName: 'Cucumber JVM Report'
                ])
            }
        }


         stage('Publish Extent Report') {       // 👇 Added this new stage Extent Report
                    steps {
                        publishHTML(target: [
                            allowMissing: false,
                            alwaysLinkToLastBuild: true,
                            keepAll: true,  // to keep past old Report
                            reportDir: 'target/extent-reports',
                            reportFiles: 'extent.html',
                            reportName: 'Extent HTML Report'
                        ])
                    }
                }

        /*   stage('Publish Reports') {   // 👇 Added this new stage cucumber HTML Report
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
        }*/
    }
}
