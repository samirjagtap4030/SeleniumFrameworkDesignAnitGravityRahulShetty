pipeline {
    agent any

    tools {
        // Make sure 'Maven 3.8.7' (or similar) is configured in Jenkins Global Tool Configuration
        maven 'Maven 3.8.7' 
        jdk 'Java 17'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Generate Data') {
            steps {
                // Ensure helper works on Linux/Windows - creating platform independent path
                sh 'mvn test-compile exec:java -Dexec.mainClass="rahulshettyacademy.data.DataGenerator" -Dexec.classpathScope="test"'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }

    post {
        always {
            // Archive the Extent Report
            archiveArtifacts artifacts: 'reports/index.html', fingerprint: true
            junit 'target/surefire-reports/*.xml'
        }
    }
}
