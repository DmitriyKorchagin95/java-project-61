# Makefile
run: # run app
	./app/build/install/app/bin/app

build: # build app
	cd app  && ./gradlew build

.PHONY: build