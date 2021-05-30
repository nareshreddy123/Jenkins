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

                    withMaven(maven: 'maven') {

                        stage('Checkout') {
                            git url: 'https://github.com/nareshreddy123/devopsnaresh.git', credentialsId: 'nareshreddy123', branch: 'master'
                        }

                        stage('Build') {

                            dir('project-dir') {
                                sh 'mvn clean install'

                                def pom = readMavenPom file: 'pom.xml'

                                print pom.version
                                env.version = pom.version
                                sh 'mvn compile'
                            }

                        }


                        stage('Build Code') {
                            steps {
                                sh 'mvn package'
                            }
                        }

                    }

                }
            }
        }
    }
}