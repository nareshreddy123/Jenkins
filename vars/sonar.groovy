def scan(component) {
    sh "sonar-scanner -Dsonar.projectKey=${component} -Dsonar.sources=. -Dsonar.host.url=http://3.239.7.29:9000" +
            "-Dsonar.login=a694a65206d41683c5d3f0ac83a6e518fadebd4a"

}
