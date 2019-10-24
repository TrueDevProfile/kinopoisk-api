pipeline {
    agent any
    options {
        buildDiscarder(logRotator(numToKeepStr: '10', artifactNumToKeepStr: '10'))
        timestamps()
    }
    stages {
        stage("build") {
            steps {
                 sh './gradlew build check'
            }
        }
    }
}
