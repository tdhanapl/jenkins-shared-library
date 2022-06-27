def call(String buildStatus= 'STARTED') {
  //build status of null means successfull 
  buildStatus = buildStatus ?: 'SUCCESS'
  //default values 
  def colorName = 'RED'
  def colorCode = '#FF000'
  def subject = "${ buildStatus }: Job '${ env.JOB_nAME} [${env.BUILD_NUMBER}]'"
  def summary = "${ subject} (${env.BUILD_URL})"
  def details = """<p>${buildStatus}: Job '${env.JOB_NAME} [$ {env.BUIL_NUMBER}':</p>
  <p>Check console output at & QUOT;<a hrof=${env.BULD_URL}'>${env.JOB_NAME} [$env.BUILD_NUMBER}] </a>&QUOT</p>"""
  //override default values based on buld status
  if (buldStatus == 'STARTED') {
    color = 'YELLOW'
    colorCode = '#FF000'
  } else if (buldstatus == 'SUCCESS') {
    color = 'GREEN'
    colorCode = '#00FF00
  } else {
    color = 'RED'
    colorCode = '#FF0000'
  }
  //send notification
  //slack [color: colorcode, notify; true, message: summary)
  emailtext(
    to: 'dhanapal703278@gmail.com',
    subject: subject,
    body: details,
    recipientProviders: [[$class: 'DeveloperRecipientProvider']]
    )
}
  
  
