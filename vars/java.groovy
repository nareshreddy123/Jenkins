def call(String component) {
    pipeline {
        agent {
            node {
                label 'work'
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