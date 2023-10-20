/*
* # Super seed job ----------------------------------------------
* # In here we are trying to create one super seed job witch will
* # gets our jobs from other repository so we can seprate the jobs
* # from this repository and put them somewhere else to keep the
* # code and files more clean.
* # After that you can setup one webhook then update the jobs on any change
* # On your code base.
* #
*/

job('super-seed') {
  triggers {
    // This trigger will be overwritten, it's just here to auto-trigger _one_ build.
    cron('H/2 * * * *')
  }
  scm {
    git {
      remote {
        url('repository_ssh_address') // Put your repository SSH address here
        credentials('jenkins-github-ssh') // It's comming from jcasc configuration
      }
    }
  }
  steps {
    dsl {
      external('jenkins/jobs/**/*.groovy')
      removeAction('DELETE')
    }
  }
}
