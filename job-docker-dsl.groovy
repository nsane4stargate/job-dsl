job('NodeJS Docker example') {
    scm {
        git('https://github.com/nsane4stargate/nodejsJenkinsci.git;) {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('nsane4stargate')
            node / gitConfigEmail('nsane4stargate@gmail.com')
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
        dockerBuildAndPublish {
            repositoryName('nsane4stargate/nodejs-jenkins-docker')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
