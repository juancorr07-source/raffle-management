class Number {
    private int value;

    public Number(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%02d", value); // %02d es para que cualquier número entero dado tenga al menos dos dígitos añadiendo ceros a la izquierda si es necesario
    }
}
