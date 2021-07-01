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
      steps {

         script {
             sonar.report(component)
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
        sh "curl -f -v -u admin:admin123 --upload-file ${component}-${TAG}.zip http://172.31.66.153:8081/repository/${component}/${component}-${TAG}.zip"
    }
}
