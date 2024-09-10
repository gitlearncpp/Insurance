pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', credentialsId: 'GitHub-API-Token', url: 'https://github.com/gitlearncpp/Insurance.git'
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
                // Skopiowanie pliku JAR na serwer VPS
                sh '''
                    scp -i /path/to/private/key \
                    target/insurance.jar user@57.129.16.48:/path/to/deployment/directory/
                '''
            }
        }

        stage('Run on VPS') {
            steps {
                // Uruchomienie aplikacji na serwerze VPS
                sh '''
                    ssh -i /path/to/private/key user@57.129.16.48 \
                    'nohup java -jar /path/to/deployment/directory/insurance.jar > /dev/null 2>&1 &'
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
