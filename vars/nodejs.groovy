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
