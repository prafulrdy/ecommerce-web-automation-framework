pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps { checkout scm }
        }
        stage('Test') {
            steps { sh 'mvn clean test -Dheadless=true' }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: 'target/screenshots/**/*.png', allowEmptyArchive: true
            junit 'target/surefire-reports/*.xml'
        }
    }
}
