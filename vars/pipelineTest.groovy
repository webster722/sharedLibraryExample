pipeline {
    agent any
    stages{
        stage("Hello World"){
            print "Hello World"
        }
    }
    post{
        always{
            cleanWs()
        }
    }
}