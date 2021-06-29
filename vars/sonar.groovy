def scan(component) {
//    sh 'sonar-scanner -Dsonar' '.projectKey=${component}' 'Dsonar.sources=.' '-Dsonar.host.url=http://3.236.21.181:9000 -Dsonar.login=298e4100451f7c46ec8393a40388271883b3e455'
sh "sonar-scanner -Dsonar.projectKey={component} -Dsonar.sources=. -Dsonar.host.url=http://3.214.215.107:9000 -Dsonar.login=9eaadaf0b840df743f2715fe9a7aee549b19ba95"
}



def report(component) {
    sh "sonar-quality-gate.sh admin admin123 3.214.215.107 ${component}"
}
