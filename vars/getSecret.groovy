#!/usr/bin/env groovy

import groovy.json.JsonSlurper
@Grab('com.github.groovy-wslite:groovy-wslite:1.1.2')
import wslite.http.auth.*
import wslite.rest.*

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

def client = new RESTClient("https://kyw3pc5rm8.execute-api.us-east-1.amazonaws.com/dev/resource")
client.authorization = new HTTPBasicAuthorization("user", "pass")
def response = client.get(path: "/",headers: ['Content-Type': 'application/json']) {
    json description: "string", mode: "DEFAULT", name: "string", start_time: "2015-11-05T13:26:40.626Z", tags: [ "string" ] 
}
echo(response)
def call(String id = 'No Data') {
  echo "Request received, ${id}"
  String normalizedResponse = id.replace("\\", "/")
  echo "Normalized Request received, ${normalizedResponse}"
  def jsonSlurper = new JsonSlurper()
  def secretSafeResponse = jsonSlurper.parseText(normalizedResponse)
  echo "${secretSafeResponse.Text}"
  
 
  
}
