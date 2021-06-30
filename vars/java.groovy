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
                   sh 'cd shipping'
                   sh 'ls -l'
                 sh 'cd shipping | mvn package spring-boot:repackage '
    }
}

}

}
}

