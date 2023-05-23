#!/usr/bin/env groovy

import groovy.json.JsonSlurper
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

def call(String id = 'No Data') {
  echo "Request received, ${id}"
  String normalizedResponse = response.replace("\\", "/")
  echo "Normalized Request received, ${normalizedResponse}"
  def jsonSlurper = new JsonSlurper()
  def secretSafeResponse = jsonSlurper.parseText(normalizedResponse)
  echo "${secretSafeResponse.Text}"
  
  def response
  response = sh(
      script: 'curl --insecure -X GET https://hjwc4zbudb.execute-api.us-east-1.amazonaws.com/Prod/hello',
      returnStdout: true
  )
  echo "${response}"
}
