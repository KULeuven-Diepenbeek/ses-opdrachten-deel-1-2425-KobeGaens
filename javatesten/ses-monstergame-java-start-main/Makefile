MAINCLASS = App
JAR = app.jar

compile:
	@echo "compiling ..."
	javac -d ./build *.java
	@echo "Done compiling."

clean:
	@echo "cleaning ..."
	-rm -R ./build/*
	@echo "Done cleaning."

run: 
	@echo "running program $(JAR) ...\n---------------"
	@cd ./build && java -cp "$(JAR)" $(MAINCLASS)
	@echo "---------------\nProgram exited."

jar:
	@echo "Packaging to jar ..."
	cd ./build && jar cvfe $(JAR) $(MAINCLASS) *
	@echo "Done packaging."c