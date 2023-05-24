package org.bpd

//Configurando variables
//Base: sitio de beyondtrust
BASE = ""
//runas: el nombre de usuario de un usuario de BeyondInsight al que se le ha concedido permiso para usar la clave de API.
RUN_AS=""
//Authorization=PS-Auth key=c479a66f…c9484d; runas=doe-main\johndoe; pwd=[un1qu3];
//key: la clave de API configurada en BeyondInsight para su aplicación
PS_AUTH_KEY=""
//Id del secret
SECRET_ID=""
//Nombre del archivo cookie que se creara en <filename> después de operar
PBPS_COOKIE_FILE= "pbpscookie.txt"

class PasswordSafeHelper implements Serializable {



    def steps
    PasswordSafeHelper(steps) {this.steps = steps}

    def GetSecretSafeToken(String secretid){
        steps.sh "curl --insecure -X GET https://kyw3pc5rm8.execute-api.us-east-1.amazonaws.com/dev/resource"
    }
    def GetSecretSafeToken(String secretid){
        
        //Autenticarse
        // POST
        def post = new URL("${BASE}/Auth/SignAppin").openConnection();
        def message = ' '
        post.setRequestMethod("POST")
        post.setDoOutput(true)
        post.setRequestProperty("Content-Type", "application/json")
        post.setRequestProperty("Authorization", "PS-Auth key=${PS_AUTH_KEY}; runas=${RUN_AS};")
        post.getOutputStream().write(message.getBytes("UTF-8"));
        def postRC = post.getResponseCode();
        println(postRC);
        if (postRC.equals(200)) {
            println(post.getInputStream().getText());
            // Obtener valor
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
        else {
            throw new Error("error al procesar la autenticacion con password safe ${postRC}")
        }
        
        
    }
}
