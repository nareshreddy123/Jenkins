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

        stage('Build Code') {
               steps {
                   dir('shipping') {
                       sh ' mvn package spring-boot:repackage '
                   }
    }
}

}

}
}
stage('Sonar Scan') {
    steps {
        script {
            sonar.scan(component)
        }
    }
}


