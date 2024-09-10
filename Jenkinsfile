pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', credentialsId: 'fe79b993-b4a1-4cf7-b11b-455f789e33b2', url: 'https://github.com/gitlearncpp/Insurance.git'
            }
        }

        stage('Build') {
            steps {
                // Budowanie aplikacji za pomocą Mavena
                sh 'mvn clean install'
            }
        }

        stage('Package') {
            steps {
                // Pakowanie aplikacji
                sh 'mvn package'
            }
        }

        stage('Approval') {
            steps {
                input message: 'Czy chcesz wdrożyć na środowisko produkcyjne?', ok: 'Tak, wdrażaj'
            }
        }

      stage('Deploy to VPS') {
    steps {
        sshagent(['VPS-SSH-Credentials']) {
            sh '''
                scp target/insurance.jar fedora@57.129.16.48:/opt/insurance
            '''
        }
    }
}


        stage('Run on VPS') {
    steps {
        sshagent(['VPS-SSH-Credentials']) {
            sh '''
                ssh fedora@57.129.16.48 'nohup java -jar /opt/insurance/insurance.jar > /dev/null 2>&1 &'
            '''
        }
    }
}


    post {
        success {
            echo 'Deployment successful!'
        }
        failure {
            echo 'Deployment failed.'
        }
    }
}
