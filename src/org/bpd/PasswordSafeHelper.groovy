package org.bpd

class PasswordSafeHelper implements Serializable {
    def steps
    PasswordSafeHelper(steps) {this.steps = steps}

    def GetSecretSafeToken(String secretid){
        steps.sh "curl --insecure -X GET https://kyw3pc5rm8.execute-api.us-east-1.amazonaws.com/dev/resource"
    }
    def GetSecretSafeToken_2(String secretid){
        // GET
        steps.echo "GetSecretSafeToken2"
        println ("GetSecretSafeToken2, token ${secretid}")
        def get = new URL("https://kyw3pc5rm8.execute-api.us-east-1.amazonaws.com/dev/resource").openConnection();
        def getRC = get.getResponseCode();
        def result = ""
        println(getRC);
        if (getRC.equals(200)) {
            result = get.getInputStream().getText()
            println(result);
        }
        else{
            println("No hubo respuesta exitosa desde password safe, codigo de respuesta: ${getRC}")
        }
        return result
    }
}