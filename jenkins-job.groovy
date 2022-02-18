job('NodeJS example') {
    scm {
        git('https://github.com/nsane4stargate/job-dsl.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('lea middleton')
            node / gitConfigEmail('lea.middleton6347@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('node') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        shell("npm install")
    }
}
