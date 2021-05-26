def scan(component) {
    sh "sonar-scanner -Dsonar.projectKey=${component} Dsonar.sources=. -Dsonar.host.url=http://3.236.21.181:9000 -Dsonar.login=298e4100451f7c46ec8393a40388271883b3e455"

}
