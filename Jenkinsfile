pipeline {
    agent {label ''}

    triggers {
        pollSCM('H/2 * * * *')
    }

    options {
        timestamps()
    }

    tools {
        maven "maven-3.6.0"
    }
    stages {
        stage('static-analysis') {

            environment {scannerHome = tool 'sonarqube-scanner'}

            when {branch 'master'}

            steps {
                sh 'mvn clean compile'

                withSonarQubeEnv('sonarqube') {
                    sh "${scannerHome}/bin/sonar-scanner -Dproject.settings=${WORKSPACE}/sonar-project.properties"
                }

                timeout(time: 10, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
    }
}