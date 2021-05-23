def scan(component) {
    sh "sonar-scanner -Dsonar.projectKey=${component} -Dsonar.sources=.-Dsonar.host.url=http://54.160.224.206:9000" +
            " -Dsonar.login=419c5f909ac0c5d9a6eb142eca1e48403b2e6676"
}
