def scan(component) {

    if (component == "shipping") {
        sh "sonar-scanner -Dsonar.projectKey=${component} -Dsonar.sources=. -Dsonar.java.binaries=./target -Dsonar.host.url=http://3.214.215.107:9000 -Dsonar.login=9eaadaf0b840df743f2715fe9a7aee549b19ba95"
    } else {
        sh "sonar-scanner -Dsonar.projectKey=${component} -Dsonar.sources=. -Dsonar.host.url=http://3.214.215.107:9000 -Dsonar.login=9eaadaf0b840df743f2715fe9a7aee549b19ba95"
    }
}

    def report(component) {
        sh "sonar-quality-gate.sh admin admin123 172.31.66.121 ${component}"
    }
