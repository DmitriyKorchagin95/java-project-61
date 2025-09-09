# Makefile
run-dist: # run app
	./app/build/install/app/bin/app

build-dist: # build app
	./app/gradlew installDist

clean-dist: # clean builded app
	./app/gradlew clean