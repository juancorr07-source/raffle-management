public class Sale {
    
    private Number number;
    private Person buyer;
    private Person seller;
    private Payment payment;

    public Sale(Number number, Person buyer, Person seller, Payment payment){
        this.number = number;
        this.buyer = buyer;
        this.seller = seller;
        this.payment = payment;
    }

    public void registerPayment(PayMethod payMethod, String reference){
        if (this.payment == null) {
            this.payment = new Payment();
        }
        this.payment.markPaid(payMethod, reference);
    }

    public boolean isPaid(){
        return this.payment != null && this.payment.isPaid();
    }

    // Getters y Setters
    public Number getNumber() {
        return number;
    }

    public Person getBuyer() {
        return buyer;
    }

    public Person getSeller() {
        return seller;
    }

    public Payment getPayment() {
        return payment;
    }

    @Override
    public String toString() {
        return "Venta [Número: " + number + 
               ", Comprador: " + buyer.getName() + 
               ", Vendedor: " + seller.getName() + 
               ", Estado Pago: " + payment + "]";
    }
}

