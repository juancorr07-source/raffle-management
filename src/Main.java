public class Main {
    public static void main(String[] args) {
        Raffle raffle = new Raffle();

        // Personas
        Person seller1 = new Person("Carlos");
        Person seller2 = new Person("Ana");
        Person buyer1 = new Person("Juan");
        Person buyer2 = new Person("María");

        System.out.println("=== REGISTRO DE VENTAS ===");
        // Venta 1: Pagada con efectivo
        Payment p1 = new Payment(PayMethod.CASH, null);
        boolean v1 = raffle.registerSell(5, buyer1, seller1, p1);
        System.out.println("Venta del número 05: " + (v1 ? "Exitosa" : "Fallida"));

        // Venta 2: Pendiente de pago
        Payment p2 = new Payment(); // Por defecto PENDING
        boolean v2 = raffle.registerSell(12, buyer2, seller1, p2);
        System.out.println("Venta del número 12: " + (v2 ? "Exitosa" : "Fallida"));

        // Intentar vender un número ocupado
        boolean v3 = raffle.registerSell(5, buyer2, seller2, new Payment());
        System.out.println("Reintento de venta del número 05: " + (v3 ? "Exitosa" : "Fallida (Número ocupado)"));

        System.out.println("\n=== CONSULTA DE INFORMACIÓN ===");
        System.out.println(raffle.consultNumber(5));
        System.out.println(raffle.consultNumber(12));

        System.out.println("\n=== REGISTRO DE PAGO PENDIENTE ===");
        System.out.println("Compradores pendientes antes del pago:");
        for (Person p : raffle.pendingBuyers()) {
            System.out.println("- " + p.getName());
        }

        // Pagar el número 12 con transferencia bancaria
        raffle.registerPayment(12, PayMethod.TRANSFER, "TRX-98765");
        System.out.println("Pago registrado para el número 12.");

        System.out.println("Compradores pendientes después del pago: " + raffle.pendingBuyers().length);

        System.out.println("\n=== MÉTRICAS Y ESTADÍSTICAS ===");
        System.out.println("Total de números vendidos: " + raffle.selledNumbers());
        System.out.println("Ventas realizadas por " + seller1.getName() + ": " + raffle.salesBySeller(seller1));
        System.out.println("Ventas realizadas por " + seller2.getName() + ": " + raffle.salesBySeller(seller2));
        System.out.println("Cantidad de números disponibles: " + raffle.availableNumbers().length);
    }
}