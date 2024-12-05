package com.pluralsight.car;

public class SalesContract extends Contract{
    private double salesTaxAmount;
    private double recordingFee;
    private  double processingFee;
    private boolean isFinancing;
    private double monthlyPayment;

    public boolean isFinancing() {
        return isFinancing;
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount ;
     }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }


    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }


    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold , boolean isFinancing) {
        super(date, customerName, customerEmail, vehicleSold);
        this.monthlyPayment = monthlyPayment;
        this.processingFee = processingFee;
        this.recordingFee = 100;
        this.salesTaxAmount = 0.05 * vehicleSold.getPrice();
        if (vehicleSold.getPrice() < 10000) {
            processingFee = 295;
        } else {
            processingFee = 295;
        }
        this.isFinancing = isFinancing;
        if (isFinancing && vehicleSold.getPrice() >= 10000) {
            double i = 0.425/12;
            int month = 48;
            monthlyPayment = (getTotalPrice() * 0.0425) / 12;
        } else if (isFinancing && vehicleSold.getPrice() < 10000){
            monthlyPayment = getTotalPrice() * Math.pow((1 + (0.0525/12)), 24) - getTotalPrice();
        }
    }
    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    @Override
    public double getTotalPrice() {
        return vehicleSold.getPrice() + recordingFee + processingFee + salesTaxAmount;
    }

    @Override
    public double getMonthlyPayment() {
     return Math.floor(monthlyPayment * 100) /100;
    }

    @Override
    public String toString() {
        return "SalesContract{" +
                "salesTaxAmount=" + salesTaxAmount +
                ", recordingFee=" + recordingFee +
                ", processingFee=" + processingFee +
                ", finance=" + isFinancing +
                ", monthlyPayment=" + monthlyPayment +
                ", date='" + date + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", vehicleSold=" + vehicleSold +
                ", totalPrice=" + totalPrice +
                ", monthlyPayment=" + monthlyPayment +
                '}';
    }
}
