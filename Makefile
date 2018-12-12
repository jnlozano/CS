# Thanks to https://www.cs.swarthmore.edu/~newhall/unixhelp/javamakefiles.html
# Adapted by Hans Yuan for PSA 8 - multithreading and data structures

# Variables
JFLAGS = -g -cp ./turtleClasses.jar:.
JC = javac
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java

# I define what files I want to compile
PART1A = EncryptionTurtle.java DrawingTurtle.java
PART1B = EncryptionTurtleMT.java DrawingTurtle.java
PART2 = CharacterNode.java MyStringBuilder.java

# The first rule is the default rule. In this case, I made the default rule an error.
default: error

all: part1a part1b part2

part1a: $(PART1A:.java=.class)
	java -cp ./turtleClasses.jar:. EncryptionTurtle

part1b: $(PART1B:.java=.class)
	java -cp ./turtleClasses.jar:. EncryptionTurtleMT

part2: $(PART2:.java=.class)

# If you want to remove all class files, type `make clean`.
clean:
	rm *.class

# This rule is reached if and only if the default rule was chosen.
error:
	echo ''
	echo '         Please read the directions on the writeup.            '


# End makefile
