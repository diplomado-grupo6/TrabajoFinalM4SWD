pipeline {
    agent any
    stages{
        stage('DescargarProyecto'){
            steps{
                script{
                      figlet 'Descargar Proyecto'
                      git clone https://github.com/diplomado-grupo6/ms-iclab.git
                      
                    
                }
            }
        }
         stage('PruebasJUnit'){
            steps{
                script{
                    figlet 'Pruebas JUnit'
                    sh 'mvn -Dtest=UtilTest test'
                        
                    
                }
            }
        }
        stage('PruebasPostmanNewman'){
            steps{
                script{
                    figlet 'Pruebas Postman Newman'
                        //sh 'mvn test'
                    
                }
            }
        }
        stage('PruebasSelenium'){
            steps{
                script{
                    figlet 'Pruebas Selenium'
                    sh 'mvn -Dtest=AppTest test'
                    
                }
            }
        }
        
        
    }
}
