
def buildApp(String appName) {
    stage('Build') {
        echo "Building application: ${appName}"
        sh '''
            chmod +x app.sh
            ./app.sh build
        '''
    }
}

def testApp() {
    stage('Test') {
        echo 'Running application tests'
        sh './app.sh test'
    }
}

def showBuildInfo() {
    stage('Build Information') {
        echo "Job: ${env.JOB_NAME}"
        echo "Build number: ${env.BUILD_NUMBER}"
        echo "Build URL: ${env.BUILD_URL}"
    }
}

def notifyBuild() {
    stage('Notification') {
        echo "Build result: ${currentBuild.currentResult}"
        echo "Build notification step completed."
    }
}
