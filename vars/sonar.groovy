def scan(component) {

    sh "sonar-scanner -Dsonar.projectKey=${component} -Dsonar.sources=. -Dsonar.host.url=http://172.31.27.109:9000 -Dsonar.login=12c4bb320826055d2e834f40bd54178e97e71a47"
}