MAIN = app.py
TARGET = app.bin

compile:
	@echo "compiling ..."
	pyinstaller --onefile --name app.bin app.py
	@echo "Done compiling."

clean:
	@echo "cleaning ..."
	-rm -R ./build/*
	@echo "Done cleaning."

test: 
	@echo "testing program $(MAIN) ...\n---------------"
	python3 app.py
	@echo "---------------\nProgram exited."

run: 
	@echo "testing program $(MAIN) ...\n---------------"
	@cd ./dist && ./app.bin
	@echo "---------------\nProgram exited."