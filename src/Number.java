class Number {
    private int value;

    public Number(int value) {
        this.value = value;
    }

    public int getVAlue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%02d", value);
    }
}
