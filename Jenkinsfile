pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package' // Adjust this for your build system
            }
        }
        stage('Approval') {
            steps {
                input message: 'Do you want to deploy?', ok: 'Deploy'
            }
        }
        stage('Deploy') {
            steps {
                sh './deploy.sh' // Replace with your deployment script
            }
        }
    }
}
