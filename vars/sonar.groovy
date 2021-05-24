def scan(component) {
    sh "sonar-scanner -Dsonar.projectKey=${component} -Dsonar.sources=. -Dsonar.host.url=http://3.239.7.29:9000 -Dsonar.login=5683fc7da7c72f6d7588dcf27abd91a700c3385c"

}
