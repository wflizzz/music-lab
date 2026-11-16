pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                bat 'mvn -o -Dmaven.repo.local=C:/ProgramData/Jenkins/.jenkins/.m2/repository compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn -o -Dmaven.repo.local=C:/ProgramData/Jenkins/.jenkins/.m2/repository test'
            }
        }

        stage('Validate') {
            steps {
                bat 'mvn -o -Dmaven.repo.local=C:/ProgramData/Jenkins/.jenkins/.m2/repository validate'
            }
        }

        stage('Package') {
            steps {
                bat 'mvn -o -Dmaven.repo.local=C:/ProgramData/Jenkins/.jenkins/.m2/repository package -DskipTests'
            }
        }
    }
}
