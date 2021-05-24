def scan(component) {
    sh "sonar-scanner.bat -D\"sonar.projectKey=devops\" -D\"sonar.sources=.\" -D\"sonar.host.url=http://3.239.7.29:9000\" -D\"sonar.login=df35dbed12e7ef47a2dcb204507ad23d26f6e3b5\""

}
