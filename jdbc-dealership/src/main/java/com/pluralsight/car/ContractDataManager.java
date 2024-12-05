package com.pluralsight.car;

public class ContractDataManager {
    public void saveContract(Contract contract) {
        ContractFileManager contractFileManager = new ContractFileManager();
        contractFileManager.saveContractFile(contract);  // Pass the contract object directly
    }
}
