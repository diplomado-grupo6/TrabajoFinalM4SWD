pipeline {
    agent any
    stages{
        stage('DescargarProyecto'){
            steps{
                script{
                      figlet 'Descargar Proyecto'
                    sh """	pwd
	                    	ls -ltr
	                    	rm -rf *
	                    	ls -ltr"""
                     sh 'git clone https://github.com/diplomado-grupo6/TrabajoFinalM4SWD.git'
                      
                    
                }
            }
        }
         stage('PruebasJUnit'){
            steps{
                script{
                    	figlet 'Pruebas JUnit'
                    	sh """	pwd
	                    	cd TrabajoFinalM4SWD
	                    	mvn -Dtest=UtilTest test"""
			    }
            }
        }
        stage('PruebasPostmanNewman'){
            steps{
                script{
                    figlet 'Pruebas Postman Newman'
                    
                    
                }
            }
        }
        stage('PruebasSelenium'){
            steps{
                script{
                    	figlet 'Pruebas Selenium'
			        sh """	pwd
	                    	cd TrabajoFinalM4SWD
	                    	mvn -Dtest=AppTest test"""
                    
                    
                }
            }
        }
        
        
    }
}
