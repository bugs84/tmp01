package cz.vondr.workshop.design.tree

trait SystemOutputTest {
    ByteArrayOutputStream testOutput
    PrintStream originalOutput

    def setup() {
        testOutput = new ByteArrayOutputStream()
        originalOutput = System.out
        System.out = new PrintStream(testOutput)
    }

    def cleanup() {
        System.out = originalOutput
    }

    String getSystemOutput() {
        testOutput.toString()
    }

    List<String> getSystemOutputLines() {
        testOutput.toString().readLines()
    }
}