.PHONY: help compile test

help:
	@cat $(firstword $(MAKEFILE_LIST))

compile:
	sbt compile

test:
	sbt test
