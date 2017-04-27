package cz.vondr.workshop.design.life.cmd

class CmdLineRunner {

    private BufferedReader input

    CmdLineRunner(InputStream input = System.in) {
        this.input = input.newReader()
    }

    private void start() {

    }

    public static void main(String[] args) {
        CmdLineRunner app = new CmdLineRunner();
        app.start();
    }
}
