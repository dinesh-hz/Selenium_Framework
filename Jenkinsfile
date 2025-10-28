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


        stage('Publish Cucumber JVM Report') {
            steps {
                publishHTML(target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,   // ✅ Keeps reports from previous builds
                    reportDir: 'target/cucumber-reports/cucumber-html-reports',  // ✅ Folder containing the report
                    reportFiles: 'overview-features.html',            // ✅ The report file itself
                    reportName: 'Cucumber JVM HTML Report' // ✅ Display name in Jenkins
                ])
            }
        }


        stage('Publish Extent Report') {
            steps {
                publishHTML(target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,   // keeps old reports for reference
                    reportDir: 'HTML_Report',   // ✅ folder where Spark.html is located
                    reportFiles: 'Spark.html',  // ✅ actual report file name
                    reportName: 'Extent Spark HTML Report'
                ])
            }
        }


    }
}
