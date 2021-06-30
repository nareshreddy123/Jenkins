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

                       sh 'ls -l'
                       sh ' mvn package spring-boot:repackage '
                   }
    }
}

}

}
}

