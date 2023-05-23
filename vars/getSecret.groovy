#!/usr/bin/env groovy

def call(String response = 'No Data') {
  echo "Request received, ${response}"
  String normalizedResponse = response.replace("\\", "/")
  echo "Normalized Request received, ${normalizedResponse}"
  def jsonSlurper = new JsonSlurper()
  def secretSafeResponse = jsonSlurper.parseText(normalizedResponse)
  echo "${secretSafeResponse.Text}"

  
}
