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
            stage('Sonar Scan') {
                steps {
                    script {
                        sonar.scan(component)
                    }
                }
            }
            stage('move to specific folder') {
                steps {
                    sh 'cd shipping'
                }
            }
        stage('Build Code') {
               steps {
                 sh 'mvn package spring-boot:repackage '
    }
}

}

}
}

