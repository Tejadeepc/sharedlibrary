def call(Map config) {
    pipeline {
    agent any
    tools {
        maven "${config.maven}"
    }
    stages {
        stage('git') {
         steps {
           git url: "${config.gitUrl}",
           branch:  "${config.gitBranch}"
    }
        }
        stage('build') {
            steps {
                sh "mvn ${config.goals}"
            }
        }


}
}