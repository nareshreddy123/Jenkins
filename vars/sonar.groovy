def scan(component) {

    sh "sonar-scanner -Dsonar.projectKey=${component} -Dsonar.sources=. -Dsonar.host.url=http://3.215.22.194:9000 -Dsonar.login=12c4bb320826055d2e834f40bd54178e97e71a47"
}