package ua.training.Decorator;

public class Decorator {
    public static void main(String[] args) {

        IPrinter printer = new PrinterDecoratorLeft(new PrinterDecoratorRight(new Printer("Hello")));
        IPrinter printerD = new PrinterDecoratorQuote(printer);
        printerD.print();
    }
}

interface IPrinter{
    void print();
}

class Printer implements IPrinter{
    String value;
    public Printer(String value) {
        this.value = value;
    }
    public void print() {
        System.out.print(value);
    }
}

abstract class PrinterDecorator implements IPrinter{
    IPrinter printer;
    public PrinterDecorator(){}
    public PrinterDecorator(IPrinter printer) {
        this.printer = printer;
    }
    public void print(){
        printer.print();
    }
}


class PrinterDecoratorQuote extends PrinterDecorator{
    public PrinterDecoratorQuote(IPrinter printer) {
        super(printer);
    }
    public void print() {
        System.out.print("\"");
        super.print();
        System.out.print("\"");
    }
}

class PrinterDecoratorLeft extends PrinterDecorator{
    public PrinterDecoratorLeft(IPrinter printer) {
        super(printer);
    }

    public void print() {
        System.out.print("(");
        super.print();
    }
}

class PrinterDecoratorRight extends PrinterDecorator{
    public PrinterDecoratorRight(IPrinter printer) {
        super(printer);
    }

    public void print() {
        super.print();
        System.out.print(")");
    }
}