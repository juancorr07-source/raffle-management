public class Raffle {
    private Number[] numbers;
    private Sale[] sales;
    private int saleCount; // Contador para controlar las ventas registradas en el arreglo

    public Raffle() {
        // Inicializamos el arreglo con exactamente 100 números (00 al 99)
        this.numbers = new Number[100];
        for (int i = 0; i < 100; i++) {
            this.numbers[i] = new Number(i);
        }
        
        // Cada rifa admite como máximo 100 ventas
        this.sales = new Sale[100];
        this.saleCount = 0;
    }

    // Registrar la venta de un número
    public boolean registerSell(int numberValue, Person buyer, Person seller, Payment payment) {
        if (numberValue < 0 || numberValue > 99) {
            return false; // Número fuera de rango
        }

        // Impedir la venta si el número ya fue vendido
        if (consultNumber(numberValue) != null) {
            return false;
        }

        Number numberToSell = numbers[numberValue];
        Sale newSale = new Sale(numberToSell, buyer, seller, payment);
        sales[saleCount] = newSale;
        saleCount++;
        return true;
    }

    // Registrar el pago de una venta pendiente por número de rifa
    public boolean registerPayment(int numberValue, PayMethod payMethod, String reference) {
        Sale sale = consultNumber(numberValue);
        if (sale != null && !sale.isPaid()) {
            sale.registerPayment(payMethod, reference);
            return true;
        }
        return false;
    }

    // Consultar la información asociada a un número vendido
    public Sale consultNumber(int numberValue) {
        for (int i = 0; i < saleCount; i++) {
            if (sales[i].getNumber().getValue() == numberValue) {
                return sales[i];
            }
        }
        return null;
    }

    // Obtener compradores con pagos pendientes (Retorna un arreglo de Person)
    public Person[] pendingBuyers() {
        int count = 0;
        for (int i = 0; i < saleCount; i++) {
            if (!sales[i].isPaid()) {
                count++;
            }
        }

        Person[] pending = new Person[count];
        int index = 0;
        for (int i = 0; i < saleCount; i++) {
            if (!sales[i].isPaid()) {
                pending[index++] = sales[i].getBuyer();
            }
        }
        return pending;
    }

    // Calcular la cantidad total de números vendidos
    public int selledNumbers() {
        return saleCount;
    }

    // Obtener la lista de números disponibles (Retorna un arreglo de Number)
    public Number[] availableNumbers() {
        int availableCount = 100 - saleCount;
        Number[] available = new Number[availableCount];
        int index = 0;

        for (int i = 0; i < 100; i++) {
            if (consultNumber(i) == null) {
                available[index++] = numbers[i];
            }
        }
        return available;
    }

    // Calcular cuántos números ha vendido un vendedor específico
    public int salesBySeller(Person seller) {
        int count = 0;
        for (int i = 0; i < saleCount; i++) {
            if (sales[i].getSeller().getName().equalsIgnoreCase(seller.getName())) {
                count++;
            }
        }
        return count;
    }
}