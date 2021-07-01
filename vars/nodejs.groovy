def call(String component) {
    pipeline {
        agent any

        stages {
            stage('download dependencies')
                    {
                        steps
                                {
                                    sh 'npm install'
                                }
                    }

            stage('Prepare Artifacts') {

                steps {
                    sh """
                      zip -r ${component}-${TAG}.zip node_modules server.js
                   """
                }
            }

            stage('Upload Nexus Artifacts') {

                steps {
                    sh "curl -f -v -u admin:admin123 --upload-file ${component}-${TAG}.zip http://3.85.224.77:8081/repository/cart/${component}.zip"
                }
            }


            stage('Sonar Scan') {
                steps {
                    script {
                        sonar.scan(component)
                    }
                }
            }
        }
    }
}
             stage('Sonar Quality Gate Status') {
                 steps {script {
                     sonar.report(component)

                 }

                 }

             }
