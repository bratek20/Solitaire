JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        samotnik/Samotnik.java 

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) samotnik/*.class
