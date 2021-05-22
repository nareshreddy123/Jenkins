def call(String component) {
    pipeline {
        agent {
            node {
                label 'workstation'
            }
        }

        stages {

            stage('Compile Code') {
                steps {
                    sh 'mvn compile'
                }

            }


        }

    }
}