pipeline {
    agent any
    
    environment {
        // You can define environment variables here if needed
        MAVEN_HOME = '/usr/local/bin/maven'
    }
    
    tools {
        // Define the Maven tool to be used for the build
        maven 'Maven 3'
    }
    
    stages {
        stage('Checkout') {
            steps {
                // Checkout the latest code from the repository
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                // Use Maven to clean and build the project
                sh 'mvn clean install'
            }
        }
        
        stage('Test') {
            steps {
                // Run the tests with Maven
                sh 'mvn test'
            }
        }
        
        stage('SonarQube Analysis') {
            steps {
                // Run SonarQube analysis
                sh 'mvn sonar:sonar'
            }
        }
        
        stage('Generate Reports') {
            steps {
                // Generate and store the test report
                sh 'mvn surefire-report:report'
            }
        }
    }
    
    post {
        always {
            // Clean up or perform other tasks (e.g., archiving build artifacts)
        }
        
        success {
            // Actions on successful build (e.g., notifying stakeholders)
        }
        
        failure {
            // Actions on failed build (e.g., sending failure notifications)
        }
    }
}
