def scan(component) {
//    sh 'sonar-scanner -Dsonar' '.projectKey=${component}' 'Dsonar.sources=.' '-Dsonar.host.url=http://3.236.21.181:9000 -Dsonar.login=298e4100451f7c46ec8393a40388271883b3e455'
sh "sonar-scanner " +
        "  -Dsonar.projectKey=${component} " +
        "  -Dsonar.sources=. " +
        "  -Dsonar.host.url=http://3.236.21.181:9000 " +
        "  -Dsonar.login=8ad6674d77f1f9e3c4be53daa4705d321a9d0b0c"
}
