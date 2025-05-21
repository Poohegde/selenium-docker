pipeline{

    agent any

    stages{

        stage('Build Jar')
        {
            steps{
             bat "mvn clean package -DskipTests"
            }

        }

        stage('Build Image')
        {
            steps{
             bat "docker build -t=poohegde/selenium:latest ."

            }

        }

         stage('Push Image')
        {
          environment{
          DOCKER_HUB = credentials('dockerhub-creds')
          }
             steps{
             //there might be warning
              bat 'docker login -u %DOCKER_HUB_USR% -p %DOCKER_HUB_PSW%'
              bat 'docker push poohegde/selenium:latest'
              bat "docker tag poohegde/selenium:latest poohegde/selenium:${env.BUILD_NUMBER}"
              bat "docker push poohegde/selenium:${env.BUILD_NUMBER}"
             }

        }
    }

    post
    {
    always
    {
      bat "docker logout"
    }

    }


}