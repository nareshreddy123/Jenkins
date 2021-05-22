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
        }
    }


}
          stage('Sonar Scan') {
              steps {
                  sh "sonar-scanner -Dsonar.projectKey=${component} -Dsonar.sources=.-Dsonar.host.url=http://172.31.73.89:9000 -Dsonar.login=aebe06f7e87214c54e1edbe1391548a131e3d467"
        }
       }
