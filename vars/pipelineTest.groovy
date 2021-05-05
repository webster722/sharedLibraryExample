pipeline {
    agent any
    stages{
        stage("Hello World"){
            steps{
                script{
                    print "Hello World"
                }
            }
        }
    }
    post{
        always{
            cleanWs()
        }
    }
}
