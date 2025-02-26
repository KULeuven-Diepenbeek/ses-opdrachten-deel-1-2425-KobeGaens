# TODO: Vul deze Makefile zodat je met `make compile` alle bestanden in de `/src` directory compiled en linked, waarbij de object files in de `/build` directory komen, en dat de uiteindelijke binary `friendshiptester.bin` in de root directory terecht komt. Zorg er ook voor dat je met `make clean` de build directory en de binary verwijdert en dat je met `make run` het programma kan uitvoeren en dat je ook hier flags aan kan meegeven.

CC = gcc
CFLAGS = -Wall -Wextra -std=c11
SRCDIR = ./src
BUILDDIR = ./build

# declareer alle .c files en gebruik de * wildcard om simpelweg alle .c bestanden te selecteren in de SRCDIR
CFILES = $(wildcard $(SRCDIR)/*.c)
# declareer de corresponderende .o files via subsititutie en renaming
OBJECTS = $(patsubst $(SRCDIR)/%.c,$(BUILDDIR)/%.o,$(CFILES))

TARGET = friendshiptester.bin

compile: $(TARGET)

$(TARGET): $(OBJECTS)
	$(CC) -o $@ $^

$(BUILDDIR)/%.o: $(SRCDIR)/%.c
	$(CC) $(CFLAGS) -c -o $@ $<

clean: 
	rm -rf $(TARGET) $(OBJECTS)

run: $(TARGET)
	./$(TARGET)