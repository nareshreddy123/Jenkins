def scan(component) {
    sh "sonar-scanner -Dsonar.projectKey=${component} -Dsonar.sources=.-Dsonar.host.url=http://172.31.73.89:9000 -Dsonar.login=aebe06f7e87214c54e1edbe1391548a131e3d467"
}
