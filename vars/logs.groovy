
def info(message) {
    echo "INFO: ${message}"
}

def warning(message) {
    echo "WARNING: ${message}"
}





def call(String component, int cNumber) {
    pipeline {
        agent none
        stages {
            stage('Example') {
                steps {
                    echo "CI for ${component}, Value - ${cNumber}"
                }
            }
        }
    }
}