def call(body){
   pipeline{
    agent any
    stages{
        stage('Clone'){
            steps{
                script{
                    //git credentialsId: 'GithubCreds', url: 'https://github.com/webster722/DivyaTestRepo.git'
                    withCredentials([usernamePassword(credentialsId: 'NewGitCreds', passwordVariable: 'pass', usernameVariable: 'user')]) {
                        //git url: 'https://github.com/webster722/DivyaTestRepo.git'
                        sh "git clone https://${user}:'${pass}'@github.com/webster722/DivyaTestRepo.git"
                        dir('DivyaTestRepo'){
                            sh "ls -lart"
                            content = readYaml file: "./SampleYaml.yml"
                            content.each{
                                print "${it.Source}"
                            }
                        }
                        sh "rm -rf ./*"
                        try {
                            print "this is ${NewValue}"
                        }
                        catch (exc) {
                            print 'Something failed for variable'
                        }

                        
                        
                    }
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
    
}
