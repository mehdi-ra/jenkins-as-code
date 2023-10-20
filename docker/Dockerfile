FROM jenkins/jenkins:latest

COPY ./src/plugins.txt /usr/share/jenkins/ref/plugins.txt
COPY --chown=1000:1000 ./src/casc.yaml /casc.yaml
COPY --chown=1000:1000 ./src/pipeline.groovy /pipeline.groovy

RUN ls -lha /var/jenkins_home

ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false
ENV CASC_JENKINS_CONFIG /casc.yaml

RUN jenkins-plugin-cli -f /usr/share/jenkins/ref/plugins.txt
