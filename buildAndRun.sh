sleep 0.2 # So we log under db_1 :)
echo "Hacky build-script is starting up. We're reusing the devcontainer (as opposed to getting a proper JRE image)"
echo "This is going to take long the first time, Maven needs to install lots of dependencies"
cd workspace 
/usr/local/sdkman/candidates/maven/current/bin/mvn -T 4 package -DskipTests -nsu -ntp && echo "Done"
cd target 
echo "Running spring application"
java -jar polls-0.0.1-SNAPSHOT.jar && echo "Done"
