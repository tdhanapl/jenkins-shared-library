def call(String repoUrl) {
    pipeline {
        agent none
        environment {
            DOCKER_LOGIN = credentials('docker_login')
            
        }
        tools {
        maven 'maven123'
            
        }
        options {
        timestamps()()
        timeout(activity: true, time: 20)
            
        }
        stages {
            stage ('Checkout and Build') {
                agent {
                    docker {
                        image 'dhanapal406/jenkins_java_git_maven-3.8.5'
                        label 'docker-node'
                    }
                }
                steps{
                    git branch: 'master',  // branch name source code
                        url: "${repoUrl}" 
                 // git url given has varible here and this git url given in jenkinsfile at the palce varibleof https://github.com/dhanapal703278/tomcat_maven_app.git
                 //@Library('first-shared-lib') _
                 //jenkinsforjava repoUrl(varible_name) 
                 //jenkinsForJava 'https://github.com/dhanapal703278/tomcat_maven_app.git'
                    sh "mvn clean package"
                }
            }
            /*stage('Create  a images'){
                agent {
                    label 'docker-node'
                    
                }
                steps {
                    sh """
                         docker build -t dhanapal406/tomcat_sai-$BUILD_NUMBER .
                         docker login -u $DOCKER_LOGIN_USR -p $DOCKER_LOGIN_PSW
                         docker push dhanapal406/tomcat_sai-$BUILD_NUMBER
                         docker run -itd -p 8080:8080 dhanapal406/tomcat_sai-$BUILD_NUMBER
                    """
                }*/
        }
    }
}
