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
             bat "docker build -t=poohegde/selenium ."

            }

        }

         stage('stage-3')
        {
             steps{
              bat "docker push poohegde/selenium"

             }

        }
    }


}