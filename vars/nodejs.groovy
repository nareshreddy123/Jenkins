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
                sh "sonar-scanner -Dsonar.projectKey=${component} -Dsonar.sources=.-Dsonar.host.url=http://3.215.22.194:9000 -Dsonar.login=4e20f91944ab9239292fcbeeecc0cd19fbba49c7"
               }
             }