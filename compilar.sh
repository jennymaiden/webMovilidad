#!/bin/bash
echo "Compilando movilidad"
sleep 1
mvn clean install

echo "Agregar movilidad a tomcat"
sleep 1
sudo rm -rf /opt/tomcat/apache-tomcat-8.0.53/webapps/movilidad
sudo cp -R /home/fernando/Documentos/Utilidades/movilidad/target/movilidad /opt/tomcat/apache-tomcat-8.0.53/webapps/
sudo chown -R fernando:fernando /opt/tomcat/apache-tomcat-8.0.53/webapps/movilidad

echo "Terminado"

exit
