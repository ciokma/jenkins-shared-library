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

def call(String response = 'No Data') {
  echo "Request received, ${response}"
  String normalizedResponse = response.replace("\\", "/")
  echo "Normalized Request received, ${normalizedResponse}"
  def jsonSlurper = new JsonSlurper()
  def secretSafeResponse = jsonSlurper.parseText(normalizedResponse)
  echo "${secretSafeResponse.Text}"
  echo """curl --insecure -i -c ${env.PBPS_COOKIE_FILE}  -X POST ${BASE}/Auth/SignAppin -H "Content-Type: application/json" -H "Authorization: PS-Auth key=${PS_AUTH_KEY}; runas=${RUN_AS};" -d " " """
  sh """curl --insecure -i -c ${env.PBPS_COOKIE_FILE}  -X POST ${BASE}/Auth/SignAppin -H "Content-Type: application/json" -H "Authorization: PS-Auth key=${PS_AUTH_KEY}; runas=${RUN_AS};" -d " " """
  return secretSafe
}
