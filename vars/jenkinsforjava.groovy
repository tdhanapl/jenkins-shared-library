def call(String repoUrl) {
  pipeline {
       agent any
       tools {
           maven 'maven123'
           //jdk 'jdk8'
       }
       stages {
           stage("Tools initialization") {
               steps {
                   sh "mvn --version"
                   sh "java -version"
               }
           }
           stage("Checkout Code") {
               steps {
                   git branch: 'master',  // branch name source code
                       url: "${repoUrl}" 
                 // git url given has varible here and this git url given in jenkinsfile at the palce varibleof https://github.com/dhanapal703278/tomcat_maven_app.git
                 //@Library('first-shared-lib') _
                 //jenkinsforjava repoUrl(varible_name) 
                 //jenkinsforjava 'https://github.com/dhanapal703278/tomcat_maven_app.git'
               }
           }
           /*stage("Cleaning workspace") {
               steps {
                   sh "mvn clean"
               }
           }*/
           stage("Running Testcase") {
              steps {
                   sh "mvn test"
               }
           }
           stage("Packing Application") {
               steps {
                   sh "mvn package -DskipTests"
               }
           }
       }
   }
}
