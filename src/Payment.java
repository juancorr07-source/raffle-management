public class Payment {
    
    private PayState state;
    private PayMethod payMethod;
    private String reference;

    public Payment(){
        this.state = PayState.PENDING;
        this.payMethod = null;
        this.reference = null;
    }

    public Payment(PayMethod payMethod, String reference){
        this.state = PayState.PAID;
        this.payMethod = payMethod;
        this.reference = reference;
    }

    public void markPaid(PayMethod payMethod, String reference) {
        this.state = PayState.PAID;
        this.payMethod = payMethod;
        this.reference = reference;
    }

    public boolean isPaid(){
        return this.state == PayState.PAID;
    }

    public PayState getState(){
        return state;
    }

    public PayMethod getPayMethod(){
        return payMethod;
    }

    public String getReference(){
        return reference;
    }

    @Override
    public String toString(){
        if (isPaid()) {
            String details = "Pagado (" + payMethod;
            if (payMethod == PayMethod.TRANSFER && reference != null) {
                details += ", Ref: " + reference;
            }
            details += ")";
            return details;
        } else {
            return "Pago pendiente";
        }
    }
}