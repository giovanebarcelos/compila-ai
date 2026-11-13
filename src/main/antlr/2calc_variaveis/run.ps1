antlr4 -visitor -o build/gen Vars.g4
javac -encoding UTF-8 -d build/classes ../../lib/*.java build/gen/*.java *.java
cd build/classes
java MainVars --ast ../../ok_1.txt
echo "Sem AST"
java MainVars ../../ok_1.txt
grun Vars programa -tokens ../../ok_1.txt
grun Vars programa -tree ../../ok_1.txt
grun Vars programa -gui ../../ok_1.txt
