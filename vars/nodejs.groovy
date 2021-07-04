def call(String component) {
    pipeline {
        agent any

        triggers {
            pollSCM('H/2 * * * *')
        }

        parameters {
            string(name: 'TAG', defaultValue: 'NA', description: 'Tag to Release')
        }

        stages {

            stage('Download Dependencies') {
                steps {
                    sh 'npm install'
                }
            }

     stage('Sonar Scan') {
       steps {
         script {
            sonar.scan(component)
          }
        }
      }

     stage('Sonar Quality Gate Status') {
       steps {
         catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
           script {
            sonar.report(component)
           }
        }
        }
      }

            stage('Prepare Artifacts') {
                when {
                    expression {
                        env.TAG != "NA"
                    }
                }
                steps {
                    sh """
            zip -r ${component}-${TAG}.zip node_modules server.js
          """
                }
            }

            stage('Upload Nexus Artifacts') {
                when {
                    expression {
                        env.TAG != "NA"
                    }
                }
                steps {
                    sh "curl -f -v -u admin:admin --upload-file ${component}-${TAG}.zip http://3.85.224.77:8081/repository/${component}/${component}-${TAG}.zip"
                }
            }
        }
    }
}