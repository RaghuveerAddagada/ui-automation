pipeline {
    agent any

    options {
        timeout(time: 10, unit: 'MINUTES')
    }

    tools {
        maven '3.8.5'
    }

    stages {

        stage('Execution Time') {
            steps {
                sh "mvn clean test -DsuiteXmlFile=testNGsuite/praveen.xml"
            }

            //post {
            //    success {
            //        archiveArtifacts artifacts: '*test-output/.html', followSymlinks: false
            //    }
            //    always {
            //        step([$class: 'Publisher', reportFilenamePattern: '**test-output/testng-results.xml'])
            //    }
            //}
        }
    }
}