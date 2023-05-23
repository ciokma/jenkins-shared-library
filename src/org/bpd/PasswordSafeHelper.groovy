package org.bpd

class PasswordSafeHelper implements Serializable {
    def steps
    PasswordSafeHelper(steps) {this.steps = steps}

    def GetSecretSafeToken(String id){
        steps.sh "curl --insecure -X GET https://kyw3pc5rm8.execute-api.us-east-1.amazonaws.com/dev/resource"
    }

}