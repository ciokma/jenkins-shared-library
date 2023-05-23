#!/usr/bin/env groovy

import groovy.json.JsonSlurper

def call(String id = 'No Data') {
  echo "Request received, ${id}"
  String normalizedResponse = id.replace("\\", "/")
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
