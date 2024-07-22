.PHONY: help compile test format check

help:
	@cat $(firstword $(MAKEFILE_LIST))

compile:
	sbt compile

test:
	sbt test

format:
	scalafmt

check:
	scalafmt --test
